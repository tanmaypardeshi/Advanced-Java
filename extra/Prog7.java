/* To prove that generic classes cannot contain static vars & arrays of generic type */
import java.util.*;

/* class Gen<T>
{
	private static T var;

	T arr[ ] = new T[10];
} */

// static vars are shared vars for all objects. Now suppose if we create 2 classes 
// 1. with Integer datatype 2. with String datatype
// Now the question comes whether T is to be replaced with Integer or String?
// Basically, generics is implemented @ compile time whereas arrays being dynamic are 
// implemented at run time. Now during the compilation, the compiler will apply Type Erasure
// & substitute the type with Object & use casts wherever reqd. Now @ run time, if the generic
// type is not known to JRE, how can it allocate memory for an array of unknown type?
// Arrays were introduced before Generics. Also arrays are "covariant" whereas generics are
// "invariant" (collections)
class Prog7
{
	public static void main(String args[ ])
	{
		Integer arri[ ] = {1,2,3};
		// Number is a super class for all numeric types
		Number arrn[ ] = arri;  // OK, support for polymorphism
		arrn[0] = 3.5;  // for compile ok, will give run time error

		ArrayList<Integer> obji = new ArrayList<Integer>(); // no array is reqd bcoz
			// the ArrayList uses an array beneath it to store data
		// ArrayList<Number> objn = obji; // compile error. Incompatible types
		// obji.add(3.5);  // compile error
		// Having compile time errors is better than run time error
	}
}

