package model;

import java.sql.Date;

public class Usuario {
	private String dni;
	private String nombre;
	private String apellido;
	private String username;
	private String contrasena;
	private String sexo;
	private Date fecha_nac;
	private boolean esAdmin;
	
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getNacimiento() {
		return fecha_nac;
	}
	public void setNacimiento(Date nacimiento) {
		this.fecha_nac = nacimiento;
	}
	public boolean isEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	
}
