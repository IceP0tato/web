package assignments.exam1.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDto {
    private int custNo;
    private String custName, phone, address, joinDate, grade, city;
}
