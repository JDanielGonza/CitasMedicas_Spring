package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Citas;

public interface CitasService {

	public List<Citas> listarCitas();

	public String guardarCita(Citas cita);

	public Citas obtenerCitaPorId(Long id);

	public String actualizarCita(Citas cita);

	public void eliminarCita(Long id);
	
	
}
