package test;

import java.io.*;

    public class Movie {
        private String[] movieNames;

        public Movie() throws IOException {
            loadMovies();
        }

        private void loadMovies() throws IOException {
            File mvNameFile = new File("C:/gwangmin/mvname.txt");
            BufferedReader reader = new BufferedReader(new FileReader(mvNameFile));
            movieNames = reader.lines().toArray(String[]::new);
            reader.close();
        }

        public String[] getMovieNames() {
            return movieNames;
        }

        public void Mvlist() {
            System.out.println("영화 목록:");
            for (int i = 0; i < movieNames.length; i++) {
                System.out.println((i + 1) + ". " + movieNames[i]);
            }
        }
    }
