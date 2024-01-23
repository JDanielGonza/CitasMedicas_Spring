package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.app.web.entidad.Citas;
import com.app.web.servicio.CitasService;

@Controller
public class CitasController {

	@Autowired
	private CitasService citasService;
	
	@GetMapping({"/citas", "/"})
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
	public String guardarCita(@ModelAttribute("cita") Citas cita) {
		return citasService.guardarCita(cita);	
	}
	
	@GetMapping("/citas/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		Citas cita = citasService.obtenerCitaPorId(id);		
		modelo.addAttribute("citas", cita);
		return "editar_cita";
	}
	
	@PostMapping("/citas/{id}")
	public String actualizarCita(@PathVariable Long id, @ModelAttribute("citas") Citas cita) {
		String res = citasService.actualizarCita(cita);		
		return res; 
	}
}
