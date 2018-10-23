package com.justplay1994.github.baseframework.dao.model;

/**
 * @Package: com.justplay1994.github.baseframework.dao.model
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 10:24
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 10:24
 * @Update_Description: huangzezhou 补充
 **/
public class Column {
    String colType;
    String colName;
    String colClassName;
    String colLabel;
    String tbName;
    public Column(String colType, String colName, String colClassName, String colLabel, String tbName){
        this.colType=colType;
        this.colName=colName;
        this.colClassName=colClassName;
        this.colLabel=colLabel;
        this.tbName = tbName;
    }

    public String toString(){
        return "Column=[tableName="+tbName+"colName="+colName+", colType="+colType+", colClassName="+colClassName+", colLabel="+colLabel+"]";
    }
}
