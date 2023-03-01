package org.example;

public class Points implements Cloneable {
    private final int x1;
    private final int y1;

    Points(int x, int y) {
        this.x1 = x;
        this.y1 = y;
    }

    public String equals(int x, int y) {
        if (x1 == x && y == y1) {
            return "true";
        } else {
            return "false";
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}