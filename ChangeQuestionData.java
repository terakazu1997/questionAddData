package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ChangeQuestionData {
    protected Connection conn = null;
    protected PreparedStatement ps  = null;
    protected Statement st = null;

    public void initConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        // (1) 接続用のURIを用意する(必要に応じて認証指示user/passwordを付ける)
        String uri = "jdbc:mysql://localhost:3306/test_mysql_database";
        String user = "root";
        String password = "admin";
        // (2) DriverManagerクラスのメソッドで接続する
        conn = DriverManager.getConnection(uri,user,password);
        st = conn.createStatement();
        st.executeUpdate("DELETE FROM FMUQ WHERE CATEGORY = 'XX'");
        st.executeUpdate("DELETE FROM FMUA WHERE CATEGORY = 'XX'");
        st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 問題生成
    public void makeTestCheckQuestion(String createString) {
        initConnectionDB();
        try {
            for(int i =1; i<= 10; i++) {
                ps = conn.prepareStatement("insert into FMUQ VALUES('XX','XX',?,?,?,'')");
                ps.setInt(1, i);
                ps.setString(2, createString);
                ps.setString(3, createString);
                ps.executeUpdate();
                for(int j=1; j<=4; j++) {
                    ps = conn.prepareStatement("INSERT INTO FMUA VALUES ('XX','XX',?,?,?,1,'');");
                    ps.setInt(1, i);
                    ps.setInt(2, j);
                    ps.setString(3, createString);
                    ps.executeUpdate();
                }
            }
            ps.close();
         } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 0バイトの問題作成
    public void make0ByteQuestion() { makeTestCheckQuestion("");}
    // 4000バイト(半角)の問題作成
    public void make4000ByteHankakuQuestion() {
        makeTestCheckQuestion("4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000Byteﾊﾝｶｸﾉﾓﾝﾀﾞｲ4000");
    }
    // 4000バイト(全角)の問題作成
    public void make4000ByteZenkakuQuestion() {
        makeTestCheckQuestion("4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ問題4000Byte全角ノ");
    }
    // 特殊文字半角問題作成
    public void makeSpecialHankakuQuestion() {makeTestCheckQuestion("!\"#$%&'()-=≠¥¥^|~\\ /+*….,?_[]{}<>:;`@");}
    // 特殊文字全角文字生成
    public void makeSpecialZenkakuQuestion() {makeTestCheckQuestion("！”＃＄％＆’（）ー≠￥＾｜〜＼　／＋＊…。、？_「」『』＜＞：；｀＠");}
    // HTMLタグ文字生成
    public void makeHTMLTagQuestion() {
        makeTestCheckQuestion("<strong>強調</strong><u>下線後ろ改行</u><br><p>段落</p><em>斜体</em><font style=\"background-color: red;\">赤色の背景</font><font style=\"color: green;\">緑の文字色</font><font style=\"color: blue\">青の文字色</font><font style=\"background-color:red;color:white\">赤色の背景、白の文字色</font><font face=\"MSP明朝\">MSP明朝の文字</font>");
    }

    public void makePassCheckQuestion (Map<Integer, List<Object>> passMap ) {        initConnectionDB();
        try {
            for(int i =1; i<= 10; i++) {
                ps = conn.prepareStatement(
                     "insert into FMUQ VALUES('XX','XX',?,?,?,'')"
                 );
                ps.setInt(1, i);
                ps.setString(2, passMap.get(i).get(0).toString());
                ps.setString(3, passMap.get(i).get(0).toString());
                ps.executeUpdate();
                for(int j=4; j>=1; j--) {
                    ps = conn.prepareStatement(
                        "INSERT INTO FMUA VALUES ('XX','XX',?,?,?,?,'');"
                    );
                    ps.setInt(1, i);
                    ps.setInt(2, j);
                    ps.setString(3, passMap.get(i).get(0).toString());
                    switch(j) {
                        case 1:
                            ps.setInt(4, ((Integer) passMap.get(i).get(j)));
                            break;
                        case 2:
                            ps.setInt(4,  ((Integer) passMap.get(i).get(j)));
                            break;
                        case 3:
                            ps.setInt(4,  ((Integer) passMap.get(i).get(j)));
                            break;
                        case 4:
                            ps.setInt(4,  ((Integer) passMap.get(i).get(j)));
                            break;
                    }
                    ps.executeUpdate();
                }
            }
            ps.close();
         } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }
    public void makePassCheckQuestion1 () {
        Map<Integer, List<Object>> passMap = new LinkedHashMap<Integer,List<Object>>(){
            {
                put(1,Arrays.asList("1つ目の選択肢のみ正答",1,0,0,0));
                put(2,Arrays.asList("2つ目の選択肢のみ正答",0,1,0,0));
                put(3,Arrays.asList("3つ目の選択肢のみ正答",0,0,1,0));
                put(4,Arrays.asList("4つ目の選択肢のみ正答",0,0,0,1));
                put(5,Arrays.asList("1つ目と2つ目の選択肢のみ正答",1,1,0,0));
                put(6,Arrays.asList("1つ目の選択肢のみ正答",1,0,0,0));
                put(7,Arrays.asList("2つ目の選択肢のみ正答",0,1,0,0));
                put(8,Arrays.asList("3つ目の選択肢のみ正答",0,0,1,0));
                put(9,Arrays.asList("4つ目の選択肢のみ正答",0,0,0,1));
                put(10,Arrays.asList("1つ目と2つ目の選択肢のみ正答",1,1,0,0));
            }
        };
        makePassCheckQuestion(passMap);
    }
    public void makePassCheckQuestion2 () {
        Map<Integer, List<Object>> passMap = new LinkedHashMap<Integer,List<Object>>(){
            {
                put(1,Arrays.asList("1つ目と3つ目の選択肢のみ正答",1,0,1,0));
                put(2,Arrays.asList("1つ目と4つ目の選択肢のみ正答",1,0,0,1));
                put(3,Arrays.asList("2つ目と3つ目の選択肢のみ正答",0,1,1,0));
                put(4,Arrays.asList("2つ目と4つ目の選択肢のみ正答",0,1,0,1));
                put(5,Arrays.asList("3つ目と4つ目の選択肢のみ正答",0,0,1,1));
                put(6,Arrays.asList("1つ目と3つ目の選択肢のみ正答",1,0,1,0));
                put(7,Arrays.asList("1つ目と4つ目の選択肢のみ正答",1,0,0,1));
                put(8,Arrays.asList("2つ目と3つ目の選択肢のみ正答",0,1,1,0));
                put(9,Arrays.asList("2つ目と4つ目の選択肢のみ正答",0,1,0,1));
                put(10,Arrays.asList("3つ目と4つ目の選択肢のみ正答",0,0,1,1));
            }
        };
        makePassCheckQuestion(passMap);
    }
    public void makePassCheckQuestion3 () {
        Map<Integer, List<Object>> passMap = new LinkedHashMap<Integer,List<Object>>(){
            {
                put(1,Arrays.asList("1つ目と2つ目と3つ目の選択肢のみ正答",1,1,1,0));
                put(2,Arrays.asList("1つ目と3つ目と4つ目の選択肢のみ正答",1,0,1,1));
                put(3,Arrays.asList("1つ目と2つ目と4つ目の選択肢のみ正答",1,1,0,1));
                put(4,Arrays.asList("2つ目と3つ目と4つ目の選択肢のみ正答",0,1,1,1));
                put(5,Arrays.asList("全ての選択肢正答",1,1,1,1));
                put(6,Arrays.asList("1つ目と2つ目と3つ目の選択肢のみ正答",1,1,1,0));
                put(7,Arrays.asList("1つ目と3つ目と4つ目の選択肢のみ正答",1,0,1,1));
                put(8,Arrays.asList("1つ目と2つ目と4つ目の選択肢のみ正答",1,1,0,1));
                put(9,Arrays.asList("2つ目と3つ目と4つ目の選択肢のみ正答",0,1,1,1));
                put(10,Arrays.asList("全ての選択肢正答",1,1,1,1));
            }
        };
        makePassCheckQuestion(passMap);
    }
}
