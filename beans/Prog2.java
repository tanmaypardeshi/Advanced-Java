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

        // create a bean object and ask it to perform calculations and deliver them

        TaxCalculations tx = new TaxCalculations();

        tx.setTotal(billamt);
        tx.setTaxRate(taxrate);

        System.out.println("Tax amt:- Rs. " + tx.getTaxAmt());
        System.out.println("Net Payable amt:- Rs. " + tx.getNetPayable());
    }
}