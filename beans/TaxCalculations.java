// design a java bean to perform backend tax calculations for a billing system

import java.io.Serializable;

public class TaxCalculations implements Serializable
{
    private int total;  //initial billamt w/o taxes
    private double taxrate;

    public TaxCalculations(){}

    // console appln - cmd args - String
    // GUI standalone - TextField.getText() - String
    // Web applications = TextBox.getParameter() - String

    public void setTotal(String total)
    {
        this.total = Integer.parseInt(total);
    }
    public void setTaxRate(String taxrate)
    {
        this.taxrate = Double.parseDouble(taxrate);
    }
    public int getTotal()
    {
        return total;
    }
    public double getTaxRate()
    {
        return taxrate;
    }

    // additional methods to perform backend calculations for calculatin tax amount and net payable amount

    public double getTaxAmt()
    {
        return total*taxrate/100;
    }
    public double getNetPayable()
    {
        return total + getTaxAmt();
    }
}

