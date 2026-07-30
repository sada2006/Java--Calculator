import java.util.*;

public class App {
    public static Calculator calculator=new Calculator();
    public static History history=new History();
    public static Scanner sc = new Scanner(System.in);
   

    

    public static void newCalculation() {

        double num1;
        if(calculator.usePreviousResult){
            num1=calculator.previousResult;
            calculator.usePreviousResult=false;
        }else{
            while (true) {
                System.out.println("Enter number 1: ");

                if (sc.hasNextDouble()) {
                    num1 = sc.nextDouble();
                    break;
                } else {
                    System.out.println("Invalid input! Please Enter an valid number");
                    sc.next();
                }
            }
        }
        
        
        System.out.println("Enter operation to perform (+,-,*,/,sqrt,^,mod,%)");
        String operand = sc.next();
        String lcase = operand.toLowerCase();

        double num2 = 0;

        if (!lcase.equals("sqrt")) {

            while (true) {
                System.out.println("Enter number 2: ");

                if (sc.hasNextDouble()) {
                    num2 = sc.nextDouble();
                    break;
                } else {
                    System.out.println("Invalid Input!!, Please enter an valid number");
                    sc.next();
                }
            }
        }

        double result;
        
        try {
            result = calculator.calculate(lcase, num1, num2);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        

            StringBuilder sb = new StringBuilder();

            if (!lcase.equals("sqrt")) {
                System.out.println("The result of " + num1 + " " + operand + " " + num2 + " = " + result);
                calculator.previousResult=result;
                calculator.usePreviousResult=true;
                sb.append(num1);
                sb.append(" ");
                sb.append(lcase);
                sb.append(" ");
                sb.append(num2);
                sb.append(" ");
                sb.append("=");
                sb.append(" ");
                sb.append(result);

                String finalString = sb.toString();
                history.addHistory(finalString);

            } else{

                System.out.println("The Square root of " + num1 + " = " + result);
                calculator.previousResult=result;
                calculator.usePreviousResult=true;
                sb.append(lcase);
                sb.append(" ");
                sb.append(num1);
                sb.append("=");
                sb.append(result);

                String finalString = sb.toString();
                history.addHistory(finalString);
            
            }
        
    }

   

    public static boolean exitapp() {

        while (true) {

            System.out.println("Do you really want to exit the application? (yes/no)");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("yes")) {
                sc.close();
                System.out.println("Thank you for using Calculator! 👋");
                return true;
            }

            if (choice.equalsIgnoreCase("no")) {
                return false;
            }

            System.out.println("Invalid input!! Please enter only yes or no");
        }
    }

    public static void main(String[] args) {
        
        int option = 0;

        do {

            do {

                System.out.println("=========Welcome to Calculator========");
                System.out.println("============Calculator Menu===========");
                System.out.println("1. New Calculation");
                System.out.println("2. View History");
                System.out.println("3. Use Previous Calculation");
                System.out.println("4. Exit Application");

                while (true) {

                    System.out.println("Please Enter your choice: ");

                    if (sc.hasNextInt()) {
                        option = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Please choose valid option from Menu");
                        sc.next();
                    }
                }

            } while (option > 4 || option < 1);

            switch (option) {

                case 1:
                    newCalculation();
                    break;

                case 2:
                    history.viewHistory();
                    break;

                case 3:
                    if(!calculator.usePreviousResult){
                        System.out.println("No Previous Calculation Found");
                    }else{
                        System.out.println("Previous Result is "+ calculator.previousResult);
                        System.out.println("Your num1 will be: "+calculator.previousResult);
                        calculator.usePreviousResult=true;
                        newCalculation();
                    }
                    break;

                case 4:
                    if (exitapp()) {
                        return;
                    }
                    break;
                default:
                    System.out.println("Please Choose Valid Option from the menu");
                    break;
            }

        } while (option != 4);
    }
}