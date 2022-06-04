package calculator;

public class PlusAndMinus implements OperationOnOneNumber {

	@Override
	public double calculateResult(double number) {
		return number * (-1);
	}

}
