package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private int pno;
    private String pname;
    private int pprice;
    private String pcomment;
    private String pdate;
    private double plat;
    private double plng;
    private int mno;
    // 업로드에 사용할 multipartFile 객체 (list 타입으로 여러 개 첨부파일 받아오기)
    private List<MultipartFile> uploads;
    // 조회 시 업로드된 파일명을 문자열로 조회하기
    private List<String> images;
    // 판매자의 아이디
    private int mid;
}
