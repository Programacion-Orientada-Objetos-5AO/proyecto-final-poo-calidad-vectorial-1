package ar.edu.huergo.vectorial.calidad.bucher.entity.parcial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Marca la clase como una entidad de JPA
@Data // Genera getters, setters, toString, equals y hashCode
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@Table(name = "calculos")
public class Calculo {

    @Id // Id principal de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el Id automáticamente
    private Long id;

    private String operacion;

    private Double primerParametro;

    private Double segundoParametro;

    private Double resultado;
}
