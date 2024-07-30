package br.com.jau.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jau.converters.NumberConverter;
import br.com.jau.exceptions.UnsupportedMathOperationException;
import br.com.jau.math.SimpleMath;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	private SimpleMath math = new SimpleMath();
	
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value ="numberOne") String numberOne,
			@PathVariable(value ="numberTwo") String numberTwo
	) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value ="numberOne") String numberOne,
			@PathVariable(value ="numberTwo") String numberTwo
	) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/mul/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double mul(
			@PathVariable(value ="numberOne") String numberOne,
			@PathVariable(value ="numberTwo") String numberTwo
	) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.mul(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double div(
			@PathVariable(value ="numberOne") String numberOne,
			@PathVariable(value ="numberTwo") String numberTwo
	) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/med/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double med(
			@PathVariable(value ="numberOne") String numberOne,
			@PathVariable(value ="numberTwo") String numberTwo
	) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.med(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/sqrt/{numberOne}",method=RequestMethod.GET)
	public Double sqrt(
			@PathVariable(value ="numberOne") String numberOne
	) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.sqrt(NumberConverter.convertToDouble(numberOne));
		
	}


}
