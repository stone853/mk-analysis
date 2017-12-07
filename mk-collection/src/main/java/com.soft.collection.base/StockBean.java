package com.soft.collection.base;

/**
 * Created by jinsh on 2017/12/6.
 */
public class StockBean {
    //股票代码
    private String code;
    //股票名称
    private String name;
    //涨跌幅
    private double percent;
    //最高
    private double high;
    //最低
    private double low;
    //开盘
    private double open;
    // 昨收盘
    private double yestclose;
    //成交量
    private Long volume;
    //成交额
    private double turnover;
    //最后更新时间
    private String update;

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getUpdate() {
        return update;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getYestclose() {
        return yestclose;
    }

    public void setYestclose(double yestclose) {
        this.yestclose = yestclose;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }
}
