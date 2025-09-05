package web.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PageDto;
import web.model.dto.PostDto;
import web.service.PostService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public int writePost(@RequestBody PostDto postDto, HttpSession session) {
        if (session.getAttribute("loginMno") == null) return 0;
        int loginMno = (int)session.getAttribute("loginMno");
        postDto.setMno(loginMno);
        return postService.writePost(postDto);
    }

    // 지정한 매개변수가 없으면 defaultValue 속성으로 기본값 대입, 필수 조건이 아니면 required = false 사용
    @GetMapping("")
    // localhost:8080/post/cno=1&page=1&count=5 // 1번 카테고리의 1페이지의 5개 게시물
    // localhost:8080/post/cno=1&page=1&count=5&key=ptitle&keyword=ai // 1번 카테고리의 1페이지에서 제목에 ai가 포함된 5개 게시물
    public PageDto findAllPost(@RequestParam(defaultValue = "1") int cno,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "5") int count,
                               @RequestParam(required = false) String key,
                               @RequestParam(required = false) String keyword) {
        return postService.findAllPost(cno, page, count, key, keyword);
    }

    @GetMapping("/view")
    public PostDto getPost(@RequestParam int pno, HttpSession session) {
        // viewHistory 속성 가져오기
        Object object = session.getAttribute("viewHistory");
        Map<Integer, String> viewHistory;
        if (object == null) {
            viewHistory = new HashMap<>();
        } else {
            // 속성이 존재하면 기존 자료 타입 변환
            viewHistory = (Map<Integer, String>) object;
        }

        // 오늘 날짜 가져오기 (LocalDate.now())
        String today = LocalDate.now().toString();
        String check = viewHistory.get(pno);
        // 현재 게시물에 오늘 날짜가 없거나 일치하지 않을 시 실행
        if (check == null || !check.equals(today)) {
            // 조회수 1 증가
            postService.incrementView(pno);
            // 세션에 조회수 기록/저장
            viewHistory.put(pno, today);
            // 세션 속성 업데이트
            session.setAttribute("viewHistory", viewHistory);
        }

        // 요청한 클라이언트 본인이 작성한 글인지 확인
        PostDto postDto = postService.getPost(pno);
        Object loginObject = session.getAttribute("loginMno");
        // 로그인 정보가 없으면 0, 있으면 int 타입 변환
        int loginMno = loginObject==null?0:(int)loginObject;
        // 조회한 게시물의 작성자 회원번호가 로그인 회원번호와 같으면 host = true
        if (postDto.getMno() == loginMno)
            postDto.setHost(true);

        return postDto;
    }

    @DeleteMapping("")
    public boolean deletePost(@RequestParam int pno) {
        return postService.deletePost(pno);
    }

    @PutMapping("")
    public int updatePost(@RequestBody PostDto postDto) {
        return postService.updatePost(postDto);
    }
}
