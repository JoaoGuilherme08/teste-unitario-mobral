package com.solinftec.testeunitario.exceptions.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
public class ExceptionResponse {
    private String timestamp;
    private String error;
    private String message;
    private String status;
    private String path;
    private Object details;

    @AllArgsConstructor
    @Setter
    @Getter
    public static class Details {
        private String field;
        private String message;
    }
}
