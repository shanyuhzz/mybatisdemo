package com.example.mybatisdemo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.mybatisdemo.model.CaiPiaoModel;
import com.example.mybatisdemo.util.OkHttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrawlDataService {
    @Autowired
    private OkHttpUtils okHttpUtils;

    public List<CaiPiaoModel> crawlData(){
        final List<CaiPiaoModel> models = new ArrayList<>();

        String body = okHttpUtils.doGet("https://webapi.sporttery.cn/gateway/jc/football/getMatchCalculatorV1.qry?poolCode=hhad,had&channel=c");

//        Document document = Jsoup.parse(body);

        JSONObject jsonObject = JSONObject.parseObject(body);
        String errorCode = jsonObject.getString("errorCode");
        boolean success = jsonObject.getBoolean("success");
        boolean emptyFlag = jsonObject.getBoolean("emptyFlag");

        if(success && !emptyFlag) {
            String value = jsonObject.getString("value");
            if(value != null){
                String matchInfoList = JSONObject.parseObject(value).getString("matchInfoList");
                JSONArray.parseArray(matchInfoList).stream().forEach(matchInfo -> {
                    String subMatchList = ((JSONObject)matchInfo).getString("subMatchList");
                    JSONArray subArray = JSONArray.parseArray(subMatchList);
                    List<CaiPiaoModel> subModels = subArray.stream().map(c -> {
                        JSONObject info = (JSONObject)c;

                        CaiPiaoModel model = new CaiPiaoModel();
                        model.setMatchName(info.getString("homeTeamAllName") + "-" + info.getString("awayTeamAllName"));
                        JSONObject hadInfo = JSONObject.parseObject(info.getString("had"));
                        model.setHadInfo("[" + hadInfo.getString("h") + "][" + hadInfo.getString("d")
                                + "][" +hadInfo.getString("a") + "]");
                        JSONObject hhadInfo = JSONObject.parseObject(info.getString("hhad"));
                        model.setHhadInfo("[" + hhadInfo.getString("h") + "][" +hhadInfo.getString("d")
                                + "][" +hhadInfo.getString("a") + "]");

                        return model;
                    }).collect(Collectors.toList());

                    models.addAll(subModels);
                });
            }
        }

        return models;
    }
}
