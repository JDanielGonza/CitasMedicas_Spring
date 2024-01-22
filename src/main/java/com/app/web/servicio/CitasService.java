package com.app.web.servicio;

import java.util.List;
import java.util.Optional;

import com.app.web.entidad.Citas;

public interface CitasService {

	public List<Citas> listarCitas();

	public Citas guardarCita(Citas cita);

	public Citas obtenerCitaPorId(Long id);

	public Citas actualizarCita(Citas cita);

	public void eliminarCita(Long id);
	
	public Optional<Citas> citaExist(Citas cita);
	
}
