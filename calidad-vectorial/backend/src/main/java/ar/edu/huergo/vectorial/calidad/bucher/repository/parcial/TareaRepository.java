package ar.edu.huergo.vectorial.calidad.bucher.repository.parcial;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.huergo.vectorial.calidad.bucher.entity.parcial.Tarea;

// Repositorio JPA para la entidad Tarea
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}