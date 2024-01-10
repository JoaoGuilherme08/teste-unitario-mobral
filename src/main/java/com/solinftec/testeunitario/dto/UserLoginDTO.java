package com.solinftec.testeunitario.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginDTO {
    private String email;
    private String senha;
}
