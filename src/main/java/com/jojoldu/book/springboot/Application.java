package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// @SpringBootApplication 은 스프링부트 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정 함.
@EnableJpaAuditing
// JPA Auditing 활성화
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
        //SpringApplication.run 으로 인해 "내장WAS"가 실행됨.
        //"내장WAS"란 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS 실행하는 것을 의미.
        //결국 톰캣을 설치할 필요가 없다는 것이고, 스프링부트로 만들어진 Jar 파일로 실행하면 됨.

        //내장WAS 를 사용할 때의 장점? 언제 어디서나 같은 환경에서 배포할 수 있다.
        //내장WAS 를 사용할 때 성능상의 이슈는? 톰캣 역시 서블릿으로 이루어진 자바 애플리케이션이고, 내장WAS 와 같은 코드를 사용하고 있어 크게 문제 없다고 생각해도 무방.

    }
}
