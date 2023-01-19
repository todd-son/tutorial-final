package com.example.tutorial.shared;

import com.example.tutorial.shared.jwt.JwtTokenProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("JwtTokenProvider")
class JwtTokenProviderTest {

    private JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(
            "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTY3Mzc5MTc0NCwiaWF0IjoxNjczNzkxNzQ0fQ.3sb1eKcDuXBTEXgVp68NEFTJ2AMesna8USHMK-qiasM"
    );

    @Test
    @DisplayName("id를 포함하여 토큰이 생성된다.")
    public void should_generate_when_id_is_provided() {
        String actual = jwtTokenProvider.generate("todd");

        System.out.println(actual);

        assertNotNull(actual);
    }

    @Test
    @DisplayName("생성된 토큰으로 부터 ID를 추출할 수 있다.")
    public void should_extract_id_when_valid_token() {
        String id = "todd";
        String token = jwtTokenProvider.generate(id);
        String actual = jwtTokenProvider.parseId(token);

        System.out.println(token);
        System.out.println(actual);

        assertEquals(id, actual);
    }


}