package com.xparsing.elasticsearch.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.elasticsearch.client.transport.TransportClient;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**将mysql的数据导入到es中
 * Created by user on 2018/9/4.
 */
public class MysqlImportES {
    static AtomicBoolean isInsert = new AtomicBoolean(true);
    static TransportClient client = null;
 /*   public static void main(String args[]){
        MysqlImportES.WriteData("content");
    }

*/

    // 写数据
    public static  List<Map<String,String>> WriteData(String tableName) {
        List<Map<String,String>> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = 1;
        List<String> columnName = Arrays.asList("trade_last_interval", "trade_first_interval");
        List<String> columnDateName = Arrays.asList("modify", "trade_first_time", "trade_last_time");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/bi?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
            conn = DriverManager.getConnection(url, "root", "root");
            System.out.println("写入数据开始，成功连接MySQL：" + tableName);

            String sql = "select * from " + tableName;
            ps = conn.prepareStatement(sql,
                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ps.setFetchSize(Integer.MIN_VALUE);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            ObjectMapper objectMapper = new ObjectMapper()
                    .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                    .setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                    .setPropertyNamingStrategy(
                            PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

            while (rs.next()) {  //while控制行数
                Map<String, String> map = new LinkedHashMap<>();
                //StringBuilder buffer = new StringBuilder();
                for (int i = 1; i <= colCount; i++) {
                    String name = rsmd.getColumnName(i);
                    String value = rs.getString(i);
                    if (value != null && !"".equals(value.trim()) && value.trim().length() > 0) {
                        //buffer.append("\"" + name + "\":\"" + value + "\"");
                        //buffer.append(",");
                        map.put(name, value);
                    } else {
                        map.put(name, "");
                    }
                }

                count++;

                if (map != null && map.size() > 0) {
                    list.add(map);
                }

                if (count % 200000 == 0) {
                    int number = list.size();
                    int jj = number / 200000;
                    System.out.println("index: " + count + ",jj: " + jj + ", number: " + number);
                    while (jj > 0) {
                        try {
                            Thread.sleep(2000 * jj);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        int number2 = list.size();
                        jj = number2 / 200000;
                        System.out.println("index2: " + count + ", jj: " + jj + ", number2: " + number2);
                    }
                }
            }
            isInsert = new AtomicBoolean(false);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(tableName + "数据写入完毕,共有数据：" + count);
      /*  try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return list;
    }
    }
