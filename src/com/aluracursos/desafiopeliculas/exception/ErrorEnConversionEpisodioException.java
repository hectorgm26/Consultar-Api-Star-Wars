package com.aluracursos.desafiopeliculas.exception;

public class ErrorEnConversionEpisodioException extends RuntimeException {

    private String mensaje;

    public ErrorEnConversionEpisodioException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
