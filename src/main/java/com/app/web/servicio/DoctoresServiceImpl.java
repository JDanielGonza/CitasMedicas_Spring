package com.app.web.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Doctores;
import com.app.web.respositorio.DoctoresRepository;

@Service
public class DoctoresServiceImpl implements DoctoresService {

	@Autowired
	private DoctoresRepository doctoresRepository;

	public Doctores findDoctoreById(Long id) {
		return doctoresRepository.findById(id).orElse(null);
	}

}
