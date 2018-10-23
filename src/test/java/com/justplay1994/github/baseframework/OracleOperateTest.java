package com.justplay1994.github.baseframework;

import com.justplay1994.github.baseframework.BaseFrameworkApplication;
import com.justplay1994.github.baseframework.dao.OracleOperate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Package: com.justplay1994.github.baseframework
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 9:32
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 9:32
 * @Update_Description: huangzezhou 补充
 **/
@Component
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseFrameworkApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OracleOperateTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void connectionOracle() throws SQLException {
        Connection con = dataSource.getConnection();
        ResultSet rs = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY) .executeQuery("SELECT * FROM all_tab_columns");
        rs.last();
        System.out.println(rs.getRow());
        rs.first();
        OracleOperate.rs2collection(rs);
    }

}
