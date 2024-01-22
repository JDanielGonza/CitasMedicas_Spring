package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="consultorios")
public class Consultorios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numConsultorio", nullable=false, length=50)
	private String numConsultorio;
	
	@Column(name = "piso", nullable=false, length=50)
	private String piso;

	public Consultorios(Long id, String numConsultorio, String piso) {
		super();
		this.id = id;
		this.numConsultorio = numConsultorio;
		this.piso = piso;
	}

	public Consultorios() {
		super();
	}

	public Consultorios(String numConsultorio, String piso) {
		super();
		this.numConsultorio = numConsultorio;
		this.piso = piso;
	}

	public String getNumConsultorio() {
		return numConsultorio;
	}

	public void setNumConsultorio(String numConsultorio) {
		this.numConsultorio = numConsultorio;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}
	
	
	
}
