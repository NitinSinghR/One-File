package org.example;

public class Card implements Cloneable{
    private final String name;
    private final String number;
    private final String date;

    Card(String name, String number, String date) {
        this.name = name;
        this.number = number;
        this.date = date;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean compare(Card verify) {
        return this.number.equals(verify.number);
    }
}