import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ControlStructure {
    public static void main(String  [] args)
    {

 //1. Process customer record
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
        if(taxCode <0 || taxCode > 3)
        {
  System.out.println("Wrong tax code is entered, please rerun the program and enter correct tax code");
 }
 else {
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
                              "\nPurchase Amount:" + String.format("$%.2f",purchaseAmount) +
                             "\nSales Tax:" + String.format("$%.2f",salesTax) +
                             "\nTotal Amount Due:" + String.format("$%.2f",totalAmountDue) +
                             "\nYour Tax Code was " + taxCode);

        }
 }


    }




