package ar.edu.huergo.vectorial.calidad.bucher.mapper.parcial;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ar.edu.huergo.vectorial.calidad.bucher.dto.parcial.TareaRequestDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.parcial.TareaResponseDTO;
import ar.edu.huergo.vectorial.calidad.bucher.entity.parcial.Tarea;


@Component // Marca la clase como un componente de Spring
// Mapper de la entidad Tarea utiizada para pasar de entidad a DTO y de DTO a entidad
public class TareaMapper{

    /**
     * Pasa de TareaRequestDTO a entidad Tarea
     * @param TareaRequestDTO El DTO a transformar en entidad
     * @return Tarea como entidad
     */
    public Tarea toEntity(TareaRequestDTO tareaRequestDTO) {
        Tarea tarea = new Tarea();

        tarea.setTitulo(tareaRequestDTO.titulo());
        tarea.setDescripcion(tareaRequestDTO.descripcion());
        tarea.setCreador(tareaRequestDTO.creador());

        return tarea;
    }

    /**
     * Pasa de TareaRequestDTO a entidad Tarea
     * @param TareaRequestDTO El DTO a transformar en entidad
     * @return Tarea como entidad
     */
    public TareaResponseDTO toDTO(Tarea tarea) {
        if (tarea == null) {
            return null;
        }

        return new TareaResponseDTO(
            tarea.getId(),
            tarea.getTitulo(),
            tarea.getDescripcion(),
            tarea.getCreador(),
            tarea.getCompletada()
        );
    }

    /**
     * Pasa de una lista de Tareas a una lista de TareasResponseDTO
     * @param PubicacionesResponseDTO La lista de Tareas a transformar en ResponseDTO
     * @return TareasResponseDTO como DTO
     */
    public List<TareaResponseDTO> toDTOList(Set<Tarea> tareas) {
        if (tareas == null) {
            return new ArrayList<>();
        }
        return tareas
            .stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
}
