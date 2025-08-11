package examples.d08.MVC_2.model.dao;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;

// 여러 DAO를 연동하는 중복 코드를 관리하는 슈퍼 클래스
public class Dao {
    private String url = "jdbc:mysql://localhost:3306/spring08";
    private String user = "root";
    private String password = "1234";

    // 하위 클래스에서 사용할 수 있도록 public 으로 사용
    public Connection conn;

    // 싱글톤이 아님
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
