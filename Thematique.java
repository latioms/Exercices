import java.util.Scanner ;
import java.io.* ;

class Thematique{

	public static void clearScreen(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception e){}
	}

	public static void main(String[] args) {
		int choix ; boolean check = false ;
		clearScreen();
		String file = "", answ = "";

		/*************************Pre-traitement: choix des fichiers*********************************/
		while(check == false){	
		System.out.println("******************************************************************************");
		System.out.println("Bonjour Mr/Mme Veuillez choisir une thematique pour le Questionnaire : ");
		System.out.println("1: Geographie ");
		System.out.println("2: Histoire ");
		System.out.println("3: Sport");
		System.out.println("4: Java");
		System.out.println("******************************************************************************");
		System.out.print("Merci d'entrer votre choix: ");
		Scanner choice = new Scanner(System.in);
		choix = choice.nextInt();
			
			switch(choix){
			case 1:
			String f1 = "C://Users/Stephane/Desktop/Exercices/Projet II/Questions/geo.txt" ;
			String answ1 = new String("C://Users/Stephane/Desktop/Exercices/Projet II/Reponses/repgeo.txt");
			file =f1 ;
			answ = answ1;
			check = true ;
			clearScreen();
			System.out.println("OK ! Debutons le Questionnaire de Geographie");
				break;
			case 2:
			String f2 = new String("C://Users/Stephane/Desktop/Exercices/Projet II/Questions/hist.txt");
			String answ2 = new String("C://Users/Stephane/Desktop/Exercices/Projet II/Reponses/rephist.txt");
			file = f2 ;
			answ = answ2;
			check = true ;
			clearScreen();
			System.out.println("OK ! Debutons le Questionnaire de Histoire");
				break;
			case 3:
			String f3 = new String("C://Users/Stephane/Desktop/Exercices/Projet II/Questions/sport.txt");
			String answ3 = new String("C://Users/Stephane/Desktop/Exercices/Projet II/Reponses/repsport.txt");
			file = f3 ;
			answ = answ3 ;
			check = true ;
			clearScreen();
			System.out.println("OK ! Debutons le Questionnaire de Sport");
				break;
			case 4:
			String f4 = new String("C://Users/Stephane/Desktop/Exercices/Projet II/Questions/java.txt");
			String answ4 = new String("C://Users/Stephane/Desktop/Exercices/Projet II/Reponses/repjava.txt");
			file = f4 ;
			answ = answ4 ;
			check = true ;
			clearScreen();
			System.out.println("OK ! Debutons le Questionnaire de Java");
				break;
			default : 
			clearScreen();
			System.out.println("Erreur de Saisie, Veuillez ressaisir: ");
			break;
			}		
		}
		File f = new File(file);
		File answe = new File(answ);

		/*******************************************Traitement************************************************/	
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8")) ;
			FileWriter writer = new FileWriter(answe);
			BufferedWriter bw  = new BufferedWriter(writer);

			String 	ligne = reader.readLine();
			String rep ;
			while (ligne != null) {

				System.out.println(ligne) ;
				Scanner sc = new Scanner(System.in);

				bw.write(ligne) ; // on enregistre la Question dans le tampon->fichier
				bw.newLine(); // On passe a la question Suivante

				rep = sc.nextLine(); // on enregistre la reponse
				bw.write("  "+ rep);
				bw.newLine();

				
				ligne = reader.readLine() ;
			}
			bw.close();
			reader.close();

		}catch(IOException e){
			System.out.println("Erreur de Fichier");
				e.printStackTrace();
		}
	}
}