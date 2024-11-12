package com.aluracursos.desafiopeliculas;

import com.aluracursos.desafiopeliculas.modelos.ConsultaPelicula;
import com.aluracursos.desafiopeliculas.modelos.GenerarArchivoJson;
import com.aluracursos.desafiopeliculas.modelos.Pelicula;
import com.aluracursos.desafiopeliculas.modelos.PeliculaApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        List<Pelicula> peliculasStarWars = new ArrayList<>();

        while (true) {
            System.out.println("Ingrese el numero de la pelicula de Star Wars que desea consultar: ");
            System.out.println("Si desea salir, escriba 'Salir'");

            try {
                String numeroPelicula = scanner.nextLine();

                if (numeroPelicula.equalsIgnoreCase("Salir")) {
                    break;
                }

                PeliculaApi miPeliculaApi = consulta.buscarPelicula(Integer.valueOf(numeroPelicula));
                System.out.println(miPeliculaApi);

                Pelicula miPelicula = new Pelicula(miPeliculaApi);
                peliculasStarWars.add(miPelicula);


            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es un numero valido - " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Proceso de busqueda finalizado!");
            }
        }

        GenerarArchivoJson generador = new GenerarArchivoJson();
        generador.guardarJson(peliculasStarWars);
        System.out.println("Fin del programa!");
        scanner.close();
    }
}
