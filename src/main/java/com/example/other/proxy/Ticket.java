package com.example.other.proxy;

public class Ticket {
    public void getTicket(){
        System.out.println("Buy a ticket.");
    }

    final public void refundTicket(){
        System.out.println("Refund a ticket.");
    }
}
