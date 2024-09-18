import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PLMAIRBUS {
	
	//Vous devez gérer les saisies erronées ?
	
	//son programme (A320, A400M, A380, A300…)
	public static final String[] validProgram = {
			"A320", "A400M", "A380", "A300"
	};
	
	//sa phase actuelle (étude 
	//de faisabilité, conception, définition, construction, en service, clôturé)
	public static final String[] validPhase = {
			"étude de faisabilité", "conception", "définition", "construction","en service","clôturé"
	};
	
	//son type (Fret, transport 
	//passager, militaire, avions d’affaires…)
	public static final String[] validType = {
			"Fret", "transport", "passager", "militaire","avions d'affaires"
	};
	
	public static void main(String[] args) {
		

		
		//1/ Votre application doit permettre d’afficher tous les avions (id, programme, phase, type) si 
		//l’utilisateur le souhaite.
		 ArrayList<String[]> airplans = new ArrayList<>();

		 airplans.add(new String[] {"1", "A320","étude de faisabilité", "Fret"});
		 airplans.add(new String[] {"2", "A400M","conception", "transport"});
		 airplans.add(new String[] {"3", "A380","définition", "passager"});
		 airplans.add(new String[] {"4", "A300","construction", "militaire"});
		 airplans.add(new String[] {"5", "A380","en service", "transport"});
		 airplans.add(new String[] {"6", "A380","clôturé", "avions d’affaires"});
		 airplans.add(new String[] {"7", "A380","clôturé", "Fret"});

		// Trouver plusieurs moyens de les afficher (j’en ai trouvé 5)
		for(String[] airplan : airplans) {
			// System.out.println(Arrays.toString(airplan));
			System.out.println("id: " + airplan[0] +
			", programme: " + airplan[1] + 
			", phase: " + airplan[2] + 
			", type: " + airplan[3]);
			// System.out.println(String.join(" - ", airplan));
		}
		int nextId = airplans.size() + 1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez un programme");
		
	}
}
