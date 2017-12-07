package com.soft.collection.base;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soft.collection.util.HttpHelper;
import com.soft.collection.util.StringHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/**
 * Created by jinsh on 2017/12/6.
 */
public class StockChannel {
    /**
     * 获取股票实时行情
     * @return
     */
    public StockBean getStockQuote (String code) {
        String ret = HttpHelper.sendPost("http://api.money.126.net/data/feed/0"+code+",money.api",null);
        return parseStockBaseInfo(ret);
    }

    /**
     * 解析股票信息
     * @param info
     * @return
     */
    private StockBean parseStockBaseInfo(String info) {
        if (!isValid(info)) {
            return null;
        }
        String rgex = "_ntes_quote_callback\\((.*?)\\);";
        String datas = StringHelper.getSubUtilSimple(info,rgex);
        JSONObject json = JSONObject.parseObject(datas);
        Set<String> sets = json.keySet();
        System.out.println(sets.iterator().next());
        return null;
    }

    /**
     * 验证返回值是否有效
     * @param info
     * @return
     */
    private boolean isValid(String info) {
        if (info == null || info.length() == 0
                || info.indexOf("_ntes_quote_callback") == -1
                || info.indexOf("_ntes_quote_callback({ });") != -1) {
            return false;
        }
        return true;
    }
    /**
     * 更新股票代码
     * @return
     */
    public boolean refreshCodes (String froCode) {
        FileWriter fw = null;
        try {
            String filename = froCode.equals("060") ? "SH.txt" : "SZ.txt";
            fw = new FileWriter("D:/"+filename);
            for (int i = 0; i < 9999; i++) {
                System.out.println(i);
                String ret = HttpHelper.sendPost("http://api.money.126.net/data/feed/"+froCode+String.format("%04d",i)+",money.api",null);
                if (isValid(ret)) {
                    String rgex = "_ntes_quote_callback\\((.*?)\\);";
                    JSONObject json = JSONObject.parseObject(StringHelper.getSubUtilSimple(ret,rgex));
                    Set<String> sets = json.keySet();
                    fw.write(sets.iterator().next()+"\r\n");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
