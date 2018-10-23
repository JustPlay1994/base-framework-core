package com.justplay1994.github.baseframework.dao;

import com.justplay1994.github.baseframework.dao.model.Column;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.justplay1994.github.baseframework.dao
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 9:30
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 9:30
 * @Update_Description: huangzezhou 补充
 **/
public interface OracleOperate {

    /**
     * 批量的数据解析，ResultSet转换为collection
     * @param rs
     * @return
     * @throws SQLException
     */
    static List<HashMap> rs2collection(ResultSet rs) throws SQLException {
        List<HashMap> result = new ArrayList<>();
        while (rs.next()){
            rs.getMetaData();
            ResultSetMetaData metaData = rs.getMetaData();
            int colCount = metaData.getColumnCount();
            for (int i = 1; i <= colCount; ++i){
                String colType = metaData.getColumnTypeName(i);
                String colName = metaData.getColumnName(i);
                String colClassName = metaData.getColumnClassName(i);
                String colLable = metaData.getColumnLabel(i);
                String tableName = metaData.getTableName(i);
                Column col = new Column(colType, colName, colClassName, colLable, tableName);
                System.out.println(col);
            }
        }
        return result;
    }
}
