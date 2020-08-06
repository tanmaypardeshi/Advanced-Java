// an eg. of executable class which makes use of the bean

class Prog1
{
    public static void main(String[] args)
    {
        // create the bean component
        Person p = new Person();

        p.setName("Akshay Kumar");
        p.setDeceased(false);

        System.out.println("Name of actor is " + p.getName());
        System.out.println("Status " + (p.getDeceased() ? "Dead" : "Alive"));

    }
}