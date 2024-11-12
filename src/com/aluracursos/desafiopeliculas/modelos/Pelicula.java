package com.aluracursos.desafiopeliculas.modelos;

import com.aluracursos.desafiopeliculas.exception.ErrorEnConversionEpisodioException;

public class Pelicula {

    private String titulo;
    private int numeroEpisodio;
    private String director;
    private String fechaEstreno;
    private String productor;
    private String apertura;

    public Pelicula(String titulo, int numeroEpisodio, String director, String fechaEstreno, String productor, String apertura) {
        this.titulo = titulo;
        this.numeroEpisodio = numeroEpisodio;
        this.director = director;
        this.fechaEstreno = fechaEstreno;
        this.productor = productor;
        this.apertura = apertura;
    }

    public Pelicula(PeliculaApi miPeliculaApi) {
        this.titulo = miPeliculaApi.title();

        int episodio = Integer.valueOf(miPeliculaApi.episode_id());
        if (episodio < 1 || episodio > 7) {
            throw new ErrorEnConversionEpisodioException("El numero de episodio no es valido, debe ser un numero entre 1 y 7");
        }
        this.numeroEpisodio = episodio;

        this.director = miPeliculaApi.director();
        this.fechaEstreno = miPeliculaApi.release_date();
        this.productor = miPeliculaApi.producer();
        this.apertura = miPeliculaApi.opening_crawl();
    }

    @Override
    public String toString() {
        return "(Pelicula= " + "titulo: " + titulo + ", Numero de Episodio: " + numeroEpisodio + ", director: " + director +
                ", fecha de Estreno: " + fechaEstreno + ")";
    }
}
