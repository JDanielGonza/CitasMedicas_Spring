package com.app.web.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Citas;
import com.app.web.respositorio.CitasRepository;

@Service
public class CitasServiceImpl implements CitasService {

	@Autowired
	private CitasRepository citasRepository;

	@Override
	public List<Citas> listarCitas() {
		return citasRepository.findAll();
	}

	@Override
	public Citas guardarCita(Citas cita) {
		return citasRepository.save(cita);
	}

	@Override
	public Citas obtenerCitaPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Citas actualizarCita(Citas cita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCita(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Citas> citaExist(Citas cita) {
		Optional<Citas> cita_ = citasRepository.findByConsultorioAndHorario(cita.getConsultorio(), cita.getHorario());
		return cita_;
	}

}
