package com.app.web.respositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.web.entidad.Citas;

public interface CitasRepository extends JpaRepository<Citas, Long>{
	Optional<Citas> findByConsultorioAndHorario(String consultorio, String horario);
	//Optional<Citas> findByDoctorHorario(String consultorio, String horario);
	//Optional<Citas> findByDoctor(String doctor);
	
}
