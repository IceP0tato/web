package assignments.exam1.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MoneyDto {
    private int custNo, saleNol, pCost, amount, price;
    private String pCode, sDate;
    private String custName, grade;
}
