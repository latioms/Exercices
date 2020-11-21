import java.util.Scanner ;

class greatings {

	public static void main(String[] args) {
		
		Scanner lec = new Scanner(System.in);
		StringBuffer name = new StringBuffer(lec.nextLine());
		StringBuffer great = new StringBuffer("Bonjour ");

		System.out.println(great.append(name));
	}

	
}