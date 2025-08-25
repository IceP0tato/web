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

    // 지정한 매개변수가 없으면 defaultValue 속성으로 기본값 대입
    @GetMapping("")
    public PageDto finaAllPost(@RequestParam(defaultValue = "1") int cno,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "5") int count) {
        return postService.findAllPost(cno, page, count);
    }
}
