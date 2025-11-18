package ar.edu.huergo.vectorial.calidad.bucher.dto.calculator;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculadoraResponseDTO {
    @Id
    private Long id;

    private String operacion;

    private double parametro1;

    private double parametro2;

    private double resultado;
}
