package assignments.waiting1.model.dao;

import assignments.waiting1.model.dto.WaitingDto;

import java.sql.*;
import java.util.ArrayList;

public class WaitingDao {
    private WaitingDao() { connect(); }
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance() {
        return instance;
    }
    private String url = "jdbc:mysql://localhost:3306/waiting";
    private String id = "root";
    private String pw = "1234";
    private Connection conn;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean waitingInsert(WaitingDto dto) {
        PreparedStatement ps = null;
        try {
            String sql = "insert into list(phone, count) values(?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getPhone());
            ps.setInt(2, dto.getCount());

            int count = ps.executeUpdate();
            return count == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<WaitingDto> waitingSelect() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<WaitingDto> list = new ArrayList<>();
        try {
            String sql = "select * from list";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int num = rs.getInt("num");
                String phone = rs.getString("phone");
                int count = rs.getInt("count");
                WaitingDto dto = new WaitingDto(num, phone, count);
                list.add(dto);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean waitingDelete(int num) {
        PreparedStatement ps = null;
        try {
            String sql = "delete from list where num = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, num);

            int count = ps.executeUpdate();
            return count == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean waitingUpdate(WaitingDto dto) {
        PreparedStatement ps = null;
        try {
            String sql = "update list set count = ? where num = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getCount());
            ps.setInt(2, dto.getNum());

            int count = ps.executeUpdate();
            return count == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
