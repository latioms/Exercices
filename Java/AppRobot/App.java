
class App{

	public static void main(String[] args) {
		
		Robot roboTemoin = new Robot();
		Robot rob0 = new Robot(3,4);
		Robot rob1 = new Robot(5,3);

		System.out.println(roboTemoin.plusFort(rob0,rob1));
		roboTemoin.avancerPlusFort(rob0,rob1);
		System.out.println(rob0);
	}
}
