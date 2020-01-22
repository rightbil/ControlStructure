import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

public class ControlStructure {
    public static void main(String[] args) {


        // 1. Process customer record
//    A program is required to read a customer’s name, a purchase amount and a tax code.
//    The tax code has been validated and will be one of the following:
//    0  tax exempt (0%)
//    1  state sales tax only (3%)
//    2  federal and state sales tax (5%)
//    3  special sales tax (7%)
//    The program must then compute the sales tax and the total amount due,and print the customer’s name, purchase amount, sales tax and total amount due.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Name");
        String customerName = sc.nextLine();
        System.out.println("Enter purchase amount ? (eg. 34.67)");
        double purchaseAmount = sc.nextDouble();
        System.out.println("Enter your tax code ? (eg. 0,1,2,3 are valid)");
        byte taxCode = sc.nextByte();
        double totalAmountDue;
        if (taxCode < 0 || taxCode > 3) {
            System.out.println("Wrong tax code is entered, please rerun the program and enter correct tax code");
        } else {
            double salesTax;
            if (taxCode == 0) {
                salesTax = 0;
            } else if (taxCode == 1) {
                salesTax = purchaseAmount * 0.03;
            } else if (taxCode == 2) {
                salesTax = purchaseAmount * 0.05;
            } else {
                salesTax = purchaseAmount * 0.07;
            }

            totalAmountDue = purchaseAmount - salesTax;
            System.out.println("Customer Name:" + customerName +
                    "\nPurchase Amount:" + String.format("$%.2f", purchaseAmount) +
                    "\nSales Tax:" + String.format("$%.2f", salesTax) +
                    "\nTotal Amount Due:" + String.format("$%.2f", totalAmountDue) +
                    "\nYour Tax Code was " + taxCode);

        }

        //            2. Calculate employee's pay
//    A program is required by a company to read an employee’s number, pay rate and the number of hours worked in a week.
//    The program is then to validate the pay rate field and the hours worked field and, if valid, compute the employee’s weekly pay and then print it and the input data.
//
//            Validation: According to the company’s rules, the maximum hours an employee can work per week is 60 hours, and the maximum hourly rate is $25.00 per hour.
//            If the hours worked field or the hourly rate field is out of range, the input data and an appropriate message are to be printed and the employee’s weekly pay is not to be calculated.
//
//    Weekly pay calculation: Weekly pay is calculated as hours worked times pay rate. If more than 35 hours are worked, payment for the overtime hours worked is calculated at time-and-a-half.
        boolean validationPassed = true;
        int employeeNumber = 0;
        double payRate = 0.0;
        double numberOfHoursWorked = 0.0;
        double maxPayRateLimit = 25.00;
        double maximumNumberOfHursPerWeek= 60;

        System.out.println("Enter Customer Number ? ");
        employeeNumber = sc.nextInt();
        System.out.println("Enter Pay Rate ?");
        payRate = sc.nextDouble();

        if (payRate > maxPayRateLimit) {
            System.out.println("Validation: Pay rate is high , please limit to <= $25");
            validationPassed = false;
        }
        else  {

            System.out.println("Enter Number of hours worked ?");
            numberOfHoursWorked = sc.nextDouble();
            if (numberOfHoursWorked > maximumNumberOfHursPerWeek) {
                System.out.println("Validation: Hours per week is high, please limit to <=$60");
                validationPassed = false;
            }

        }

        if (validationPassed==true) {
            double weeklyPay;
            if (numberOfHoursWorked <= 35) {
                weeklyPay = numberOfHoursWorked * payRate;
                System.out.println("Customer Number: " + employeeNumber +
                        "\nNumber of Hours per Week: " + numberOfHoursWorked +
                        "\nPay Rate: " + String.format("$%.2f", payRate) +
                        "\nWeekly Pay: " + String.format("$%.2f", weeklyPay)
                );
            }
            else {
                double overTimePay =(numberOfHoursWorked - 35.00 )*payRate* 1.5;
                weeklyPay = 35.00 * payRate + overTimePay;
                System.out.println("Customer Number: " + employeeNumber +
                        "\nNumber of Hours per Week: " + numberOfHoursWorked+
                        // "\nNumber of Hours per Week: " + String.format("$%.2f", numberOfHoursWorked) +
                        "\nPay Rate: " +  payRate +
                        "\nWeekly Pay: " +  String.format("$%.2f",weeklyPay) +
                        "\nNote an Over Time: " + String.format("$%.2f", overTimePay) + " was included in your payment.");


            }
        }

    }


}




