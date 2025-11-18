package ar.edu.huergo.vectorial.calidad.bucher.controller.parcial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.huergo.vectorial.calidad.bucher.dto.parcial.CalculoRequestDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.parcial.CalculoResponseDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.parcial.EstadisticasDTO;
import ar.edu.huergo.vectorial.calidad.bucher.mapper.parcial.CalculoMapper;
import ar.edu.huergo.vectorial.calidad.bucher.service.parcial.CalculoService;
import ar.edu.huergo.vectorial.calidad.bucher.entity.parcial.Calculo;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/calculo")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @Autowired
    private CalculoMapper calculoMapper;

    @PostMapping
    public ResponseEntity<CalculoResponseDTO> operar(@RequestBody CalculoRequestDTO calculoDTO) {
        Calculo calculoIngresado = calculoMapper.toEntity(calculoDTO);
        Calculo calculoRealizado = calculoService.realizarOperacion(calculoIngresado);

        return ResponseEntity.ok(calculoMapper.toDTO(calculoRealizado));
    }

    @GetMapping("/historial")
    public ResponseEntity<List<CalculoResponseDTO>> obtenerHistorial() {
        List<Calculo> calculos = calculoService.obtenerHistorial();

        return ResponseEntity.ok(calculoMapper.toDTOList(calculos));
    }

    @GetMapping("/estadisticas")
    public ResponseEntity<EstadisticasDTO> obtenerEstadisticas() {
        EstadisticasDTO estadisticas = new EstadisticasDTO();
        estadisticas.setOperacionMasUsada(calculoService.obtenerOperacionMasUsada());
        estadisticas.setPromededioResueltos(calculoService.obtenerpromedioResultados());
        estadisticas.setTotalCalculos(calculoService.obtenertotalCalculos());

        return ResponseEntity.ok(estadisticas);
    }
}