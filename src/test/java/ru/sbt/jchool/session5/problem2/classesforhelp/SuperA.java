package ru.sbt.jchool.session5.problem2.classesforhelp;

public class SuperA {
    int aSuper=3;
    double qSuper=0.2;
    String aweSuper="asda";

    public SuperA() {
    }

    public SuperA(int aSuper, double qSuper, String aweSuper) {
        this.aSuper = aSuper;
        this.qSuper = qSuper;
        this.aweSuper = aweSuper;
    }

    public void setaSuper(int aSuper) {
        this.aSuper = aSuper;
    }

    public void setqSuper(double qSuper) {
        this.qSuper = qSuper;
    }

    public void setAweSuper(String aweSuper) {
        this.aweSuper = aweSuper;
    }

    public int getaSuper() {
        return aSuper;
    }

    public double getqSuper() {
        return qSuper;
    }

    public String getAweSuper() {
        return aweSuper;
    }
}
