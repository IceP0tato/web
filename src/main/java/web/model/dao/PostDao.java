package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.PostDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDao extends Dao {
    public int writePost(PostDto postDto) {
        try {
            String sql = "insert into post(ptitle, pcontent, cno, mno) values(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, postDto.getPtitle());
            ps.setString(2, postDto.getPcontent());
            ps.setInt(3, postDto.getCno());
            ps.setInt(4, postDto.getMno());
            int count = ps.executeUpdate();

            if (count == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); // PK값 반환
                }
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getTotalCount(int cno) {
        try {
            String sql = "select count(*) from post where cno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PostDto> findAll(int cno, int startRow, int count) {
        List<PostDto> list = new ArrayList<>();
        try {
            // limit (시작 인덱스, 개수)
            String sql = "select * from post p inner join member m " +
                    "on p.mno = m.mno where p.cno = ? order by p.pno desc limit ?, ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cno);
            ps.setInt(2, startRow);
            ps.setInt(3, count);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PostDto postDto = new PostDto();
                postDto.setMno(rs.getInt("mno"));
                postDto.setCno(rs.getInt("cno"));
                postDto.setPcontent(rs.getString("pcontent"));
                postDto.setPdate(rs.getString("pdate"));
                postDto.setPview(rs.getInt("pview"));
                postDto.setPno(rs.getInt("pno"));
                postDto.setPtitle(rs.getString("ptitle"));
                postDto.setMid(rs.getString("mid"));
                list.add(postDto);
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
