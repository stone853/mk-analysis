package com.soft.collection.task;

import com.soft.collection.base.StockChannel;

/**
 * Created by jinsh on 2017/12/7.
 */
public class ThreadRefreshStocks {
    class RefreshStocks implements Runnable {
        private String froCode;
        public RefreshStocks (String froCode) {
            this.froCode = froCode;
        }
        public void run() {
            StockChannel stockChannel = new StockChannel();
            stockChannel.refreshCodes(froCode);
        }
    }

    public void refreshStocks () {
        System.out.println("laile");
        Thread sht = new Thread(new RefreshStocks("060"));
        Thread szt = new Thread(new RefreshStocks("100"));
        sht.start();
        szt.start();
        System.out.println("zoule");
    }

    public static void main(String args[]) {
        ThreadRefreshStocks b = new ThreadRefreshStocks();
        b.refreshStocks();
    }
}
