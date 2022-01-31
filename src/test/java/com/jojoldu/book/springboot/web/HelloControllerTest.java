package com.jojoldu.book.springboot.web;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //스프링부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class)
//@WebMvcTest 은 Web에 집중할 수 있는 어노테이션이라고 하는데... 잘 모르겠다.
//지금은 컨트롤러만 사용하는 상황이기 때문에, @WebMvcTest 을 선언했다는 정도...
public class HelloControllerTest {

    @Autowired //스프링이 관리하는 Bean을 주입 받는다.
    private MockMvc mvc;
    //MockMvc 는 웹 API를 테스트할 때 사용한다. 스프링 MVC 테스트의 시작점이다.
    //이 클래스를 통해서 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //MockMvc 를 통해 GET 요청을 보냄
                .andExpect(status().isOk()) //perform 의 결과를 확인. isOk() 는 200인지 확인하기 위함.
                .andExpect(content().string(hello)); //content 가 hello 인지 확인하기 위함.
        //테스트시 계속해서 오류가 떴는데 빌드 문제였음... build.gradle 에서 설정 문제가 존재했었다...
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
        //param 은 String 만 허용됨!
        //$ 를 기준으로 필드명을 명시합니다. ($가 필드를 의미한다?)
    }

}
