package web.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.model.dto.ProductDto;
import web.service.FileService;
import web.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private FileService fileService; // 업로드 시 필요한 서비스

    // 제품 등록
    @PostMapping("/create")
    public int createProduct(@ModelAttribute ProductDto productDto, HttpSession session) {
        // 로그인 상태 확인 후, 비로그인이면 0 반환
        if (session.getAttribute("loginMno") == null) return 0;
        // 제품 정보를 DB 처리
        int loginMno = (int)session.getAttribute("loginMno");
        productDto.setMno(loginMno); // 현재 로그인된 회원 번호를 제품 등록 dto에 포함
        int result = productService.createProduct(productDto);
        // 업로드 파일이 존재하면 업로드 서비스 호출하여 처리
        // 제품 등록을 했고, 첨부파일이 비어있지 않고, 첨부파일 목록에서 첫 번째 첨부파일이 비어있지 않을 때
        if (result > 0 && !productDto.getUploads().isEmpty() && !productDto.getUploads().get(0).isEmpty()) {
            // List 타입을 반복문을 이용하여 여러 번 업로드
            for (MultipartFile multipartFile : productDto.getUploads()) {
                String fileName = fileService.fileUpload(multipartFile);
                if (fileName == null) return 0; // 파일명 null -> 업로드 실패 (반복문 중지)
                // 업로드 성공 -> 업로드된 파일명을 DB에 저장
                // result : 제품 등록된 pno, fileName : 업로드된 파일명
                boolean result2 = productService.createProductImage(result, fileName);
                if (result2 == false) return 0; // db에 이미지 저장 실패 시
            }
        }
        // 처리된 업로드 파일 DB 처리
        return result;
    }

    // 제품 전체 조회
    @GetMapping("/list")
    public List<ProductDto> getAllProduct() {
        return productService.getAllProduct();
    }

    // 제품 상세 조회
    @GetMapping("/find")
    public ProductDto getAllProduct(@RequestParam int pno) {
        return productService.getProduct(pno);
    }
}
