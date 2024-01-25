package com.app.web.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.app.web.dto.CitasDto;
import com.app.web.entidad.Citas;
import com.app.web.servicio.CitasService;

@Controller
public class CitasController {
	Logger logger = LoggerFactory.getLogger(CitasController.class);

	@Autowired
	private CitasService citasService;

	@GetMapping({ "/citas", "/" })
	public String listarCitas(Model modelo) {
		modelo.addAttribute("citas", citasService.listarCitas());
		return "citas_medicas";
	}

	@GetMapping("/citas/nuevo")
	public String mostrarFormulario(Model modelo) {
		Citas citas = new Citas();
		modelo.addAttribute("cita", citas);
		return "crear_cita";
	}

	@PostMapping("/citas")
	public String guardarCita(@ModelAttribute("cita") Citas cita, Model modelo) {
		String resultado = "";
		try {
			resultado = citasService.guardarCita(cita);
			switch (resultado) {
			case "DoctorNotFound":
				modelo.addAttribute("error", "Doctor no encontrado. Por favor, verifique los datos.");
				return "crear_cita";

			case "ConsultorioNotFound":
				modelo.addAttribute("error", "Consultorio no encontrado. Por favor, verifique los datos.");
				return "crear_cita";

			case "CitaExists":
				modelo.addAttribute("error", "Ya existe una cita en el consultorio a esa hora.");
				return "crear_cita";

			default:
				return resultado;
			}
		} catch (Exception e) {
			logger.info("CATCH: " + e.getMessage());
			return null;
		}
	}

	@GetMapping("/citas/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		Citas cita = citasService.obtenerCitaPorId(id);
		logger.info(cita.toString());
		CitasDto citasDto = citasService.obtenerCitasDto(cita);
		modelo.addAttribute("citas", citasDto);
		return "editar_cita";
	}

	@PostMapping("/citas/{id}")
	public String actualizarCita(@PathVariable Long id, @ModelAttribute("citas") CitasDto citas) {
		String res = citasService.actualizarCita(citas);
		return res;
	}

	@GetMapping("/citas/{id}")
	public String eliminarCita(@PathVariable Long id) {
		citasService.eliminarCita(id);
		return ("redirect:/citas");
	}

}
