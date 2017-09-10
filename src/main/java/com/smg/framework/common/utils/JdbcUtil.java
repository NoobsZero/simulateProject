package com.smg.framework.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * JDBC工具类
 *
 * @author justincai
 */
public class JdbcUtil {

    private static final Log log = LogFactory.getLog(JdbcUtil.class);

    // 定义数据库的链接
    private Connection conn;
    // 定义sql语句的执行对象
    private PreparedStatement pstmt;
    // 定义查询返回的结果集合
    private ResultSet rs;

    // 初始化
    public JdbcUtil(String driver, String url, String username, String password) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException | SQLException e) {
            log.error("数据库连接失败！", e);
        }
    }

    // 更新数据
    public boolean updateByParams(String sql, List params) throws SQLException {
        // 影响行数
        int result = -1;
        pstmt = conn.prepareStatement(sql);
        int index = 1;
        // 填充sql语句中的占位符
        if (null != params && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(index++, params.get(i));
            }
        }
        result = pstmt.executeUpdate();
        return result > 0;
    }

    // 查询多条记录
    public List<Map> selectByParams(String sql, List params) throws SQLException {
        List<Map> list = new ArrayList<>();
        int index = 1;
        pstmt = conn.prepareStatement(sql);
        if (null != params && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(index++, params.get(i));
            }
        }
        rs = pstmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int cols_len = metaData.getColumnCount();
        while (rs.next()) {
            Map map = new HashMap();
            for (int i = 0; i < cols_len; i++) {
                String cols_name = metaData.getColumnName(i + 1);
                Object cols_value = rs.getObject(cols_name);
                if (null == cols_value) {
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);
        }
        return list;
    }

    // 释放连接
    public void release() {
        try {
            if (null != rs) {
                rs.close();
            }
            if (null != pstmt) {
                pstmt.close();
            }
            if (null != conn) {
                conn.close();
            }
        } catch (SQLException e) {
            log.error("释放数据库连接失败！", e);
        }
        System.out.println("释放数据库连接");
    }
}
