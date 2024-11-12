package com.aluracursos.desafiopeliculas.modelos;

import com.aluracursos.desafiopeliculas.exception.ErrorEnConversionEpisodioException;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {

    public PeliculaApi buscarPelicula(int numeroPelicula) {

        if (numeroPelicula < 1 || numeroPelicula > 7) {
            throw new ErrorEnConversionEpisodioException("El numero de episodio no es valido, debe ser un numero entre 1 y 7");
        }

        URI direccionWeb = URI.create("https://swapi.py4e.com/api/films/" + numeroPelicula + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccionWeb)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            return new Gson().fromJson(json, PeliculaApi.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No encontre esa pelicula");
        }
    }
}
