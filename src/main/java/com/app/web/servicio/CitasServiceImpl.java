package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Citas;
import com.app.web.entidad.Consultorios;
import com.app.web.entidad.Doctores;
import com.app.web.respositorio.CitasRepository;
import com.app.web.respositorio.ConsultoriosRepository;
import com.app.web.respositorio.DoctoresRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CitasServiceImpl implements CitasService {

	@Autowired
	private CitasRepository citasRepository;

	@Autowired
	private ConsultoriosRepository consultorioRepository;

	@Autowired
	private DoctoresRepository doctoresRepository;	
	
	@Autowired
	private ConsultoriosService consultoriosService;
	
	@Override
	public List<Citas> listarCitas() {
		return citasRepository.findAll();
	}

	@Override
	public String guardarCita(Citas cita) {

		String numConsultorio = cita.getConsultorio().getNumConsultorio();
		Long idDoctor = cita.getDoctor().getId();

		Doctores doctor = doctoresRepository.findById(idDoctor)
				.orElseThrow(() -> new EntityNotFoundException("Doctor no encontrado con ID: " + idDoctor));
		Consultorios consultorio = consultorioRepository.findByNumConsultorio(numConsultorio);

		cita.setConsultorio(consultorio);
		cita.setDoctor(doctor);

		Citas citaExist = citasRepository.findByConsultorioNumConsultorioAndHorario(numConsultorio, cita.getHorario());

		if (citaExist != null) {
			String res = "redirect:/citas/nuevo";
			return res;
		} else {
			citasRepository.save(cita);
			String res = "redirect:/citas";
			return res;
		}
	}

	@Override
	public Citas obtenerCitaPorId(Long id) {
		return citasRepository.findById(id).get();
	}

	@Override
	public String actualizarCita(Citas cita) {
		
		Citas citaExistente = citasRepository.findById(cita.getId()).orElse(null);
		Consultorios consultorioExistente = consultoriosService.obtenerConsultoriosByNumConsultorio(cita.getConsultorio().getNumConsultorio());
		Doctores doctoresExistente = doctoresRepository.findById(cita.getDoctor().getId()).orElse(null);
		citaExistente.setId(cita.getId());		
		citaExistente.setDoctor(doctoresExistente);
		citaExistente.setConsultorio(consultorioExistente);
		citaExistente.setHorario(cita.getHorario());
		citaExistente.setPaciente(cita.getPaciente());		
		
		citasRepository.save(citaExistente);
		String res = "redirect:/citas";
		return res; 
	}

	@Override
	public void eliminarCita(Long id) {
		// TODO Auto-generated method stub

	}

}
