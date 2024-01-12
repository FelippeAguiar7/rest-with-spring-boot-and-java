package br.com.erudio.controllers;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.execptions.UnsopportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
public class MathControler {

    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsopportedMathOperationException("Please set a numeric value");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne) ,NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public Double subtract(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsopportedMathOperationException("Please set a numeric value");
        }
        return math.subtract(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public Double multiply(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsopportedMathOperationException("Please set a numeric value");
        }
        return math.multiply(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)

    public Double divide(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsopportedMathOperationException("Please set a numeric value");
        }
        if (NumberConverter.convertToDouble(numberTwo) == 0) {
            throw new UnsopportedMathOperationException("Cannot divide by zeros");
        }
        return math.divide(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/average")
    public double average(@RequestParam("numbers") int[] numbers) {
        if (numbers.length == 0) {
            throw new UnsopportedMathOperationException("The list of numbers cannot be empty");
        }
        for (int number : numbers) {
            if (!NumberConverter.isNumeric(String.valueOf(number))) {
                throw new UnsopportedMathOperationException("Please set a numeric value");
            }
        }
        return math.average(numbers);
    }
    @RequestMapping(value = "/square/{number}", method = RequestMethod.GET)
    public double square(
            @PathVariable(value = "number") String number
    ) throws Exception {
        if (!NumberConverter.isNumeric(number)) {
            throw new UnsopportedMathOperationException("Please set a numeric value");
        }
        return math.square(NumberConverter.convertToDouble(number));
    }
}