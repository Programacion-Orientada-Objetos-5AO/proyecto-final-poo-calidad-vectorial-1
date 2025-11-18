package ar.edu.huergo.vectorial.calidad.bucher.repository.parcial;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.huergo.vectorial.calidad.bucher.entity.parcial.Calculo;

public interface CalculoRepository extends JpaRepository<Calculo, Long> {

    @Query("SELECT c FROM Calculo c order by c.Id desc limit 5")
    List<Calculo> findHistorial();

    @Query("SELECT c.resultado FROM Calculo c")
    List<Double> findAllResultados();
}