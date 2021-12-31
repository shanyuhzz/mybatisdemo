package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.model.CaiPiaoModel;
import com.example.mybatisdemo.service.CrawlDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class CrawlHandler {
    @Autowired
    private CrawlDataService crawlDataService;


    @GetMapping("/crawl")
    public List<CaiPiaoModel> crawlData(){
        return crawlDataService.crawlData();
    }
}
