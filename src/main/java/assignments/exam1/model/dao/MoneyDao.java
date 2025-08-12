package assignments.exam1.model.dao;

import assignments.exam1.model.dto.MoneyDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MoneyDao extends Dao {
    public List<MoneyDto> getMoneyList() {
        try {
            List<MoneyDto> list = new ArrayList<>();
            String sql = "select * from money_tbl_02 join member_tbl_02 on " +
                    "money_tbl_02.custNo = member_tbl_02.custNo " +
                    "order by price";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MoneyDto dto = new MoneyDto();
                dto.setCustNo(rs.getInt("custNo"));
                dto.setCustName(rs.getString("custName"));
                dto.setGrade(rs.getString("grade"));
                dto.setPrice(rs.getInt("price"));
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
