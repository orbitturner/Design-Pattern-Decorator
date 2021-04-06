/**
 * =============================================
 * EVERYTHING IS NESTED IN ONE FILE FOR FASTER
 * EXPLANATIONS
 * =============================================
 */

// =======================================================================================

/**
 * 🟡 STEP 01 🟡
 * First, we create the abstract class which 
 * groups together the common methods and attributes.
 * These are the methods that we will use in the other classes.
 */
abstract class Voiture {
	String libelle;
	int prix;
	int poids;
	
	public String getLibelle() { return libelle; }
	public int getPrix() { return prix; }
	public int getPoids() { return poids; }
	
	protected void setLibelle(String libelle) {this.libelle = libelle;}
	protected void setPrix(int prix) {this.prix = prix;}
	protected void setPoids(int poids) {this.poids = poids;}
	
	public String toString() { return "Voiture : " + getLibelle() + ", Prix : " + getPrix() + ", Poids : " + getPoids(); }
}

// =======================================================================================
   
/**
 * 🟡 STEP 02🟡
 * Now we create the Corsa class and the C2 class which
 * correspond to the Concrete Component classes.  
 * They inherit from the car class. 
 * In the constructor of these classes we define their attributes using the mutators of their parent class. 
 */
class Corsa extends Voiture{
    	public Corsa() {
    		this.libelle = "Corsa "; 
		this.prix = 5000;
		this.poids = 1500;
    	}	
}
    class C2 extends Voiture{
    	public C2() {
    		this.libelle = "C2 "; 
		this.prix = 4000;
		this.poids = 1000;
    	}		
}
 
// =======================================================================================

/**
 * 🟡 STEP 03🟡
 * Now we create the Decorator. 
 * This one has a car as an attribute and we choose the methods that we have to redefine. 
 * Here, it will be the methods: getLibelle (), getPrix (), getPoids ().
 */
abstract class DecorateurVoiture extends Voiture{
	protected Voiture voiture;
	
	public abstract String getLibelle();
	public abstract int getPrix();
	public abstract int getPoids();
}

// =======================================================================================

/**
 * 🟡 STEP 04🟡
 * We create a class for each option we want to add. 
 * Each option (Sunroof, GPS, Regulator, etc.) must inherit 
 * from the Car Decorator class and redefine its methods. 
 */
class ToitOuvrant extends DecorateurVoiture{
	public ToitOuvrant(Voiture v) { voiture = v;}
	public String getLibelle() { return voiture.getLibelle() + "+ Toit Ouvrant "; }
	public int getPrix() {return voiture.getPrix() + 2000;}
	public int getPoids() {return voiture.getPoids() + 15;}	
}
class GPS extends DecorateurVoiture{
	public GPS(Voiture v) { voiture = v;}
	public String getLibelle() { return voiture.getLibelle() + "+ GPS "; }
	public int getPrix() {return voiture.getPrix() + 1000;}
	public int getPoids() {return voiture.getPoids() + 20;}	
}
class Regulateur extends DecorateurVoiture{
	public Regulateur(Voiture v) { voiture = v;}
	public String getLibelle() { return voiture.getLibelle() + "+ Regulateur "; }
	public int getPrix() {return voiture.getPrix() + 200;}
	public int getPoids() {return voiture.getPoids() + 1;}	
}

// =======================================================================================
/**
 * 🟡 STEP 05🟡
 * Now we implement the main to use our decorator.
 */
public class Main
{
     // Méthode principale.
     public static void main(String[] args)
     {
             Voiture v1 = new Corsa();
             System.out.println(v1);

             Voiture v2 = new C2();
             v2 = new Regulateur(v2);
             System.out.println(v2);
             
             Voiture v3 = new Corsa();
             v3 = new ToitOuvrant(v3);
	     v3 = new GPS(v3);
             System.out.println(v3);
     }
}
