package com.solinftec.testeunitario.service;

import org.junit.jupiter.api.Test;

import static com.solinftec.testeunitario.service.UserService.validaEmail;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest {

    @Test
    void validaEmailTeste() {
        assertTrue(validaEmail("usuario@dominio.com"));
        assertFalse(validaEmail("email@.com"));
        assertFalse(validaEmail("email@dominio."));
    }
}