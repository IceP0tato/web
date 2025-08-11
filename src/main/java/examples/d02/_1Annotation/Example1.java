package examples.d02._1Annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class SuperClass {
    public void method1() {

    }
}

class SubClass extends SuperClass {
    @Override // 오버라이딩 기능
    public void method1() {

    }

    // @Deprecated // 해당 함수 사용하지 않음 알림 기능
    public void method2() {

    }
}

// 어노테이션 만들기
@Retention(RetentionPolicy.RUNTIME) // 런타임(실행중)까지 유지
@Target(ElementType.METHOD) // 해당 어노테이션은 메소드에 적용
@interface Annotation1 {
    String value1();
}

// 어노테이션 사용
class TestClass1 {
    @Annotation1(value1 = "어노테이션 주입") // 사용자 정의 어노테이션을 런타임 시 아래 코드에 주입
    public void method3() {
        // value1(); 런타임에 사용하므로 직접적인 코드로 주입받는 것은 아님
        // 프로그램 실행 시 method3() 메소드가 실행되면 value1() 메소드도 같이 실행됨
    }
}

public class Example1 {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method1();
        subClass.method2(); // deprecated
    }
}
