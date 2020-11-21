import java.util.Scanner ;

class great {

	public static void main(String[] args) {

		System.out.print("Comment vous appelez vous ? \n");

		Scanner lec = new Scanner(System.in);
		String name = lec.nextLine();

		System.out.println("Bonjour " + name);

	}
}