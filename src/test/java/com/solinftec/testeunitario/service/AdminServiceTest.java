package com.solinftec.testeunitario.service;

import org.junit.jupiter.api.Test;

import static com.solinftec.testeunitario.service.AdminService.somaEntreNumeros;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class AdminServiceTest {

    @Test
    void somaEntreNumerosTeste() {
        assertTrue(somaEntreNumeros(2L, 2L));
        assertFalse(somaEntreNumeros(2L, 3L));
    }
}