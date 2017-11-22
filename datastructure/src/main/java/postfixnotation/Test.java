package postfixnotation;

public class Test {
	
	public static void main(String[] args) {
		//
		Formula op = new Formula();
		String exp = "(3*5)-(6/2)";
		System.out.println(exp);
		
		if(op.testPair(exp)){
			System.out.println("수식이 올바름(괄호의 쌍이 일치)");
		}else{
			System.out.println("수식이 올바르지 않음(괄호의 쌍이 불일치)");
		}
		
		LinkedStack stack = op.toPostfix(exp);
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
	
}
