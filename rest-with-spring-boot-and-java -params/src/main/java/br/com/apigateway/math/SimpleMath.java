package br.com.apigateway.math;

public class SimpleMath {

	public Double sum(Double numberOne, Double numberTwo) {

		return numberOne + numberTwo;
	}

	public Double subtracao(Double numberOne, Double numberTwo) {

		return numberOne - numberTwo;

	}

	public Double multiplicacao(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;

	}

	public Double divisao(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;

	}

	public Double raizQuadrada(Double numberOne) {

		return Math.sqrt(numberOne);

	}
}
