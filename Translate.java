import java.util.Scanner;

public class Translate {

  public static void main (String[] args) {
    String expression, again;
    String result;
    
    try {
      Scanner in = new Scanner(System.in); 
      do {
        InfixToPostfix translator = new InfixToPostfix();
        System.out.print ("Enter a valid infix expression(put a space between each number/operator): ");
        expression = in.nextLine();

        result = translator.translate(expression);
        System.out.println ("This expression in postfix: " + result);
        PostfixEvaluator temp = new PostfixEvaluator();
        int i = temp.evaluate(result);
        System.out.println("Numerical value is: " + i);
        System.out.print ("Translate another expression [Y/N]? ");
        again = in.nextLine();
        System.out.println();
      }
      while (again.equalsIgnoreCase("y"));
    }
    catch (Exception IOException) {
	  System.out.println("Input exception reported");
    }
  }
}


