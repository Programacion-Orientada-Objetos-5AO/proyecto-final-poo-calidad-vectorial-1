package ar.edu.huergo.vectorial.calidad.bucher.dto.parcial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticasDTO {
    private String operacionMasUsada;

    private Double promededioResueltos;

    private long totalCalculos;
}
