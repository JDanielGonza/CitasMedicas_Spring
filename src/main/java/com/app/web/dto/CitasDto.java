package com.app.web.dto;

import java.time.LocalDateTime;

import com.app.web.entidad.Citas;
import com.app.web.entidad.Consultorios;
import com.app.web.entidad.Doctores;


public class CitasDto {
	
	private Long id;
	private Consultorios consultorio;
	private Doctores doctor;	
	private String paciente;
	private String horarioStr;
	private LocalDateTime horario;

	
	public CitasDto() {
		super();
	}

	public CitasDto(Long id, Consultorios consultorio, Doctores doctor, String paciente, String horarioStr) {
		super();
		this.id = id;
		this.consultorio = consultorio;
		this.doctor = doctor;
		this.paciente = paciente;
		this.horarioStr = horarioStr;
	}

	public CitasDto(Citas cita, String horarioStr) {
		super();
		this.id = cita.getId();
		this.consultorio = cita.getConsultorio();
		this.doctor = cita.getDoctor();
		this.paciente = cita.getPaciente();
		this.horarioStr = horarioStr;
		this.horario = cita.getHorario();
	}
	
	public CitasDto(Long id, Consultorios consultorio, Doctores doctor, String paciente, String horarioStr,
			LocalDateTime horario) {
		super();
		this.id = id;
		this.consultorio = consultorio;
		this.doctor = doctor;
		this.paciente = paciente;
		this.horarioStr = horarioStr;
		this.horario = horario;
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
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getHorarioStr() {
		return horarioStr;
	}
	public void setHorarioStr(String horarioStr) {
		this.horarioStr = horarioStr;
	}
	public LocalDateTime getHorario() {
		return horario;
	}
	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "CitasDto [id=" + id + ", consultorio=" + consultorio + ", doctor=" + doctor + ", paciente=" + paciente
				+ ", horarioStr=" + horarioStr + ", horario=" + horario + "]";
	}
	

}
