package calculator;

public class Procente implements OperationOnTwoNumber {

	@Override
	public double calculateResult(double left, double right) {
		return left % right;
	}

}
