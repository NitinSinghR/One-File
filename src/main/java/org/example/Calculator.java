package org.example;

abstract class Calculator
{
    private int a;
    private int b;
    public void set(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    public int getA()
    {
        return a;
    }
    public int getB()
    {
        return b;
    }
    abstract int calculate(int a,int b);
}