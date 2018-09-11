/*
 * Copyright 2018-2050 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.geercode.creed.archetype.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description : mysql数据库配置</p>
 * <p>Created on  : 2018-09-07 14:48</p>
 *
 * @author LiKe
 */
public class MysqlDataSourceConfig {
    /**驱动*/
    private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    /**数据库名*/
    private String dbname = "jufan_crawler";
    /**数据库连接地址*/
    private String url = "jdbc:mysql://192.168.21.22:3306/" + dbname + "?characterEncoding=UTF-8";
    /**用户名*/
    private String username = "root";
    /**密码*/
    private String password = "We-are-hero-2015";
    /**连接*/
    private Connection conn;

    /**
     * 构造mysql配置元数据
     */
    public MysqlDataSourceConfig(String dbUrl, String dbname, String username, String password) {
        this.url = dbUrl;
        this.dbname = dbname;
        this.password = password;
        this.username = username;
        this.conn = getConnection();
    }

    private Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            new RuntimeException("数据库连接失败！", ex).printStackTrace();
        }
        return conn;
    }

    /**
     * 获取表字段信息
     */
    public List<TableColumnInfo> getTableColumns(String tableName) throws Exception {
        final String sql = " SELECT column_name,column_type ,column_comment,column_key,c.table_name,t.table_comment"
                + " FROM information_schema.columns  c "
                + " LEFT JOIN information_schema.tables  t"
                + "ON c.table_name=t.table_name AND c.TABLE_SCHEMA=t.TABLE_SCHEMA "
                + " WHERE c.TABLE_SCHEMA ? AND c.table_name = ? ORDER BY ordinal_position ";
        List<TableColumnInfo> tables = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, dbname);
            pst.setString(2, tableName);
            rs = pst.executeQuery();
            while (rs.next()) {
                TableColumnInfo info = new TableColumnInfo();
                info.setTableName(rs.getString("table_name"));
                info.setTableComment(rs.getString("table_comment"));
                info.setColumnComment(rs.getString("column_comment"));
                info.setColumnKey(rs.getString("column_key"));
                info.setColumnName(rs.getString("column_name"));
                info.setColumnType(rs.getString("column_type"));
                tables.add(info);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return tables;
    }

    private void closeConnection(Connection connection, Statement pst, ResultSet rs) {
        try {
            rs.close();
            pst.close();
        } catch (Exception ex) {
            new RuntimeException("关闭连接失败", ex).printStackTrace();
        }
    }
}
