// Design a java bean to store the information about a person

import java.io.Serializable;

public class Person implements Serializable
{
    private String name;
    private boolean deceased;

    // default constructor
    public Person() {}

    // setter and getter methods for each attribute


    public void setDeceased(boolean deceased)
    {
        this.deceased = deceased;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public boolean getDeceased()
    {
        return deceased;
    }
}