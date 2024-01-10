package com.solinftec.testeunitario.controller;

import com.solinftec.testeunitario.dto.UserLoginDTO;
import com.solinftec.testeunitario.exceptions.LoginValidationException;
import com.solinftec.testeunitario.models.UserModel;
import com.solinftec.testeunitario.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.solinftec.testeunitario.service.UserService.validaEmail;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @PostMapping("/login")
    public ResponseEntity<UserModel> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        if (!validaEmail(userLoginDTO.getEmail())) {
            throw new LoginValidationException("Erro ao validar o login, e-mail não está em conformidade com o padrão: "
                    + userLoginDTO.getEmail());
        }
        return ResponseEntity.ok().body(service.loginUser(userLoginDTO));
    }
}
