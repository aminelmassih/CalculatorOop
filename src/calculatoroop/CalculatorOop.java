package calculatoroop;

import java.util.Scanner;

/**
 * Project to create calculator in OOP 
 * 
 * @author ameenalmassih
 * @since 14/2/2018
 */
public class CalculatorOop {

    //data members
    private int oper;
    private double num1;
    private double num2;
    private double result;
    
    static Scanner console = new Scanner(System.in);
    
    //constructors
    public CalculatorOop(){
        //every method that user gonna use in every alteration 
        selectOper();
        inputNums();
        calculateResult();
        printResult();
    }
    
    //constructor with 3 parameters
    public CalculatorOop(int newOper, double newNum1, double newNum2){
        oper = newOper;
        checkLegal();
        num1 = newNum1;
        num2 = newNum2;
            switch (oper){
                case 4:
                case 5:
                    checkInput0();
                    break;
                case 6:
                case 7:
                    checkInputNegative();
            }
        result = 0;
    }
    
    /**
     * Method to print the operation menu
     */
    public void printOper(){
        System.out.println("Please chose an operation: ");
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");
        System.out.println("5. %");
        System.out.println("6. !");// factorial calculation
        System.out.println("7. F");//Fibonacci calculation
    }
    
    /**
     * Method to check if the operation exist or not
     */
    public void checkLegal(){
        while (oper < 1 || oper >7){
            System.out.println("The operation doesnt exixt");
            printOper();
            oper = console.nextInt();
        }
    }
    
    /**
     * Method to select an operation
     */
    public void selectOper(){
        printOper();
        oper = console.nextInt();
        checkLegal();
    }
    
    /**
     * Method to check if the number is equal to 0
     */
    public void checkInput0(){
        while (num2 == 0){
            System.out.println("Second number cant be 0");
            num2 = console.nextDouble();       
        }
    }
    
    /**
     * Method to check if the number is negative or positive
     */
    public void checkInputNegative(){
        while (num1 < 0){
            System.out.println("Please enter a positive number: ");
            num1 = console.nextDouble();
        }
    }
    
    /**
     * Method to input numbers based on what operation
     */
    public void inputNums(){
        switch (oper){
            case 1:
            case 2:
            case 3:
                System.out.println("Please enter num1:");
                num1 = console.nextDouble();
                System.out.println("Please enter num2: ");
                num2 = console.nextDouble();
                break;
            case 4:
            case 5:
                System.out.println("please enter num1: ");
                num1 = console.nextDouble();
                System.out.println("Please enter num2: ");
                num2 = console.nextDouble();
                checkInput0();//how it will know that it should check num2
                break;
            case 6:
            case 7:
                System.out.println("Please enter num1:");
                num1 = console.nextDouble();
                checkInputNegative();              
        }        
    }
    
    /**
     * Method to calculate the numbers
     */
    public void addition(){
        result = num1 + num2;
    }
    
    public void substract(){
        result = num1 - num2;
    }
    
    public void times(){
        result = num1 * num2;
    }
    
    public void divide(){
        result = num1 / num2;
    }
    
    public void modulus(){
        result = num1 % num2;
    }
    
    /**
     * Method to calculate Factorial formula
     */
    public void factorial(){
        result = 1;
        
        for (int i = 0; i <= num1; i++) {
           result *= 1; 
        }
    }
    
    /**
     * Method to calculate Fibonacci formula
     */
    public void fibonacci(){
        //declare variables
        int f0 = 0;
        int f1 = 1;
        result = 0;
        //calculation
        if (num1 == 0 || num1 == 1)
            result = f0 + f1;
        else
            for (int i = 0; i <= 1; i++){
                result = f0 + f1;
                f0 = f1;
                f1 = (int)result;   
            }
    }
    
    /**
     * Method to calculate the result of the operation that the user select
     */
    public void calculateResult(){
        switch(oper){
            case 1:
                addition();
                break;
            case 2:
                substract();
                break;
            case 3:
                times();
                break;
            case 4:
                divide();
                break;
            case 5:
                modulus();
                break;
            case 6:
                factorial();
                break;
            case 7:
                fibonacci();
                break;
        }
    }
    
    /**
     * Method to print the calculation
     */
    public void printResult(){
        
        String opString = "+-*/%";
        
        switch(oper){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.printf("%.2f %c %.2f = %.2f%n",num1, opString.charAt(oper -1), num2, result);
                break;
            case 6:
                System.out.printf("!%d = %d%n", (int)num1, (int)result);
                break;
            case 7:
                System.out.printf("F(%d) = %d%n", (int)num1, (int)result);
        }
    }
    
    /**
     * 
     * @return the original Operation
     */
    public int getOper(){
        return oper;
    }
    
    /**
     * 
     * @return the original number 1
     */
    public double getNum1(){
        return num1;
    }
    
    /**
     * 
     * @return the original number 2
     */
    public double getNum2(){
        return num2;
    }
    
    /**
     * 
     * @return the original result
     */
    public double getResult(){
        return result;
    }
    
    /**
     * 
     * @param newOper give new value to the Operation
     */
    public void setOper(int newOper){
        oper = newOper;
    }
    
    /**
     * 
     * @param newNum1 gives new value to  number 1
     */
    public void setNum1(double newNum1){
        num1 = newNum1;
    }
    
    /**
     * 
     * @param newNum2 gives new value to number 2
     */
    public void setNum2(double newNum2){
        num2 = newNum2;
    }
    
    /**
     * 
     * @param newResult gives new value to result
     */
    public void setResult(double newResult){
        result = newResult;
    }
}
