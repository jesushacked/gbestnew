package com.yoo.model;

/**
 *
 */
public class Result {
    private final String res;
    private final int resNum;
    private final int resNumOf;

    public Result(final String res, final int resNum, final int resNumOf) {
        this.res = res;
        this.resNum = resNum;
        this.resNumOf = resNumOf;
    }

    public String getRes() {
        return res;
    }

    public int getResNum() {
        return resNum;
    }

    public int getResNumOf() {
        return resNumOf;
    }
}
