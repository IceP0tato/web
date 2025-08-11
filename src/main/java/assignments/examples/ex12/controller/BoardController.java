package assignments.examples.ex12.controller;

import assignments.examples.ex12.model.dto.BoardDto;
import assignments.examples.ex12.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired private BoardService boardService;

    @PostMapping("")
    public boolean boardWrite(@RequestBody BoardDto boardDto) {
        return boardService.boardWrite(boardDto);
    }

    @GetMapping("")
    public List<BoardDto> boardPrint() {
        return boardService.boardPrint();
    }

    @GetMapping("/find")
    public BoardDto boardFind(@RequestParam int bno) {
        return boardService.boardFind(bno);
    }

    @DeleteMapping("")
    public boolean boardDelete(@RequestParam int bno) {
        return boardService.boardDelete(bno);
    }

    @PutMapping("")
    public boolean boardUpdate(@RequestBody BoardDto boardDto) {
        return boardService.boardUpdate(boardDto);
    }
}
