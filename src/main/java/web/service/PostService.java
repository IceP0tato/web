package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.dao.PostDao;
import web.model.dto.PageDto;
import web.model.dto.PostDto;

import java.util.List;

@Service
@RequiredArgsConstructor // lombok : final 변수에 대한 생성자 제공
public class PostService {
    private final PostDao postDao;

    public int writePost(PostDto postDto) {
        return postDao.writePost(postDto);
    }

    // param : 카테고리 번호, 현재 페이지 번호, 페이지 당 정보 수
    public PageDto findAllPost(int cno, int page, int count) {
        // 시작 인덱스 번호 계산 (SQL limit 에서 필요)
        int startRow = (page-1)*count;
        // 자료 개수 구하기
        int totalCount = postDao.getTotalCount(cno);
        // 전체 페이지 수 구하기
        // 나머지가 있으면 (ex: 42개) 1페이지 (40+2)를 더 줘야 함
        int totalPage = totalCount%count==0?totalCount/count:totalCount/count+1;
        int btnCount = 5; // 한 화면에 보여지는 최대 버튼 수
        // 시작 버튼
        int startBtn = ((page-1)/btnCount)*btnCount+1;
        // 끝 버튼
        int endBtn = startBtn+btnCount-1;
        if (endBtn > totalPage) endBtn = totalPage; // 끝 버튼이 총 페이지 수보다 커지면 총 페이지 수로 끝 버튼 사용
        // 자료 구하기
        List<PostDto> postList = postDao.findAll(cno, startRow, count);
        // PageDto 구성하기
        PageDto pageDto = new PageDto();
        pageDto.setCurrentPage(page); // 현재 페이지 번호
        pageDto.setTotalPage(totalPage); // 전체 페이지 수
        pageDto.setPerCount(count); // 한 페이지 당 게시물 수
        pageDto.setTotalCount(totalCount); // 전체 게시물 수
        pageDto.setStartBtn(startBtn); // 시작 페이징 버튼 번호
        pageDto.setEndBtn(endBtn); // 끝 페이징 버튼 번호
        pageDto.setData(postList); // 페이징한 게시물 리스트
        return pageDto;
    }
}
