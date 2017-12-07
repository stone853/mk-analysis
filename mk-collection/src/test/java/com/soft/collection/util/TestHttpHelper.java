package com.soft.collection.util;

import com.soft.collection.base.StockChannel;
import com.soft.collection.task.ThreadRefreshStocks;
import org.junit.Test;

/**
 * Created by jinsh on 2017/12/6.
 */
public class TestHttpHelper {
    @Test
    public void testSendPost(){
        HttpHelper req = new HttpHelper();
        String ret = req.sendPost("http://api.money.126.net/data/feed/0603383,money.api",null);
        System.out.println(ret);
    }

    @Test
    public void testStockQuote() {
        for (int i = 0; i < 9999; i++) {
            StockChannel st = new StockChannel();
            st.getStockQuote("60"+String.format("%04d",i));
        }
    }

    @Test
    public void testRefreshStocks () {
        ThreadRefreshStocks st = new ThreadRefreshStocks();
        st.refreshStocks();
    }
}
