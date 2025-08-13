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
            String sql = "select money.custNo, custName, grade, sum(price) from money_tbl_02 money join member_tbl_02 member " +
                    "on money.custNo = member.custNo " +
                    "group by member.custNo order by sum(price) desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MoneyDto dto = new MoneyDto();
                dto.setCustNo(rs.getInt("custNo"));
                dto.setCustName(rs.getString("custName"));
                dto.setGrade(rs.getString("grade"));
                dto.setPrice(rs.getInt("sum(price)"));
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
