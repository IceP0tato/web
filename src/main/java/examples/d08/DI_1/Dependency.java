package examples.d08.DI_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 인스턴스를 직접 생성하여 메소드 호출
class SampleDao1 {
    void method1() {}
}

class SampleController1 {
    SampleDao1 sampleDao1 = new SampleDao1();
    public void method2() {
        sampleDao1.method1();
    }
}

// 인스턴스를 미리 생성하여 메소드 호출 (싱글톤)
class SampleDao2 {
    private static final SampleDao2 instance = new SampleDao2();
    private SampleDao2(){}
    public static SampleDao2 getInstance() { return instance; }

    void method1() {}
}

class SampleController2 {
    private final SampleDao2 sampleDao2 = SampleDao2.getInstance();
    public void method2() {
        sampleDao2.method1();
    }
}

// IOC
@Component // 스프링 컨테이너에 빈 등록 (빈 : 스프링 컨테이너에 저장된 인스턴스)
class SampleDao3 {
    void method1() {}
}

// DI 1
class SampleController3 {
    @Autowired private SampleDao3 sampleDao3; // 스프링 컨테이너에 등록된 빈을 꺼내서 멤버변수에 대입

    void method2() {
        sampleDao3.method1();
    }
}

// DI 2 (Spring 공식 권장)
class SampleController4 {
    private final SampleDao3 sampleDao3; // final (수정 불가 키워드, 초기값 필수) 사용으로 불변성(안전) 보장

    @Autowired // 생성자에 빈 주입
    public SampleController4(SampleDao3 sampleDao3) {
        this.sampleDao3 = sampleDao3;
    }

    void method2() {
        sampleDao3.method1();
    }
}

public class Dependency {
}
