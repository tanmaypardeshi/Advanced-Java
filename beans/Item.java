package beans;

import java.io.Serializable;
public class Item  implements  Serializable
{
	private int id;
	private String name;
	private double rate;

	public Item()
	{
		id = 123;
		name = "Marker";
		rate = 12.25;
	}

	//getter methods for each field, setter methods not provided for immutable objects
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}

	public double getRate()
	{
		return rate;
	}
}
