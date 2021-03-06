package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //assertj 라는 테스트 검증 라이브러리의 검증 메소드이다.
        //검증하고 싶은 대상을 메소드 인자로 받는다.

        //HelloResponseDto.class 에 @Getter 와 @RequiredArgsConstructor 를 선언해 둠,
        //따로 get 메소드를 오버라이드하지 않았지만, getName(), getAmount() 를 사용할 수 있음.

    }
}
