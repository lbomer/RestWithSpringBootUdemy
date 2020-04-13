package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	private Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
			
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	private Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double subtraction = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return subtraction;
			
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	private Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double multiplication = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return multiplication;
			
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	private Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		if(numberTwo== "0") {
			throw new UnsuportedMathOperationException("Please set a divisor other tha zero!");
		}
		Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return division;
			
	}
	
	@RequestMapping(value="/average/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	private Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double average = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		return average;
			
	}
	
	@RequestMapping(value="/squareRoot/{numberOne}", method=RequestMethod.GET)
	private Double squareRoot(@PathVariable("numberOne") String numberOne) throws Exception {
		if(!isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		if(convertToDouble(numberOne)<0) {
			throw new UnsuportedMathOperationException("Please set positive value!");
		}
		Double squareRoot = (Double)Math.sqrt(convertToDouble(numberOne));
		return squareRoot;
			
	}
	
	private Double convertToDouble(String strNUmber) {
		if (strNUmber == null) return 0D;
		String number = strNUmber.replaceAll(",", ".");
		if (isNumeric(strNUmber)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNUmber) {
		if (strNUmber == null) return false;
		String number = strNUmber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
