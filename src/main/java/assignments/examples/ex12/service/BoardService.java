package assignments.examples.ex12.service;

import assignments.examples.ex12.model.dao.BoardDao;
import assignments.examples.ex12.model.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired private BoardDao boardDao;

    public boolean boardWrite(BoardDto boardDto) {
        return boardDao.boardWrite(boardDto);
    }

    public List<BoardDto> boardPrint() {
        return boardDao.boardPrint();
    }

    public BoardDto boardFind(int bno) {
        return boardDao.boardFind(bno);
    }

    public boolean boardDelete(int bno) {
        return boardDao.boardDelete(bno);
    }

    public boolean boardUpdate(BoardDto boardDto) {
        return boardDao.boardUpdate(boardDto);
    }
}
