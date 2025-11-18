package ar.edu.huergo.vectorial.calidad.bucher.dto.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculadoraRequestDTO {

    private double parametro1;

    private String operacion;
    
    private double parametro2;
}
