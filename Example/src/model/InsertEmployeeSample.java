package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployeeSample {
	 public static void main(String[] args) {
	        Connection conn = null;
	        try {
	            // データベースへ接続
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example?useUnicode=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "password");
	            // INSERT文を準備
	            String sql = "INSERT INTO employee (id, name, age) VALUES ('EMP003', '川島誠嗣', 24)";
	            // INSERTを実行
	            Statement stmt = conn.createStatement();
	            int result = stmt.executeUpdate(sql);
	            // 追加された行数を出力
	            System.out.println(result);
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	 // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	 }
}
