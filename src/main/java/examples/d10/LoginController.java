package examples.d10;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/d10")
public class LoginController {
    // console 에서는 static int loginMno 로 로그인 상태 구현

    @PostMapping("/login") // 패스워드를 입력받으므로 queryString 보다 body 사용
    public boolean login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        // HttpServletRequest : HTTP 요청 정보를 갖는 객체
        // 통신 요청한 클라이언트(사용자)의 정보 확인
        System.out.println(request.getRemoteAddr()); // IP 확인
        System.out.println(request.getRemotePort()); // PORT 확인
        System.out.println(request.getHeader("User-Agent")); // 브라우저 정보 확인

        // 세션 (톰캣 서버 내 저장소 [key-value / MAP 컬렉션 사용]) 정보 가져오기
        HttpSession session = request.getSession();
        System.out.println(session.getId()); // 세션 식별 번호 : 브라우저마다, pc 마다 다르게 할당됨
        System.out.println(session.getCreationTime()); // 세션 생성 시간(ms) : 최초 요청한 시간
        System.out.println(session.getLastAccessedTime()); // 세션 마지막 접근 시간(ms [밀리초 : 1000분의 1초])
        System.out.println(session.getMaxInactiveInterval()); // 세션 최대 유지 시간(초)

        // 세션 속성 추가
        // loginMno 라는 속성명으로 데이터 3 저장
        session.setAttribute("loginMno", 3); // .setAttribute("속성명", 속성값);
        return true;
    }

    @GetMapping("/info")
    public boolean info(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // 개발자 의도와 상관없이 값은 무조건 Object 타입
        // 서버 재부팅 시 모든 세션 정보는 초기화됨
        Object obj = session.getAttribute("loginMno");
        if (obj == null) return false;
        // 타입 변환 필요
        int loginMno = (int)obj;
        System.out.println(loginMno);
        return true;
    }

    @DeleteMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // 특정 속성 제거
        session.removeAttribute("loginMno");
        // 전체 속성 제거
        // session.invalidate();
        return true;
    }
}
