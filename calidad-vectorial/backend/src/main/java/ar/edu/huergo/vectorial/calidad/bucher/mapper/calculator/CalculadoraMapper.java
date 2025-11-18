package ar.edu.huergo.vectorial.calidad.bucher.mapper.calculator;

import org.springframework.stereotype.Component;

import ar.edu.huergo.vectorial.calidad.bucher.dto.calculator.CalculadoraRequestDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.calculator.CalculadoraResponseDTO;
import ar.edu.huergo.vectorial.calidad.bucher.entity.calculator.Calculadora;

@Component
public class CalculadoraMapper {
     public CalculadoraRequestDTO toRequestDTO(Calculadora calculadora) {
        if (calculadora == null) {
            return null;
        }
        CalculadoraRequestDTO calculadoraRequestDTO = new CalculadoraRequestDTO();

        calculadoraRequestDTO.setOperacion(calculadora.getOperacion());
        calculadoraRequestDTO.setParametro1(calculadora.getParametro1());
        calculadoraRequestDTO.setParametro2(calculadora.getParametro2());

        return calculadoraRequestDTO;
    }

    public CalculadoraResponseDTO toResponseDTO(Calculadora calculadora) {
        if (calculadora == null) {
            return null;
        }
        CalculadoraResponseDTO calculadoraResponseDTO = new CalculadoraResponseDTO();

        calculadoraResponseDTO.setId(calculadora.getId());
        calculadoraResponseDTO.setOperacion(calculadora.getOperacion());
        calculadoraResponseDTO.setParametro1(calculadora.getParametro1());
        calculadoraResponseDTO.setParametro2(calculadora.getParametro2());
        calculadoraResponseDTO.setResultado(calculadora.getResultado());
        
        return calculadoraResponseDTO;
    }

    public Calculadora toEntity(CalculadoraRequestDTO calculadoraRequestDTO) {
        Calculadora calculadora = new Calculadora();

        calculadora.setOperacion(calculadoraRequestDTO.getOperacion());
        calculadora.setParametro1(calculadoraRequestDTO.getParametro1());
        calculadora.setParametro2(calculadoraRequestDTO.getParametro2());

        return calculadora;
    }
}
