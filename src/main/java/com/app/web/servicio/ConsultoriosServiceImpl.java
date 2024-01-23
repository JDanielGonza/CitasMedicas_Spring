package com.app.web.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Consultorios;
import com.app.web.respositorio.ConsultoriosRepository;

@Service
public class ConsultoriosServiceImpl implements ConsultoriosService {

	@Autowired
	private ConsultoriosRepository consultoriosRespository;

	@Override
	public Consultorios obtenerConsultoriosByNumConsultorio(String numConsultorio) {
		return consultoriosRespository.findByNumConsultorio(numConsultorio);
	}

}
