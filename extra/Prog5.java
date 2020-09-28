/* An eg of a generic method in a class which is non-generic.
Syntax is
	<T> return-type method_name(arg-list)   // atleast 1 argument should be of generic type
	{
		// method code
	}
Also generic methods can be overloaded using normal methods. Here the 1st preference is given to normal method, only if type signature is an exact match */
class TestGenMethods
{
	<T1,T2> void display(T1 a,T2 b)
	{
		System.out.println("Generic method display() executed using parameters of type " + a.getClass().getSimpleName() + " and " + b.getClass().getSimpleName());
	}

	void display(Integer i,String s)
	{
		System.out.println("Normal method display() executed using parameters of type Integer and String");
	}

	<T> T display(T msg)
	{
		return msg;
	}
}

class Prog5
{
	public static void main(String args[ ])
	{
		TestGenMethods tgm = new TestGenMethods();
		tgm.display(100,"Hello All");  // Normal Method
		tgm.display(100.0,"Hello All"); // Generic Method
		tgm.display(23.45,90.88);  // Generic Method
		System.out.print(tgm.display("Welcome To Databyte"));
	}
}
		
