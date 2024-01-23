package com.app.web.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.web.entidad.Citas;

public interface CitasRepository extends JpaRepository<Citas, Long>{
	Citas findByConsultorioNumConsultorioAndHorario(String numConsultorio, String horario);
	
}
