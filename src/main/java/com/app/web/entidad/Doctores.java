package com.app.web.entidad;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctores")
public class Doctores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "apellidoPaterno", nullable = false, length = 50)
	private String apellidoPaterno;

	@Column(name = "apellidoMaterno", nullable = false, length = 50)
	private String apellidoMaterno;

	@Column(name = "especialidad", nullable = false, length = 50)
	private String especialidad;

	public Doctores() {
		super();
	}

	public Doctores(String nombre, String apellidoPaterno, String apellidoMaterno, String especialidad) {
		super();
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.especialidad = especialidad;
	}

	public Doctores(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String especialidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.especialidad = especialidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Doctores [id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", especialidad=" + especialidad + "]";
	}

	public void setearApellidosNombre(String nombre) {
		String[] partes = nombre.split("\\s+");
		if (partes.length >= 3) {
			this.nombre = partes[0];
			this.apellidoPaterno = partes[1];
			this.apellidoMaterno = partes[2];
		}
	}
}
