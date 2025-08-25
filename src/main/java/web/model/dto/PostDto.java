package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
    private int pno;
    private String ptitle;
    private String pcontent;
    private String pdate;
    private int pview;
    private int mno;
    private int cno;
    private String mid; // 작성자 ID (join)
    private String cname; // 카테고리 명칭 (join)
    private boolean host; // 작성자 여부 확인
}
