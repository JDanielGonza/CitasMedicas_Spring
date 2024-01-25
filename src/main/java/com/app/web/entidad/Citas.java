package com.app.web.entidad;

import java.time.LocalDateTime;

import com.app.web.dto.CitasDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "citas")
public class Citas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consultorio_id", nullable = false)
	private Consultorios consultorio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctores doctor;

	@Column(name = "horario", nullable = false, length = 50)
	private LocalDateTime horario;

	@Column(name = "paciente", nullable = false, length = 50)
	private String paciente;

	public Citas(CitasDto citasDto) {
		super();
		this.id = citasDto.getId();
		this.consultorio = citasDto.getConsultorio();
		this.doctor = citasDto.getDoctor();
		this.horario = citasDto.getHorario();
		this.paciente = citasDto.getPaciente();
	}
	
	public Citas() {
		super();
	}

	public Citas(Consultorios consultorio, Doctores doctor, LocalDateTime horario, String paciente) {
		super();
		this.consultorio = consultorio;
		this.doctor = doctor;
		this.horario = horario;
		this.paciente = paciente;
	}

	public Citas(Long id, Consultorios consultorio, Doctores doctor, LocalDateTime horario, String paciente) {
		super();
		this.id = id;
		this.consultorio = consultorio;
		this.doctor = doctor;
		this.horario = horario;
		this.paciente = paciente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Consultorios getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorios consultorio) {
		this.consultorio = consultorio;
	}

	public Doctores getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctores doctor) {
		this.doctor = doctor;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Citas [id=" + id + ", consultorio=" + consultorio + ", doctor=" + doctor + ", horario=" + horario
				+ ", paciente=" + paciente + "]";
	}
}