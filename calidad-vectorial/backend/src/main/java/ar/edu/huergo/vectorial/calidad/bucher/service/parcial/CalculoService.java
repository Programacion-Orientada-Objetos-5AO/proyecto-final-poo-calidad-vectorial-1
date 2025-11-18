package ar.edu.huergo.vectorial.calidad.bucher.service.parcial;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.huergo.vectorial.calidad.bucher.entity.parcial.Calculo;
import ar.edu.huergo.vectorial.calidad.bucher.repository.parcial.CalculoRepository;

@Service
public class CalculoService {

    @Autowired
    private CalculoRepository calculoRepository;

    Map<String, Integer> estadisticas = new HashMap<String, Integer>();

    public Calculo sumar(Calculo calculo) {
        calculo.setResultado(calculo.getPrimerParametro() + calculo.getSegundoParametro());
        if (estadisticas.containsKey("sumar")) {
            Integer valorNuevo = estadisticas.get("sumar") + 1;
            estadisticas.put("sumar", valorNuevo);
        } else {
            estadisticas.put("sumar", 0);
        }

        return calculoRepository.save(calculo);
    }

    public Calculo restar(Calculo calculo) {
        calculo.setResultado(calculo.getPrimerParametro() - calculo.getSegundoParametro());
        if (estadisticas.containsKey("restar")) {
            Integer valorNuevo = estadisticas.get("restar") + 1;
            estadisticas.put("restar", valorNuevo);
        } else {

            estadisticas.put("restar", 0);
        }

        return calculoRepository.save(calculo);
    }

    public Calculo dividir(Calculo calculo) {
        calculo.setResultado(calculo.getPrimerParametro() / calculo.getSegundoParametro());
        if (estadisticas.containsKey("dividir")) {

            Integer valorNuevo = estadisticas.get("dividir") + 1;
            estadisticas.put("dividir", valorNuevo);
        } else {
            estadisticas.put("dividir", 0);
        }

        return calculoRepository.save(calculo);
    }

    public Calculo multiplicar(Calculo calculo) {
        calculo.setResultado(calculo.getPrimerParametro() * calculo.getSegundoParametro());
        if (estadisticas.containsKey("multiplicar")) {
            Integer valorNuevo = estadisticas.get("multiplicar") + 1;
            estadisticas.put("multiplicar", valorNuevo);
        } else {
            estadisticas.put("multiplicar", 0);
        }

        return calculoRepository.save(calculo);
    }

    public Calculo realizarOperacion(Calculo calculo) {
        if (calculo.getOperacion().equals("sumar")) {
            calculo = sumar(calculo);
        }
        if (calculo.getOperacion().equals("restar")) {
            calculo = restar(calculo);
        }
        if (calculo.getOperacion().equals("dividir")) {
            calculo = dividir(calculo);
        }
        if (calculo.getOperacion().equals("multiplicar")) {
            calculo = multiplicar(calculo);
        }

        return calculo;
    }

    public List<Calculo> obtenerHistorial() {
        List<Calculo> calculos = calculoRepository.findHistorial();

        return calculos;
    }

    public String obtenerOperacionMasUsada() {
        String operacionMasUsada = null;
        for (String i : estadisticas.keySet()) {
            if (operacionMasUsada == null) {
                operacionMasUsada = i;
            }
            if (estadisticas.get(i) > estadisticas.get(operacionMasUsada)) {
                operacionMasUsada = i;
            }
        }
        return operacionMasUsada;
    }

    public Double obtenerpromedioResultados() {
        Double promedio = 0.0;
        List<Double> resultados = calculoRepository.findAllResultados();
        if (resultados.isEmpty()) {
            return promedio;
        }
        for (Double resultado : resultados) {
                promedio = promedio + resultado;
            }
            return promedio / resultados.size();
    }

    public long obtenertotalCalculos() {
        return calculoRepository.count();
    }
}