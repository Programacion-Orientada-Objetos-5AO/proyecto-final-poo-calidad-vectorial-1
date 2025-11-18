package ar.edu.huergo.vectorial.calidad.bucher.dto.parcial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera getters, setters, toString, equals y hashCode
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
public class CalculoResponseDTO {

    private Long id;

    private String operacion;

    private Double primerParametro;

    private Double segundoParametro;

    private Double resultado;
}
