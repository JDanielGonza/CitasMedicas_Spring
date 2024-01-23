package com.app.web.respositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import com.app.web.entidad.Consultorios;

public interface ConsultoriosRepository extends JpaRepository<Consultorios, Long>{

	 Consultorios findByNumConsultorio(String numConsultorio);
}
