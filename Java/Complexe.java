/** définition des nombres complexes et quelques opérations */
  public class Complexe {
  private double re;
  private double im;

  /** Crée un Complexe dont les parties réelle et imaginaire sont spécifiées.
   * @param x la partie réelle
   * @param y la partie imaginaire 
      @author Latioms */

  public Complexe(double x, double y) {
    this.re=x;
    this.im=y;
    }

  /** Renvoie une représentation sous forme de chaine de ce Complexe,
   *  les 0 ne sont pas pris en compte,*/
  public String toString() {
    double a = this.re;
    double b = this.im;
    if (a==0 && b==0) return("0");
    if (a!=0 && b==0) return(""+a);
    if (a==0 && b>0) return("i "+b);
    String signei;
    String res="";
    if (a!=0) res+=a;
    if (b>0) signei=" + i "; else {signei=" -  "; b=-b;};
    return(res+signei+b+" i");
    }

  // méthodes d'instance

  /** Renvoie la somme de ce Complexe et du Complexe spécifié.
   * @param c le Complexe à ajouter */
  public Complexe somme(Complexe c) {
    return (new Complexe(this.re+c.re, this.im+c.im));
    }

  /** Renvoie le produit de ce Complexe et du Complexe spécifié.
   * @param c le Complexe par lequel multiplier */
  public Complexe produit(Complexe c) {
    return (new Complexe(this.re*c.re - this.im*c.im,
                         this.re*c.im + this.im*c.re));
    // ou
    // return produit(this,c);
    // Attention, on ne peut pas définir à la fois la méthode d'instance 
    // à partir de la méthode statique et la méthode statique à partir 
    // de la méthode d'instance.
    }

  /** Renvoie le produit de ce Complexe et du double spécifié.
   * @param d le double par lequel multiplier */
  public Complexe produit(double d ) {
    return (new Complexe(this.re*d, this.im*d));
    }

  /** Renvoie l'inverse de ce Complexe */
  public Complexe inverse() {
    /*
    double a=this.re;
    double b=this.im;
    double carreNorme=a*a+b*b;
    return (new Complexe(a/carreNorme, -b/carreNorme));
    */
    // ou
    return this.conjugue().produit(1/this.carreNorme());
    }

  /** Renvoie le conjugué de ce Complexe */
  public Complexe conjugue() {
    return new Complexe(this.re,-this.im);
    }

  /** Renvoie le carré de la norme de ce Complexe */
  public double carreNorme() {
    return this.re*this.re + this.im*this.im;
    }

  /** Renvoie la norme de ce Complexe */
  public double norme() {
    return Math.sqrt(this.carreNorme());
    }
 
  // méthode de classe

  /** Renvoie la somme des deux Complexe spécifiés.
   * @param c1 le premier Complexe
   * @param c2 le deuxième Complexe */
  public static Complexe somme(Complexe c1, Complexe c2) {
    return (new Complexe(c1.re+c2.re, c1.im+c2.im));
    // ou
    // return c1.somme(c2);
    // Attention, on ne peut pas définir à la fois la méthode statique 
    // à partir de la méthode d'instance et la méthode d'instance à partir 
    // de la méthode d'instance. Pourquoi ?
    }

  /** Renvoie le produit des deux Complexe spécifiés.
   * @param c1 le premier Complexe
   * @param c2 le deuxième Complexe */
  public static Complexe produit(Complexe c1, Complexe c2) {
    return (new Complexe(c1.re*c2.re - c1.im*c2.im,
                         c1.re*c2.im + c1.im*c2.re));
    }

  /** Renvoie l'inverse du Complexe spécifié.
   * @param c le Complexe */
  public static Complexe inverse(Complexe c) {
    double a=c.re;
    double b=c.im;
    double norme=a*a+b*b;
    return new Complexe(a/norme, -b/norme);
    }

}