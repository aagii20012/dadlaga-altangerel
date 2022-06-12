package calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
	private Map<String, OperationOnTwoNumber> operationMapOnTwo = new HashMap<>();
	private Map<String, OperationOnOneNumber> operationMapOnOne = new HashMap<>();
	
	//Энд тооны машины үйлдлийг тохирох тэмдгийн хамт хадгална
	public Calculator() {
		operationMapOnTwo.put("+", new Addition());
		operationMapOnTwo.put("-", new Subtraction());
		operationMapOnTwo.put("/", new Division());
		operationMapOnTwo.put("*", new Multiplication());
		operationMapOnTwo.put("%", new Procente());
		
		operationMapOnOne.put("x2", new Square());
		operationMapOnOne.put("sqrt", new SquareRoot());
		operationMapOnOne.put("+/-", new PlusAndMinus());
		operationMapOnOne.put("1/x", new DevideOne());
    }
	
	//Энд 2 тооны хоорондын үйлдлийг тохирох тэмдэгийн дагуу хийж үр дүнг буцаана
	public double makeCalculationOnTwo(double number1, double number2, String operation) {
        OperationOnTwoNumber operationMapValueTwo = null;
        if (operationMapOnTwo.containsKey(operation)) {
        	operationMapValueTwo = operationMapOnTwo.get(operation);
        } 
        else{
            System.out.println("Invalid sign");
        }
        return operationMapValueTwo.calculateResult(number1, number2);
    }
	
	//Энд 1 тоон дээрх үйлдлийг тохирох тэмдэгийн дагуу хийж үр дүнг буцаана
	public double makeCalculationOnOne(double number1, String operation) {
        OperationOnOneNumber operationMapValueOne = null;
        if(operationMapOnOne.containsKey(operation)) {
        	operationMapValueOne = operationMapOnOne.get(operation);
        }
        else{
            System.out.println("Invalid sign");
        }
        return operationMapValueOne.calculateResult(number1);
    }
}
