package examples.d02._2REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootConfiguration : 프로젝트 내 @Configuration 어노테이션을 찾아 bean(객체) 설정/등록할 수 있도록 설정
// @EnableAutoConfiguration : Spring Boot 가 자동으로 필요한 bean(객체)를 설정/등록, 웹서버인 내장형 Tomcat 설정
// @ComponentScan : * 현재 클래스 기준으로 현 패키지 및 하위 패키지 * 내 자동으로 컴포넌트 (@Component, @RestController) 등을 스캔해서 등록
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}
