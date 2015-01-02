import java.util.StringTokenizer;
import java.util.*;

public class InfixToPostfix {

	private final String ADD = "+";
	private final String SUBTRACT = "-";
	private final String MULTIPLY = "*";
	private final String DIVIDE = "/";
	private final String FRONTBRACKET = "(";
	private final String BACKBRACKET = ")";

	private final int ADD_PREC = 2;
	private final int MUL_PREC = 4;
	

	private Stack<String> stack;

	public InfixToPostfix() {
		stack = new Stack<String>();
	}

	public String translate(String expr) {

		String token, outputString = "";
		StringTokenizer tokenizer = new StringTokenizer(expr);

		while (tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();

			if (!isOperator(token)) {
				outputString += token + " ";
			} else {
				if (stack.isEmpty()) {
					stack.push(token);
				} else {
					if (token.equals(BACKBRACKET)) {
						while (!stack.peek().equals(FRONTBRACKET)) {
							outputString += stack.pop() + " ";
						}
						stack.pop();
					}
					if (!stack.isEmpty() && !stack.peek().equals(FRONTBRACKET)) {
						if (precedence(stack.peek()) > precedence(token)) {
							outputString += stack.pop() + " ";
						}
					}
					if (!token.equals(BACKBRACKET)) {
						stack.push(token);
					}
				}
			}
		}
		while (!stack.isEmpty()) {

			outputString += stack.pop() + " ";

		}
		return outputString;
	}

	private int precedence(String token) {

		if (token.equals(ADD) || token.equals(SUBTRACT)) {
			return ADD_PREC;
		} else {
			return MUL_PREC;
		}

	}

	private boolean isOperator(String token) {

		return (token.equals(ADD) || token.equals(SUBTRACT)
				|| token.equals(MULTIPLY) || token.equals(DIVIDE)
				|| token.equals(FRONTBRACKET) || token.equals(BACKBRACKET));
	}
}
