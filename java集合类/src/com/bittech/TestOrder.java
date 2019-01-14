package com.stream;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class TestOrder {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Iphone",8999.99,10));
        orderList.add(new Order("外星人笔记本",12999.99,5));
        orderList.add(new Order("MacBookPro",18999.99,5));
        orderList.add(new Order("Java从入门到放弃",9.99,20000));
        orderList.add(new Order("中性笔",1.99,200000));

        //1.准备一个集合，包含5个订单
        //2.统计分析
        //map 计算每一个订单的金额  reduce 汇总所有订单的金额
        /*double total = orderList.stream().mapToDouble(o->o.getPrice() * o.getAmount()).
                reduce((sum,e) -> sum+e).orElse(0);//假设结果不为double类型，直接返回0
        System.out.println(total);*/

        //统计分析
        //变量所有的order，以及每个订单的金额，然后做统计
        //1.订单数量 2.最大订单 3.最小订单 4.平均订单金额 5.订单总金额
        DoubleSummaryStatistics summaryStatistics = orderList.stream().
                mapToDouble(o->o.getPrice() * o.getAmount()).summaryStatistics();
        System.out.println("1.订单数量"+ summaryStatistics.getCount());
        System.out.println("2.最大订单"+ summaryStatistics.getMax());
        System.out.println("3.最小订单"+ summaryStatistics.getMin());
        System.out.println("4.平均订单金额"+ summaryStatistics.getAverage());
        System.out.println("5.订单总金额"+ summaryStatistics.getSum());
    }
}

class Order{
    private String title;
    private double price;
    private int amount;

    public Order(String title, double price, int amount) {
        this.title = title;
        this.price = price;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
