// Program for billing

import java.io.*;

class Prog2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter bill amount:- ");
        String billamt = br.readLine();

        System.out.print("Enter tax rate:- ");
        String taxrate = br.readLine();

        System.out.print("Enter the an amount to pay:- ");
        String paid = br.readLine();
        // create a bean object and ask it to perform calculations and deliver them

        TaxCalculations tx = new TaxCalculations();

        tx.setTotal(billamt);
        tx.setTaxRate(taxrate);
        tx.setPaid(paid);

        System.out.println("\nTax amount:- Rs. " + tx.getTaxAmt());
        System.out.println("Net Payable amount:- Rs. " + tx.getNetPayable());
        System.out.println("Amount paid:- Rs. " + tx.getPaid());
        System.out.println((tx.getValidation() ? "\nChange to be given:- Rs. " + tx.getChange() : "\nSorry, enter amount greater than net payable amount for successful transaction"));
        System.out.println("\n");      
    }
}
