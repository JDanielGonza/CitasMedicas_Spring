package com.app.web.servicio;

import java.time.LocalDateTime;
import java.util.List;

import com.app.web.dto.CitasDto;
import com.app.web.entidad.Citas;

public interface CitasService {

	public List<Citas> listarCitas();

	public String guardarCita(Citas cita);

	public Citas obtenerCitaPorId(Long id);

	public String actualizarCita(CitasDto cita);

	public void eliminarCita(Long id);
	
	public boolean consultorioHora(String consultorio, String hora);

	public boolean doctorHora(String doctor, String hora);
	
	public boolean pacienteHora(String paciente, String hora);
	
	public boolean doctorCitas(String doctor, String hora);
	
	public CitasDto obtenerCitasDto(Citas cita);
	
	public String LocalDateTimeToString(LocalDateTime date);
	
	public LocalDateTime StringToLocalDateTime(String date);
	
	
}
