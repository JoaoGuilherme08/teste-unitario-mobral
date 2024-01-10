package com.solinftec.testeunitario.controller;

import com.solinftec.testeunitario.dto.UserLoginDTO;
import com.solinftec.testeunitario.models.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


class UserControllerTest {

    @Test
    void testHttpBadLogin() {
        String url = "http://localhost:8080/user/login";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        var requestBody = UserLoginDTO.builder()
                .email("testegmail.com")
                .senha("123")
                .build();

        HttpEntity<UserLoginDTO> httpEntity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();

        HttpClientErrorException.BadRequest exception = assertThrows(HttpClientErrorException.BadRequest.class, () -> {
            restTemplate.exchange(url, HttpMethod.POST, httpEntity, UserModel.class);
        });

        assertEquals(HttpStatusCode.valueOf(400), exception.getStatusCode());
    }

    @Test
    void testHttpLogin() {
        String url = "http://localhost:8080/user/login";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        var requestBody = UserLoginDTO.builder()
                .email("teste@gmail.com")
                .senha("123")
                .build();

        HttpEntity<UserLoginDTO> httpEntity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserModel> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                UserModel.class
        );

        assertEquals(requestBody.getEmail(), Objects.requireNonNull(responseEntity.getBody()).getEmail());
    }

}