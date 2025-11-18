package ar.edu.huergo.vectorial.calidad.bucher.controller.parcial;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.huergo.vectorial.calidad.bucher.dto.parcial.TareaResponseDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.publication.PublicacionBasicDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.publication.PublicacionCreateDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.publication.PublicacionResponseDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.publication.PublicacionUpdateDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.parcial.TareaRequestDTO;
import ar.edu.huergo.vectorial.calidad.bucher.entity.parcial.Tarea;
import ar.edu.huergo.vectorial.calidad.bucher.entity.publication.Publicacion;
import ar.edu.huergo.vectorial.calidad.bucher.entity.security.Usuario;
import ar.edu.huergo.vectorial.calidad.bucher.mapper.parcial.TareaMapper;

import ar.edu.huergo.vectorial.calidad.bucher.service.parcial.TareaService;
import ar.edu.huergo.vectorial.calidad.bucher.service.security.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController // Marca la clase como un controlador REST
@RequiredArgsConstructor // Genera un constructor con los campos finales
@RequestMapping("/tarea")
// Controlador REST para la gestión de tareas
public class TareaController {

    private final TareaService tareaService;
    private final TareaMapper  tareaMapper;

    /**
     * Obtiene todas las tareas
     * @return Un conjunto de todas las tareas
     */
    @GetMapping
    public ResponseEntity<List<TareaResponseDTO>> obtenerTodasLasTareas() {
        return ResponseEntity.ok(
            tareaMapper.toDTOList(tareaService.obtenerTodosLasTareas()));
    }

    /**
     * Obtiene una tarea por id
     * @param id de la tarea
     * @return La tarea buscada
     */
    @GetMapping("/{id}")
    public ResponseEntity<TareaResponseDTO> obtenerTarea(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
            tareaMapper.toDTO(tareaService.obtenerTareaPorId(id)));
    }

    /**
    * Crea una nueva tarea
    * @param tareaRequestDTO El DTO con los datos de la tarea a crear
    * @return La tarea creada
    */
    @PostMapping("/crear")
    public ResponseEntity<TareaResponseDTO> crearTarea(@Valid @RequestBody TareaRequestDTO tareaRequestDTO) {

        Tarea tareaNueva = tareaMapper.toEntity(tareaRequestDTO);
        Tarea tareaCreada = tareaService.crearTarea(tareaNueva);

        return ResponseEntity.ok(tareaMapper.toDTO(tareaCreada));
    }

    /**
    * Elimina una tarea por su ID
    * @param id El ID de la tarea a eliminar
    * @return OK (200) si se eliminó correctamente
    */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTarea(@PathVariable("id") Long id) {

        tareaService.eliminarTarea(id);
        return ResponseEntity.ok().body("Eliminado correctamente");
    }

    /**
     * Modifica una tarea
     * @param id El ID de la tarea a modificar
     * @param TareaRequestDTO El DTO con los datos a modificar
     * @return La tarea modificada
     */
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TareaResponseDTO> actualizarTarea(@PathVariable("id") Long id,
    @Valid @RequestBody TareaRequestDTO tareaRequestDTO) {

        Tarea tarea = tareaMapper.toEntity(tareaRequestDTO);
        Tarea tareaActualizada;

        tareaActualizada = tareaService.modificarTarea(id, tarea);

        return ResponseEntity.ok(tareaMapper.toDTO(tareaActualizada));
    }

    /**
     * Modifica el estado de una tarea
     * @param id El ID de la tarea a modificar
     * @param completada el estado a modificar
     * @return La tarea modificada
     */
    @PatchMapping("/actualizar/estado/{id}")
    public ResponseEntity<TareaResponseDTO> actualizarTarea(@PathVariable("id") Long id, boolean completada) {

        Tarea tareaActualizada = tareaService.modificarEstadoTarea(id, completada);

        return ResponseEntity.ok(tareaMapper.toDTO(tareaActualizada));
    }
}
