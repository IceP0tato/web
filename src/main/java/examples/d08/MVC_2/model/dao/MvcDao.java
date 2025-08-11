package examples.d08.MVC_2.model.dao;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository // Repository 빈 등록
public class MvcDao extends Dao {
    public void method() {
        System.out.println("Dao.method");
        try {
            String sql = "select * from mvc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("var1"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
