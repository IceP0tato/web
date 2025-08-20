package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.ProductDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao extends Dao {
    public int createProduct(ProductDto productDto) {
        try {
            String sql = "insert into product(pname, pprice, pcomment, plat, plng, mno) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // PK 리턴 설정
            ps.setString(1, productDto.getPname());
            ps.setInt(2, productDto.getPprice());
            ps.setString(3, productDto.getPcomment());
            ps.setDouble(4, productDto.getPlat());
            ps.setDouble(5, productDto.getPlng());
            ps.setInt(6, productDto.getMno());
            int count = ps.executeUpdate();
            if (count == 1) {
                ResultSet rs = ps.getGeneratedKeys(); // 등록된 레코드의 PK 가져오기
                if (rs.next()) {
                    return rs.getInt(1); // 첫 번째 레코드의 pno 반환
                }
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createProductImage(int pno, String fileName) {
        try {
            String sql = "insert into productimg(pimgname, pno) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fileName);
            ps.setInt(2, pno);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductDto> getAllProduct() {
        List<ProductDto> list = new ArrayList<>();
        try {
            String sql = "select * from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductDto dto = new ProductDto();
                dto.setPno(rs.getInt("pno"));
                dto.setPname(rs.getString("pname"));
                dto.setPprice(rs.getInt("pprice"));
                dto.setPcomment(rs.getString("pcomment"));
                dto.setPdate(rs.getString("pdate"));
                dto.setPlat(rs.getDouble("plat"));
                dto.setPlng(rs.getDouble("plng"));
                dto.setMno(rs.getInt("mno"));
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductImages(int pno) {
        List<String> list = new ArrayList<>();
        try {
            String sql = "select * from productimg where pno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String pimgname = rs.getString("pimgname");
                list.add(pimgname);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ProductDto getProduct(int pno) {
        try {
            String sql = "select * from product where pno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ProductDto dto = new ProductDto();
                dto.setPno(rs.getInt("pno"));
                dto.setPname(rs.getString("pname"));
                dto.setPprice(rs.getInt("pprice"));
                dto.setPcomment(rs.getString("pcomment"));
                dto.setPdate(rs.getString("pdate"));
                dto.setPlat(rs.getDouble("plat"));
                dto.setPlng(rs.getDouble("plng"));
                dto.setMno(rs.getInt("mno"));
                return dto;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
