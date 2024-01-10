package com.solinftec.testeunitario.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public static Boolean somaEntreNumeros(Long num1, Long num2) {
        var resultado = (num1 + num2) % 2;
        if (resultado == 0) {
            return true;
        } else
            return false;
    }
}
