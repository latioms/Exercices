class Robot {

	// Defiinittion des position
	 static final int NORD = 0 ;
	 static final int EST = 1 ;
	 static final int SUD = 2 ;
	 static final int OUEST = 3;
  
  /******************Attribut**********************/

   private int x  ;
   private int y  ;

   private int orientation  ;
   /****************Accesseurs********************/

   public int getX(){return (x);}
   public int getY(){return  (y);}
   public int getOrientation(){return (orientation);}



   /*****************Constructeurs******************/

   public Robot(){}
   		// Nous n'avons pas besoin d'affecter les valeurs par defaut 0 a x et y
   		//elles sont deja initialises lors de leurs declarations 
   		//pareil pour l'orientation qui aura la valeur 0 (nord) deja initialise
	public Robot(int a, int b){

		// cette methode placera directement le robot a la position initie
		// au lieu des valeurs par defaut en gardant l'orientation par def
		this.x = a ;
		this.y = b;

	}

	public Robot(int x,int y, int direction){
		//meme chose que celle precedente mais avec l'orientation cette fois
		this.x = x ;
		this.y = y ;

		if (direction < 4) {
			orientation = direction ;
		}		
	}

   /******************Methodes**********************/

   public void avancer(){

   	switch(orientation){
   		case NORD : y++ ;
   			break;
   		case EST : x++;
   			break;
   		case SUD : y--;
   			break;
   		case OUEST : x--;
   			break;}
   }

   public void avancerDeuxPas(){
   	avancer();
   	avancer();
   }

  public void tournerGauche(){
   	switch(orientation){
   		case NORD : orientation = OUEST;
   			break;
   		case EST : orientation = NORD ;
   			break;
   		case SUD : orientation = EST ;
   			break;
   		case OUEST : orientation =  SUD ;
   			break;}
	}
	public void tournerDroite(){
   	 switch(orientation){
   		case NORD : orientation = EST;
   			break;
   		case EST : orientation = SUD;
   			break;
   		case SUD : orientation = OUEST ;
   			break;
   		case OUEST : orientation =  NORD;
   			break;}
   	}

	public double distance(){
   		double d = Math.sqrt((double)(x*x + y*y)) ;
         System.out.println(d) ;
         return d ;
   	} 
   //surchages de distances
   public void distance(Robot robot0){
         int a, b ;
         a = this.x - robot0.x ;
         b = this.y - robot0.y ;
         double d = Math.sqrt((double)(a*a + b*b)) ;
         System.out.println(d) ;      

   }

  public double distance(Robot robot0,Robot robot1){
         int a, b ;
         a = robot1.x - robot0.x ;
         b = robot1.y - robot0.y ;
         double d = Math.sqrt((double)(a*a + b*b)) ;
         return d ;
   } 
   //fin des surcharges
   public Robot plusFort(Robot robot0, Robot robot1){
      Robot plusFort = new Robot();
        if (robot1.distance()>robot0.distance())
         plusFort = robot0 ;
         else
          plusFort = robot1 ;

     return plusFort ;
   }
   public void avancerPlusFort(Robot robot0, Robot robot1){
     plusFort(robot0,robot1).avancer();
   }

/***********Methodes de test et d'affichage*************/

   public void afficherOrientation(){
      switch(orientation){
         case NORD : System.out.println("L'orientation est NORD");
            break;
         case EST : System.out.println("L'orientation est EST");
            break;
         case SUD : System.out.println("L'orientation est SUD");
            break;
         case OUEST : System.out.println("L'orientation est OUEST");
            break;
         default:
            System.out.println("L'orientation entree est incorrecte");
            break;}
   }
   public String toString(){ return ("position dudit robot a x=" +x+"," + "y="+y);}
}