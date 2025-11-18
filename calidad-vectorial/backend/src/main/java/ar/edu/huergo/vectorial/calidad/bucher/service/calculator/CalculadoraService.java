package ar.edu.huergo.vectorial.calidad.bucher.service.calculator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.huergo.vectorial.calidad.bucher.entity.calculator.Calculadora;
import ar.edu.huergo.vectorial.calidad.bucher.repository.calculator.CalculadoraRepository;

@Service
public class CalculadoraService {

    @Autowired
    CalculadoraRepository calculadoraRepository;
    
    public Calculadora diferenciarCuenta(Calculadora calculadora) {
        String operacion = calculadora.getOperacion();
        double resultado = 0;
        if (operacion.equals("+")) {
            resultado = sumar(calculadora.getParametro1(), calculadora.getParametro2());
        } else if (operacion.equals("-") ) {
            resultado = restar(calculadora.getParametro1(), calculadora.getParametro2());
        } else if (operacion.equals("*")) {
            resultado = multiplicar(calculadora.getParametro1(), calculadora.getParametro2());            
        } else if (operacion.equals("/")) {
            resultado = dividir(calculadora.getParametro1(), calculadora.getParametro2());
        }
        
        calculadora.setResultado(resultado);
        return calculadora;
    }

    public double sumar(double parametro1, double parametro2) {
        double resultado = parametro1 + parametro2;
        return resultado;
    }

    public double restar(double parametro1, double parametro2) {
        double resultado = parametro1 - parametro2;
        return resultado;
    }

    public double multiplicar(double parametro1, double parametro2) {
        double resultado = parametro1 * parametro2;
        return resultado;
    }

    public double dividir(double parametro1, double parametro2) {
        double resultado = parametro1 / parametro2;
        return resultado;

    }

}
