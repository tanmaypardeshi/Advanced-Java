// an eg of annotations
import java.util.*;

class Base
{
	void display()
	{
		System.out.println("Invocation of display() by Base class");
	}
}

class Derived extends Base
{
	@Override  // case sensitive & also referred as a decorator
	void display()
	{
		System.out.println("Invocation of display() by Derived class");
	}

	@Deprecated
	void show()
	{
		System.out.println("Calling show()");
	}
}

class Prog8
{
	// by writing this, we are telling/assuring the compiler that we are aware of what
	// we are doing
	@SuppressWarnings({"deprecation","unchecked"})
	public static void main(String args[ ])
	{
		Derived objd = new Derived();
		objd.display();
		objd.show();  // issues a warning

		Vector v = new Vector();  // as generics is not used, the compiler will say
				// there may be some runtime/unchecked exceptions
		v.add("Swapnil");
		v.add("Shalaka");
		v.add(10000.45);
	}
}		
	