package ar.edu.huergo.vectorial.calidad.bucher.dto.parcial;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// DTO para la solicitud de login
public record TareaRequestDTO(
    // Titulo de la tarea
    @Column(nullable = false, unique = true)
    @NotBlank(message = "El titulo es obligatorio.")
    @NotNull(message = "El titulo es obligatorio.")
    @Size(min = 3, max = 100, message = "El titulo debe tener entre 3 y 100 digitos.")
    String titulo,

    // Descripcion de la tarea
    @Column(nullable = true)
    @NotBlank(message = "La descripcion es obligatorio.")
    @NotNull(message = "La descripcion es obligatorio.")
    @Size(max = 255, message = "La descripcion debe tener menos de 255 digitos.")
    String descripcion,

    // Nombre del creador de la tarea
    @Column(nullable = false)
    @NotBlank(message = "La descripcion es obligatorio.")
    @NotNull(message = "La descripcion es obligatorio.")
    @Size(max = 255, message = "La descripcion debe tener menos de 255 digitos.")
    String creador
    ){
}