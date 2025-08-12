package assignments.waiting3.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WaitingDto {
    private int num;
    private String phone;
    private int count;
    private String date;
}
