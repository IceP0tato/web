package examples.d02.실습;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Dto {
    int bno;
    String btitle;

    public Dto() {
    }

    public Dto(int bno, String btitle) {
        this.bno = bno;
        this.btitle = btitle;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }
}

@Controller
public class RestController {
    @PostMapping("/exam1/board")
    @ResponseBody
    public boolean write() {
        return true;
    }

    @GetMapping("/exam1/board")
    @ResponseBody
    public List<Dto> viewAll() {
        ArrayList<Dto> list = new ArrayList<>();
        list.add(new Dto());
        list.add(new Dto());
        return list;
    }

    @GetMapping("/exam1/board/view")
    @ResponseBody
    public Map<String, String> view() {
        Map<String, String> map = new HashMap<>();
        map.put("bno", "");
        map.put("btitle", "");
        return map;
    }

    @PutMapping("/exam1/board")
    @ResponseBody
    public boolean update() {
        return true;
    }

    @DeleteMapping("/exam1/board")
    @ResponseBody
    public int delete() {
        return 3;
    }
}
