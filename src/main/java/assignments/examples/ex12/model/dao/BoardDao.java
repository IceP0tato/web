package assignments.examples.ex12.model.dao;

import assignments.examples.ex12.model.dto.BoardDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao extends Dao {
    public boolean boardWrite(BoardDto boardDto) {
        try {
            String sql = "insert into board(bcontent, bwriter) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setString(2, boardDto.getBwriter());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<BoardDto> boardPrint() {
        List<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // 객체를 먼저 생성한 후 setter로 값 대입하여 List에 추가
                BoardDto boardDto = new BoardDto();
                boardDto.setBno(rs.getInt("bno"));
                boardDto.setBcontent(rs.getString("bcontent"));
                boardDto.setBwriter(rs.getString("bwriter"));
                list.add(boardDto);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BoardDto boardFind(int bno) {
        try {
            String sql = "select * from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                BoardDto boardDto = new BoardDto();
                boardDto.setBno(rs.getInt("bno"));
                boardDto.setBcontent(rs.getString("bcontent"));
                boardDto.setBwriter(rs.getString("bwriter"));
                return boardDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean boardDelete(int bno) {
        try {
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean boardUpdate(BoardDto boardDto) {
        try {
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setInt(2, boardDto.getBno());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
