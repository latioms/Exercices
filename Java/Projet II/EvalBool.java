import java.util.Scanner ;
import java.io.* ;

public class EvalBool{
	
	public static int note = 0 ;
 /*******************************Methodes****************************************/
	public static void clearScreen(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception e){}
	}

	public  static String evaluate(int rep0){ 

		String a = "true", b = "false";
		if (rep0 != 1 && rep0 != 0) {
			System.out.println(" Valeur incorrecte Veuillez ressaisir ");
		}

		if (rep0 == 1)
			return a;
		else 
			return b;				
	}

	public static void main(String[] args) {
		int choix ; boolean check = false ;
		clearScreen();
		String file = "";
		String answ = "" ;
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
					String f1 = "C://Users/Stephane/Desktop/Exercices/Projet II/Questions/bgeo.txt" ;
					String answ1 = "C://Users/Stephane/Desktop/Exercices/Projet II/RepBool/boolgeo.txt";
					file =f1 ;
					answ = answ1;
					check = true ;
					clearScreen();
					System.out.println("OK ! Debutons le Questionnaire de Geographie");
				break;
				case 2:
					String f2 =  "C://Users/Stephane/Desktop/Exercices/Projet II/Questions/bhist.txt";
					String answ2 = "C://Users/Stephane/Desktop/Exercices/Projet II/RepBool/boolhist.txt";
					file = f2 ;
					answ = answ2;
					check = true ;
					clearScreen();
					System.out.println("OK ! Debutons le Questionnaire de Histoire");
				break;
				case 3:
					String f3 = "C://Users/Stephane/Desktop/Exercices/Projet II/Questions/sport.txt";
					String answ3 = "C://Users/Stephane/Desktop/Exercices/Projet II/RepBool/boolsport.txt";
					file = f3 ;
					answ = answ3 ;
					check = true ;
					clearScreen();
					System.out.println("OK ! Debutons le Questionnaire de Sport");
				break;
				case 4:
					String f4 = "C://Users/Stephane/Desktop/Exercices/Projet II/Questions/bjava.txt";
					String answ4 = "C://Users/Stephane/Desktop/Exercices/Projet II/RepBool/booljava.txt";
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
		
		/********************************************Traitement*************************************************/
		File f = new File(file);
		int nbLignes = 0 ;int rep;

		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8")) ;
			BufferedReader checkAnswer = new BufferedReader(new InputStreamReader(new FileInputStream(answ),"UTF-8")) ;
			String 	ligne = reader.readLine();
			
			while (ligne != null) {

				String reponse = checkAnswer.readLine();
				while (reponse != null) {

					System.out.println("**********************Question "+(nbLignes+1)+"*********************");
					System.out.println(ligne); rep = 2;

					while((rep != 0) && (rep != 1)){
						System.out.print("  Vrai(1) Ou Faux(0): ");

						Scanner inRep = new Scanner(System.in);
						rep = inRep.nextInt();

						if((evaluate(rep).equalsIgnoreCase(reponse)) != false) {
							note++ ;
							System.out.println(" Reponse Correcte");
						}
						else{
							System.out.println("  Reponse Incorrecte");
						}
						nbLignes++;
					}	
					reponse = checkAnswer.readLine();
					ligne = reader.readLine();
				}									
			}

			reader.close();
			checkAnswer.close();


			System.out.println("**********************************************************\n");
			System.out.println("Fin. Votre Score est de "+note+"/"+nbLignes);

		}catch(IOException e){
			System.out.println("Erreur de Fichier");
				e.printStackTrace();
		}
	}
}