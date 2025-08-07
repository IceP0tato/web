package examples.d07;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    @Getter
    private static final StudentDao instance = new StudentDao();
    private StudentDao() { connect(); }
    private String db_url = "jdbc:mysql://localhost:3306/spring07";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean save(StudentDto studentDto) {
        try {
            String sql = "insert into student(sname, skor, smath) values(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, studentDto.getSname());
            ps.setInt(2, studentDto.getSkor());
            ps.setInt(3, studentDto.getSmath());

            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<StudentDto> find() {
        List<StudentDto> list = new ArrayList<>();
        try {
            String sql = "select * from student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { // 하나 조회할 때는 if (rs.next()), 다수 조회할 때는 while (rs.next()) 사용
                StudentDto studentDto = new StudentDto(
                        rs.getInt(1),
                        rs.getString("sname"),
                        rs.getInt("skor"),
                        rs.getInt("smath"),
                        rs.getString("sdate")
                );
                list.add(studentDto);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
