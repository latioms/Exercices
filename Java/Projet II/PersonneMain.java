 public class PersonneMain {
	public static void main (String[] args)  {
		Personne p = new Personne("Stephane",21,comptes[]);
        p.afficher();   
    }
    
}

class Personne {
    //attributs 
    private String nom ;
    private int age ;
    private  double comptes[] ;

    // constructeurs 
    public Personne(){}
    public Personne(String lenom ,int lage){
        this.nom = lenom ;
        this.age = lage ;
    }
    public Personne(String lenom ,int lage, double compts[]){ 
        this.nom = lenom ;
        this.age = lage ;
	    for(int i=0;i<compts.length ;i++) {
                this.comptes[i] = compts[i];
        }
     void afficher(String lenom,int lage,double compts[]){
        System.out.println("Nom: "+this.nom);
        System.out.println("Age: "+this.age);
        
;
           for (int i=0;i<compts.length ;i++) {
            System.out.println(this.compts[i]);
           }
        
	}
	// methodes   
	 
}