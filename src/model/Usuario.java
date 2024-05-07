package model;

import java.sql.Date;
import java.util.LinkedHashSet;
/**
 * This class defines the object Trainer which has a set of Pokemon and Combats of the Pokemon that are from this trainer
 * and the commbats he/she took part in
 * @author DaniN
 * @version 3
 *
 */
public class Usuario {

	private String dni;
	private String name;
	private String surname;
	private String username;
	private Date birthdate;
	private String gender;
	private boolean esAdmin = false;

	

	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	public String getTrainerInfo() {
		String trainerInfo = "---------------------------------Trainer Info--------------------------------------\n"
				+ "This trainers DNI is " + dni + " and his/her name is " + name + "and surname" + surname + " with username " + username + " \n" + " Was born on the  "
				+ birthdate + " is a " + gender + " \n" + " and he/she is a/an " + esAdmin;
		return trainerInfo;
	}

	@Override
	public String toString() {
		return "Trainer [DNI=" + dni + ", name=" + name + ", surname=" + surname + ", username=" + username
				+ ", birthdate=" + birthdate + ", gender=" + gender + ", Role=" + esAdmin + "]";
	}
}
