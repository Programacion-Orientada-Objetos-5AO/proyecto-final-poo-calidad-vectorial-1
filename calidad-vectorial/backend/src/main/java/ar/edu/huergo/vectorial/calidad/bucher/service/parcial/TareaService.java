package ar.edu.huergo.vectorial.calidad.bucher.service.parcial;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.huergo.vectorial.calidad.bucher.entity.parcial.Tarea;
import ar.edu.huergo.vectorial.calidad.bucher.repository.parcial.TareaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    /**
     * Obtiene todas las tareas
     * @return Un conjunto de todas las tareas
     */
    public Set<Tarea> obtenerTodosLasTareas() {
        return new HashSet<>(tareaRepository.findAll());
    }

    /**
     * Obtiene una tarea por su ID
     * @param id El ID de la tarea
     * @return La tarea correspondiente al ID
     * @throws EntityNotFoundException Si no se encuentra la tarea
     */
    public Tarea obtenerTareaPorId(Long id) throws EntityNotFoundException {
        return tareaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada"));
    }

    /**
     * Crea una nueva tarea
     * @param tarea La  tarea a crear
     * @param titulo El título de la tarea
     * @param descripcion La descripcion de la tarea
     * @param creador El creador de la tarea 
     * @return La tarea creada
     */
    public Tarea crearTarea(Tarea tarea) {

        tarea.setCompletada(false);
        
        return tareaRepository.save(tarea);
    }

    /**
     * Elimina una nueva tarea
     * @param id El id de la tarea a eliminar
     */
    public void eliminarTarea(Long id) {
        Tarea tarea = obtenerTareaPorId(id);
        tareaRepository.delete(tarea);
    }

    /**
     * Modifica una tarea
     * @param id El ID de la tarea a modificar
     * @param tarea La tarea con los nuevos datos
     * @return La tarea modificada
     */
    public Tarea modificarTarea(Long id, Tarea tarea) {
        Tarea tareaExistente = obtenerTareaPorId(id);

        tareaExistente.setTitulo(tarea.getTitulo());
        tareaExistente.setDescripcion(tarea.getDescripcion());
        tareaExistente.setCreador(tarea.getCreador());
        tareaExistente.setCompletada(tarea.getCompletada());

        return tareaRepository.save(tareaExistente);
    }

    /**
     * Modifica el estado de la tarea
     * @param id El ID de la tarea a modificar
     * @param completada La tarea con el nuevo estado
     * @return La tarea modificada
     */
    public Tarea modificarEstadoTarea(Long id, boolean completada) {
        Tarea tareaExistente = obtenerTareaPorId(id);

        tareaExistente.setCompletada(completada);

        return tareaRepository.save(tareaExistente);
    }
}