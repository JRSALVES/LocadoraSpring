package com.jrs.LocadoraSpring.entity.json.response;

import java.time.Instant;
import java.util.Calendar;

public class ExceptionResponse {

    String error;
    String url;
    Instant dataHora;

    public  ExceptionResponse(Exception ex, String url) {
        error = ex.getMessage();
        dataHora = Calendar.getInstance().toInstant();
        this.url = url;
    }
}
