package com.example.demo.JDBCCall;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.example.demo.model.DmCnDvSuDung;

import oracle.jdbc.OracleTypes;

public class JDBCStoredProcedureRead {

	public static void findById(Long id) {
		Connection con = null;
		CallableStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call GETLIST(?,?)}");
			stmt.setLong(1, id);

			// register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(2, OracleTypes.CURSOR);

			stmt.execute();

			// read the OUT parameter now
			rs = (ResultSet) stmt.getObject(2);
			while (rs.next()) {
				System.out.println("ID=" + rs.getLong("ID") + ",Mã=" + rs.getString("MA") + ",Tên Ngắn="
						+ rs.getString("TEN_NGAN") + ",Địa Chỉ=" + rs.getString("DIA_CHI_CN") + ",Tên Đầy Đủ="
						+ rs.getString("TEN_DAY_DU") + ",Mã số thuế=" + rs.getString("MA_SO_THUE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void getAll() {
		Connection con = null;
		CallableStatement stmt = null;
		ResultSet rs = null;

		// Read User Inputs
		try {
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call GETALL(?)}");

			// register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(1, OracleTypes.CURSOR);

			stmt.execute();

			// read the OUT parameter now
			rs = (ResultSet) stmt.getObject(1);
			while (rs.next()) {
				System.out.println("ID=" + rs.getLong("ID") + ",Mã=" + rs.getString("MA") + ",Tên Ngắn="
						+ rs.getString("TEN_NGAN") + ",Địa Chỉ=" + rs.getString("DIA_CHI_CN") + ",Tên Đầy Đủ="
						+ rs.getString("TEN_DAY_DU") + ",Mã số thuế=" + rs.getString("MA_SO_THUE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
