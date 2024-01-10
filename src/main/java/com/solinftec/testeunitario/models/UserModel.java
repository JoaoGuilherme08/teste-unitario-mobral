package com.solinftec.testeunitario.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private String email;
    private String senha;
    private Long cpf;
    private String nome;
    private Long telefone;
}
