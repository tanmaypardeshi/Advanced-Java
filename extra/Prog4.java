// Example - 1 on Generics by defining our class

class Gen<T> {
	T obj;
	// constructor
	Gen (T obj) {
		this.obj = obj;
	}

	T getObj () {
		return obj;
	}

	// To check if the compiler uses typecasting or not when a generic class is compiled

	void showType () {
		// System.out.println("Type of object is: " + obj.getClass().getName());
		// getName() returns fullname with package java.lang.String, etc.

		System.out.println("Type of object is: " + obj.getClass().getSimpleName());
	}
}

class Prog4 {
	public static void main(String[] args) {
		// Error, generics don't work on pdts, but only references/objects
		// Gen<int> obji = new Gen<int> ();

		Gen<Integer> obji = new Gen<Integer>(1);
		System.out.println("obji contains " + obji.getObj());
		obji.showType();

		Gen<String> objs = new Gen<String>("Hello All");
		System.out.println("objs contains " + objs.getObj());
		objs.showType();
	}
}