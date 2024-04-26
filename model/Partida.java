package model;

import java.time.LocalDate;

public class Partida {
	private int partida_ID;
	private String mapa;
	private LocalDate fecha;
	
	
	public int getPartida_id() {
		return partida_ID;
	}
	public void setPartida_id(int partida_id) {
		this.partida_ID = partida_id;
	}
	public String getMapa() {
		return mapa;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}
