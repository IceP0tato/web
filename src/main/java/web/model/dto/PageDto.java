package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageDto {
    // 자바에서만 사용됨 (DB 없음)
    private int totalCount; // 전체 자료 개수
    private int currentPage; // 현재 페이지 번호
    private int totalPage; // 전체 페이지 수
    private int startBtn; // 페이징 버튼 시작 번호
    private int endBtn; // 페이징 버튼 끝 번호
    private int perCount; // 페이지 당 보이는 자료 수
    private Object data; // 페이징된 자료들
}
