package model;

public class Pelicula {
    private String titulo;
    private int posterResId;
    private String sinopsis;

    public Pelicula(String titulo, int posterResId, String sinopsis) {
        this.titulo = titulo;
        this.posterResId = posterResId;
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPosterResId() {
        return posterResId;
    }

    public String getSinopsis() {
        return sinopsis;
    }
}
