package ar.edu.huergo.vectorial.calidad.bucher.controller.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.huergo.vectorial.calidad.bucher.dto.calculator.CalculadoraRequestDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.calculator.CalculadoraResponseDTO;
import ar.edu.huergo.vectorial.calidad.bucher.entity.calculator.Calculadora;
import ar.edu.huergo.vectorial.calidad.bucher.mapper.calculator.CalculadoraMapper;
import ar.edu.huergo.vectorial.calidad.bucher.service.calculator.CalculadoraService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    @Autowired 
    private CalculadoraService calculadoraService;

    @Autowired
    private CalculadoraMapper calculadoraMapper;

    @PostMapping("/calculo")
    public ResponseEntity<CalculadoraResponseDTO> calcular(@RequestBody CalculadoraRequestDTO calculadoraRequestDTO) {
        Calculadora calculadora = calculadoraMapper.toEntity(calculadoraRequestDTO);
        calculadoraService.diferenciarCuenta(calculadora);
        return ResponseEntity.ok(calculadoraMapper.toResponseDTO(calculadora));
    }
    
}
