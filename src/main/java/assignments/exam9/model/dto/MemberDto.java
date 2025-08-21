package assignments.exam9.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
    private int mno;
    private String mid;
    private String mpwd;
    private MultipartFile mimg;
    private int mimgno;
    private String mimgname;
}
