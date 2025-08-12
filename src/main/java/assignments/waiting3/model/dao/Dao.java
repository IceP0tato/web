package assignments.waiting3.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    public Dao() { connect(); }
    public Connection conn;
    private String url = "jdbc:mysql://localhost:3306/waiting";
    private String id = "root";
    private String pw = "1234";

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
