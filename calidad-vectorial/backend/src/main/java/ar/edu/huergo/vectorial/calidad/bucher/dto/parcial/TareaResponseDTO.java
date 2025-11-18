package ar.edu.huergo.vectorial.calidad.bucher.dto.parcial;

public record TareaResponseDTO(
    // Id principal de la entidad
    Long id,

    // Titulo de la tarea
    String titulo,

    // Descripcion de la tarea
    String descripcion,

    // Nombre del creador de la tarea
    String creador,

    // Estado de la tarea
    Boolean completada
    ) {
}
