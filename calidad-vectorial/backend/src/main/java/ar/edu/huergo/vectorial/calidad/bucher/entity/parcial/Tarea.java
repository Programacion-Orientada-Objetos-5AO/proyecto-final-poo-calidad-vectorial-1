package ar.edu.huergo.vectorial.calidad.bucher.entity.parcial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity // Marca la clase como una entidad de JPA
@Data // Genera getters, setters, toString, equals y hashCode
@NoArgsConstructor // Genera un constructor sin argumentos
@AllArgsConstructor // Genera un constructor con todos los argumentos
@EqualsAndHashCode()
@Table(name = "Tarea")
public class Tarea {

    @Id // Id principal de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el Id automáticamente
    private Long id;

    // Titulo de la tarea
    @Column(nullable = false, unique = true)
    @NotBlank(message = "El titulo es obligatorio.")
    @NotNull(message = "El titulo es obligatorio.")
    @Size(min = 3, max = 100, message = "El titulo debe tener entre 3 y 100 digitos.")
    private String titulo;

    // Descripcion de la tarea
    @Column(nullable = true)
    @NotBlank(message = "La descripcion es obligatoria.")
    @NotNull(message = "La descripcion es obligatoria.")
    @Size(max = 255, message = "La descripcion debe tener menos de 255 digitos.")
    private String descripcion;

    // Nombre del creador de la tarea
    @Column(nullable = false)
    @NotBlank(message = "La descripcion es obligatorio.")
    @NotNull(message = "La descripcion es obligatorio.")
    @Size(max = 255, message = "La descripcion debe tener menos de 255 digitos.")
    private String creador;

    // Estado de la tarea
    @Column(nullable = false)
    @NotNull(message = "El estado de la tarea es obligatorio.")
    private boolean completada;

    public boolean getCompletada() {
        return this.completada;
    }
}