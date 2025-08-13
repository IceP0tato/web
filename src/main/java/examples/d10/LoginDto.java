package examples.d10;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data // getter, setter, tostring 포함
public class LoginDto {
    private int mno;
    private String mid;
    private String mpw;
}
