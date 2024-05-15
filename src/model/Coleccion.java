package model;

public class Coleccion {
    private int coleccion_ID;
    private String armaFav;
    private String skinFav;
    private String agenteFav;
    private String dni_jugador;

    public int getColeccion_id() {
        return coleccion_ID;
    }

    public void setColeccion_id(int coleccion_id) {
        this.coleccion_ID = coleccion_id;
    }

    public String getArmaFav() {
        return armaFav;
    }

    public void setArmaFav(String armaFav) {
        this.armaFav = armaFav;
    }

    public String getSkinFav() {
        return skinFav;
    }

    public void setSkinFav(String skinFav) {
        this.skinFav = skinFav;
    }

    public String getAgenteFav() {
        return agenteFav;
    }

    public void setAgenteFav(String agenteFav) {
        this.agenteFav = agenteFav;
    }

    public String getDni_jugador() {
        return dni_jugador;
    }

    public void setDni_jugador(String dni_jugador) {
        this.dni_jugador = dni_jugador;
    }

}