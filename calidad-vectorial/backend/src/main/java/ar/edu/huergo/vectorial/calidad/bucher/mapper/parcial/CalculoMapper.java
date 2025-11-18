package ar.edu.huergo.vectorial.calidad.bucher.mapper.parcial;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ar.edu.huergo.vectorial.calidad.bucher.dto.parcial.CalculoResponseDTO;
import ar.edu.huergo.vectorial.calidad.bucher.dto.parcial.CalculoRequestDTO;
import ar.edu.huergo.vectorial.calidad.bucher.entity.parcial.Calculo;

@Component
public class CalculoMapper {

    public Calculo toEntity(CalculoRequestDTO calculoDTO) {
        Calculo calculo = new Calculo();
        calculo.setPrimerParametro(calculoDTO.getPrimerParametro());
        calculo.setSegundoParametro(calculoDTO.getSegundoParametro());
        calculo.setOperacion(calculoDTO.getOperacion());

        return calculo;
    }

    public CalculoResponseDTO toDTO(Calculo calculo) {
        if (calculo == null) {
            return null;
        }
        CalculoResponseDTO calculoDTO = new CalculoResponseDTO();
        calculoDTO.setId(calculo.getId());
        calculoDTO.setOperacion(calculo.getOperacion());
        calculoDTO.setPrimerParametro(calculo.getPrimerParametro());
        calculoDTO.setSegundoParametro(calculo.getSegundoParametro());
        calculoDTO.setResultado(calculo.getResultado());

        return calculoDTO;
    }

    public List<CalculoResponseDTO> toDTOList(List<Calculo> calculos) {
        if (calculos == null) {
            return new ArrayList<>();
        }
        return calculos
            .stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
}