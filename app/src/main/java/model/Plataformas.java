package model;

public class Plataformas {
    private String nombre;
    private int logoResId;

    public Plataformas(String nombre, int logoResId) {
        this.nombre = nombre;
        this.logoResId = logoResId;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLogoResId() {
        return logoResId;
    }
}

