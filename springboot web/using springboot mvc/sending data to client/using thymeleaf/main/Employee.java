package com.kenny.SpringBootWeb1;

public class Employee {
    private int aid;
    private String aname;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                '}';
    }
}
