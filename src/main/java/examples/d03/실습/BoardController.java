package examples.d03.실습;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

class BoardDto {
    private int bno;
    private String bcontent, bwriter;

    public BoardDto() {
    }

    public BoardDto(int bno, String bcontent, String bwriter) {
        this.bno = bno;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }
}


@RestController
public class BoardController {
    ArrayList<BoardDto> list = new ArrayList<>();
    int bno = 1;

    @PostMapping("/board")
    public boolean boardWrite(@RequestBody BoardDto boardDto) {
        System.out.println("boardDto = " + boardDto);
        BoardDto dto = new BoardDto(bno++, boardDto.getBcontent(), boardDto.getBwriter());
        list.add(dto);
        return true;
    }

    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint() {
        return list;
    }

    @GetMapping("/board/detail")
    public BoardDto boardDetail(int bno) {
        for (BoardDto dto : list) {
            if (dto.getBno() == bno) {
                return dto;
            }
        }
        return null;
    }

    @DeleteMapping("/board")
    public boolean boardDelete(int bno) {
        for (BoardDto dto : list) {
            if (dto.getBno() == bno) {
                list.remove(dto);
                return true;
            }
        }
        return false;
    }

    @PutMapping("/board")
    public boolean boardUpdate(int bno, String bcontent) {
        for (BoardDto dto : list) {
            if (dto.getBno() == bno) {
                dto.setBcontent(bcontent);
                return true;
            }
        }
        return false;
    }
}
