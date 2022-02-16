package ru.gb.lesson.HW_4;

public class Triangle2 {
    private int k;
    private int l;
    private int m;

    public Triangle2(int k, int l, int m) {
        this.k = k;
        this.l = l;
        this.m = m;
    }
    public boolean isValid(){
        int maxSide = Math.max(k, Math.max(l,m));
        return maxSide < (k + l + m - maxSide);
    }

    public boolean hasPositiveSides(){
        return k > 0 && l > 0 && m > 0;
    }
    public double triangleArea() {
        if (!hasPositiveSides()) {
            throw new IllegalArgumentException("The sides must be positive");
        }
        if (!isValid()) {
            throw new IllegalArgumentException("The triangle must be valid");
        }
        double area =1.0/4.0 * Math.sqrt(Math.pow((Math.pow(k,2.0) + Math.pow(l,2.0) + Math.pow(m,2.0)),2.0) - 2.0 * (Math.pow(k,4.0) + Math.pow(l,4.0) + Math.pow(m,4.0)));
        return area;
    }
}
