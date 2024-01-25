package com.app.web.servicio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.controlador.CitasController;
import com.app.web.dto.CitasDto;
import com.app.web.entidad.Citas;
import com.app.web.entidad.Consultorios;
import com.app.web.entidad.Doctores;
import com.app.web.respositorio.CitasRepository;
import com.app.web.respositorio.ConsultoriosRepository;
import com.app.web.respositorio.DoctoresRepository;

@Service
public class CitasServiceImpl implements CitasService {
	Logger logger = LoggerFactory.getLogger(CitasController.class);

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

		cita.getDoctor().setearApellidosNombre(cita.getDoctor().getNombre());
		Doctores doctor = doctoresRepository.findByNombreAndApellidoPaternoAndApellidoMaterno(
				cita.getDoctor().getNombre(), cita.getDoctor().getApellidoPaterno(),
				cita.getDoctor().getApellidoMaterno());

		if (doctor == null) {
			return "DoctorNotFound";
		}

		Consultorios consultorio = consultorioRepository.findByNumConsultorio(numConsultorio);

		if (consultorio == null) {
			return "ConsultorioNotFound";
		}

		cita.setConsultorio(consultorio);
		cita.setDoctor(doctor);

		Citas citaExist = citasRepository.findByConsultorioNumConsultorioAndHorario(numConsultorio, cita.getHorario());

		if (citaExist != null) {
			String res = "CitaExists";
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
	public String actualizarCita(CitasDto citasDto) {
		logger.info("Actualizando cita");
		citasDto.getDoctor().setearApellidosNombre(citasDto.getDoctor().getNombre());
		Doctores doctor = doctoresRepository.findByNombreAndApellidoPaternoAndApellidoMaterno(
				citasDto.getDoctor().getNombre(), citasDto.getDoctor().getApellidoPaterno(),
				citasDto.getDoctor().getApellidoMaterno());
		citasDto.setDoctor(doctor);
		Consultorios consultorio = consultorioRepository
				.findByNumConsultorio(citasDto.getConsultorio().getNumConsultorio());
		citasDto.setConsultorio(consultorio);
		citasDto.setHorario(StringToLocalDateTime(citasDto.getHorarioStr()));
		Citas cita = new Citas(citasDto);
		logger.info(cita.toString());
		citasRepository.save(cita);
		String res = "redirect:/citas";
		return res;
	}

	@Override
	public void eliminarCita(Long id) {
		citasRepository.deleteById(id);
	}

	@Override
	public boolean consultorioHora(String consultorio, String hora) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doctorHora(String doctor, String hora) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pacienteHora(String paciente, String hora) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doctorCitas(String doctor, String hora) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CitasDto obtenerCitasDto(Citas cita) {
		logger.info("Obteniendo CitasDto");
		String horarioStr = this.LocalDateTimeToString(cita.getHorario());

		CitasDto citasDto = new CitasDto(cita, horarioStr);

		LocalDateTime horario = StringToLocalDateTime(citasDto.getHorarioStr());
		citasDto.setHorario(horario);

		logger.info(citasDto.toString());

		Doctores doctor = new Doctores();
		String nombreDoctor = citasDto.getDoctor().getNombre() + " " + citasDto.getDoctor().getApellidoPaterno() + " "
				+ citasDto.getDoctor().getApellidoMaterno();
		doctor.setNombre(nombreDoctor);
		citasDto.setDoctor(doctor);

		return citasDto;
	}

	@Override
	public String LocalDateTimeToString(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		String horarioStr = date.format(formatter);
		return horarioStr;
	}

	@Override
	public LocalDateTime StringToLocalDateTime(String date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			return LocalDateTime.parse(date, formatter);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
