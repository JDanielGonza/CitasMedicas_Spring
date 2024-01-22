package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="citas")
public class Citas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "consultorio", nullable=false, length=50)
	private String consultorio;
	
	@Column(name = "doctor", nullable=false, length=50)
	private String doctor;
	
	@Column(name = "horario", nullable=false, length=50)
	private String horario;
	
	@Column(name = "paciente", nullable=false, length=50)
	private String paciente;

	public Citas(Long id, String consultorio, String doctor, String horario, String paciente) {
		super();
		this.id = id;
		this.consultorio = consultorio;
		this.doctor = doctor;
		this.horario = horario;
		this.paciente = paciente;
	}

	public Citas(String consultorio, String doctor, String horario, String paciente) {
		super();
		this.consultorio = consultorio;
		this.doctor = doctor;
		this.horario = horario;
		this.paciente = paciente;
	}

	public Citas() {
		super();
	}

	public String getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	
	
}
