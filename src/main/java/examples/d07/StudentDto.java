package examples.d07;

import lombok.*;

// 롬복 (Lombok) : 설계에서 자주 사용되는 코드 자동 생성
// IntelliJ 환경에서 설치, Gradle 에서 설치 필요

@NoArgsConstructor // (컴파일 시) 빈 생성자 자동 생성
@AllArgsConstructor // (컴파일 시) 모든 매개변수를 가진 풀 생성자 자동 생성
@Getter // 모든 멤버변수의 Getter 생성
@Setter // 모든 멤버변수의 Setter 생성 (생략 시 VO [읽기 모드])
@ToString // 객체 조회 시 주소값 대신에 모든 멤버변수를 문자열로 출력
public class StudentDto {
    private int sno;
    private String sname;
    private int skor;
    private int smath;
    private String sdate;



}
