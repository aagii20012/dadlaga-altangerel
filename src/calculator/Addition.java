package calculator;

public class Addition implements OperationOnTwoNumber {

	@Override
	public double calculateResult(double left, double right) {
		return left + right;
	}

}
