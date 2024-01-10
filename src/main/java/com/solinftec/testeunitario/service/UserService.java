package com.solinftec.testeunitario.service;

import com.solinftec.testeunitario.dto.UserLoginDTO;
import com.solinftec.testeunitario.models.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    public static Boolean validaEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.8-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public UserModel loginUser(UserLoginDTO userLoginDTO) {
        return UserModel.builder()
                .email(userLoginDTO.getEmail())
                .senha(userLoginDTO.getSenha())
                .nome("Carlinhos do Devops")
                .telefone(18951848121L)
                .cpf(1237182931798L)
                .build();
    }
}
