/* We can also declare Generic Methods as static methods. Define a static method which prints
all the elements of any given array */
class Prog6
{
	public static void main(String args[ ])
	{
		String arrs[ ] = {"kamlesh","suresh","amit","sunil"};
		Integer arri[ ] = {90,345,56,-1333,673,113};
		Character arrc[ ] = {'d','a','t','a','b','y','t','e'};

		display(arrs);
		display(arri);
		display(arrc);
	}

	 static <T> void display(T arr[])  // For arrays, int or char is not auto boxed to Integer
				// or Character
	{
		for (int i=0;i<arr.length;i++)
			System.out.print(arr[i] + "\t");

		System.out.println();
	}
}
