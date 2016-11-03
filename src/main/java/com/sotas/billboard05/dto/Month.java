package com.sotas.billboard05.dto;

public class Month {
    private int num;
    private int year;

    public Month(int num, int year) {
        this.num = num;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Month month = (Month) o;

        if (num != month.num) return false;
        return year == month.year;

    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "Month{" +
                "num=" + num +
                ", year=" + year +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
