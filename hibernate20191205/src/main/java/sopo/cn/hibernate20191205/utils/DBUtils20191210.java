package sopo.cn.hibernate20191205.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils20191210 {
	public static Connection getConnection() {
		Connection connection = null;
		DataSource dataSource = new ComboPooledDataSource("mysql");
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
