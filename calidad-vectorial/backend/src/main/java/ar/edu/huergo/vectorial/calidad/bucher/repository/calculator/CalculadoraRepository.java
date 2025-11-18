package ar.edu.huergo.vectorial.calidad.bucher.repository.calculator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.huergo.vectorial.calidad.bucher.entity.calculator.Calculadora;

@Repository
public interface CalculadoraRepository extends JpaRepository<Calculadora, Long>{

}
