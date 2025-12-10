package model;

public class Pelicula {
    private String titulo;
    private int posterResId;

    public Pelicula(String titulo, int posterResId) {
        this.titulo = titulo;
        this.posterResId = posterResId;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPosterResId() {
        return posterResId;
    }
}
