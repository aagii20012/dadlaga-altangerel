package calculator;

public class SquareRoot implements OperationOnOneNumber {

	@Override
	public double calculateResult(double number) {
		return Math.sqrt(number);
	}

}
