package com.aluracursos.desafiopeliculas.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerarArchivoJson {

    public void guardarJson(List<Pelicula> peliculasStarWars) throws IOException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter escritura = new FileWriter("peliculasStarWars.json");
        escritura.write(gson.toJson(peliculasStarWars));
        escritura.close();

    }
}
