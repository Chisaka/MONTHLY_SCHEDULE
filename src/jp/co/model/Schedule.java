package jp.co.model;

import java.io.Serializable;

public class Schedule implements Serializable {

    private int id = 0;
    private int year = 0;
    private int month = 0;
    private int day = 0;
    private String sche = "";
    private int money = 0;

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public String getSche() {
        return sche;
    }
    public void setSche(String sche) {
        this.sche = sche;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getID() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }



}
