package assignments.examples.ex12.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    private String url = "jdbc:mysql://localhost:3306/exam12";
    private String user = "root";
    private String password = "1234";
    public Connection conn;

    public Dao() { connect(); }

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
