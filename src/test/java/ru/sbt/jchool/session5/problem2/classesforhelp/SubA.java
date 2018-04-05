package ru.sbt.jchool.session5.problem2.classesforhelp;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashSet;
import java.util.Set;
@JsonPropertyOrder({ "subQW", "subSet", "aSuper", "qSuper", "aweSuper" })

public class SubA extends SuperA {
    String subQW="aSADFA";
    Set subSet =new HashSet<String>();

    public SubA() {
    }


    public SubA(int aSuper, double qSuper, String aweSuper, String subQW) {
        super(aSuper, qSuper, aweSuper);
        this.subQW = subQW;
    }

    public void setSubQW(String subQW) {
        this.subQW = subQW;
    }

    public void setSubSet(Set subSet) {
        this.subSet = subSet;
    }

    public String getSubQW() {
        return subQW;
    }

    public Set getSubSet() {
        return subSet;
    }
}

