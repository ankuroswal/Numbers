package com.ankuroswal.numbers.Operations;

public class OperationFactory {
	
	public static int AMOUNT = 6;
	
	public static Operations getOperation(int id)
	{
		switch(id)
		{
		case 1:
			return new AddOperation();
		case 2:
			return new AddDoubleOperation();
		case 3:
			return new SubtractOperation();
		case 4:
			return new SubtractDoubleOperation();
		case 5:
			return new MultiplyOperation();
		case 6:
			return new DivideOperation();
		}
			
		return null;
	}
	
	// checks to see if there is an invalid id set
	public static Boolean test()
	{
		Operations op;
		for (int i = 1; i <= AMOUNT; i++)
		{
			op = getOperation(i);
			if (op == null || op.getID() != i)
			{
				return false;				
			}
		}
		return true;
	}
}