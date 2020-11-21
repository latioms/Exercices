import java.util.Scanner ;
import java.io.* ;

class AnsweRecord{

	public static void main(String[] args) {

		File f = new File("C://Users/Stephane/Desktop/Exercices/Projet II/Questions/question.txt");
		File answ = new File("C://Users/Stephane/Desktop/Exercices/Projet II/reponse.txt");

     /****************************************Post-declaration*******************************************/

		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8")) ;
			FileWriter writer = new FileWriter(answ);
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

				sc.close();
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
