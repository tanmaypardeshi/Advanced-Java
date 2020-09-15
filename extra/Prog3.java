// An example of Singleton class
class Singleton {
	// A static member, to know whether the 1st instance/obj of the class has been created or not.
	// It has to be static because it needs to be referenced using a static method
	// This method returns the instance of the class

	private static Singleton instance = null; // Lazy init
	// For eager init, replace null with new Singleton()

	public String str; // to prove that even instance fields are shared

	// Declare the constructor as private, so that it is not accessible to outside classes
	private Singleton() {
		System.out.println("1st instance of class Singleton created");
		str = "Constructor init";
	}

	// static method to return the instance
	public static Singleton getInstance() {
		// check if the instance is already created or not, required only for lazy init
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
}

class Prog3 {
	public static void main(String[] args) {
		// error, cannot access constructor as it is private
		// Singleton obj1 = new Singleton(); // -> private
		Singleton obj1 = Singleton.getInstance(); // new instance created
		Singleton obj2 = Singleton.getInstance(); // reference for previously created object
		Singleton obj3 = Singleton.getInstance(); // same

		obj2.str = obj2.str.toUpperCase();
		System.out.println("str in obj1 is " + obj1.str); // Capitalized
		System.out.println("str in obj2 is " + obj2.str); // Capitalized
		System.out.println("str in obj3 is " + obj3.str); // Capitalized

		System.out.println("Addr of obj1 is " + obj1); // Address
		System.out.println("Addr of obj2 is " + obj2); // Address
		System.out.println("Addr of obj3 is " + obj3); // Address

		/* Some developers prefer to print hashcode of objs to ensure that it is the same object. Actually, hashcode is not the address of object in memory and is unreliable. It is some integer value which collections like hashmap or hashtable use to hash or calc hash addr of objs while inserting them into the collection. Hashcode is same if Object's class equals() returns true. Same hashcode may be returned for unequal objects.
		 */

		System.out.println("Hashcode of obj1 is " + obj1.hashCode());
		System.out.println("Hashcode of obj2 is " + obj2.hashCode());
		System.out.println("Hashcode of obj3 is " + obj3.hashCode());

	}
}