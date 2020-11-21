import java.util.Scanner ;
import java.io.* ;

class AnsweRecord2{

	public static void main(String[] args) throws IOException {
 /******************Entree des Fichiers*************************/
	 String file ;
	  try{
		if((args[0] != "") && (args.length != 0)) {
				file = args[0] ;
				File f = new File(file);
		
			File answ = new File("C://Users/Stephane/Desktop/Exercices/Projet II/reponse.txt");
		
			if (f.exists()) {
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
				
					ligne = reader.readLine();
				}
				bw.close();
				reader.close();			
			}
		}
	  }catch(ArrayIndexOutOfBoundsException e){
		System.out.println("Erreur d'arguments");
		}
	}
}
