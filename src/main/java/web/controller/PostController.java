package web.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PageDto;
import web.model.dto.PostDto;
import web.service.PostService;

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
}
