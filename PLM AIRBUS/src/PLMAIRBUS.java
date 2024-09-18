import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PLMAIRBUS {
	
	//Vous devez gérer les saisies erronées ?
	
	//son programme (A320, A400M, A380, A300…)
	public static final String[] validPrograms = {
			"A320", "A400M", "A380", "A300", "A350"
	};
	
	//sa phase actuelle (étude 
	//de faisabilité, conception, définition, construction, en service, clôturé)
	public static final String[] validPhases = {
			"étude de faisabilité", "conception", "définition", "construction","en service","clôturé"
	};
	
	//son type (Fret, transport 
	//passager, militaire, avions d’affaires…)
	public static final String[] validTypes = {
			"Fret", "transport", "passager", "militaire","avions d'affaires"
	};
	
	public static void main(String[] args) {

		 ArrayList<String[]> airplans = new ArrayList<>();

		 airplans.add(new String[] {"1", "A320","étude de faisabilité", "Fret"});
		 airplans.add(new String[] {"2", "A400M","conception", "transport"});
		 airplans.add(new String[] {"3", "A380","définition", "passager"});
		 airplans.add(new String[] {"4", "A300","construction", "militaire"});
		 airplans.add(new String[] {"5", "A380","en service", "transport"});
		 airplans.add(new String[] {"6", "A380","clôturé", "avions d’affaires"});
		 airplans.add(new String[] {"7", "A380","clôturé", "Fret"});
		 
		 Scanner scan = new Scanner(System.in);
		//1/ Votre application doit permettre d’afficher tous les avions (id, programme, phase, type) si 
		//l’utilisateur le souhaite.
		 
		 
		 String show = "";
		 do {
			 System.out.println("Souhaitez vous affiher la liste des avions ( Oui/Non ) ?");
			 show = scan.nextLine();
		 }while (!show.equalsIgnoreCase("oui") && !show.equalsIgnoreCase("non"));
			 
		 
		 if(show.equalsIgnoreCase("oui")) {
			 showAirplans(airplans);
		 }
		
		// generate id
		String id = String.valueOf(airplans.size() + 1);
		
		String program = "";
		String phase = "";
		String type = "";
		
		
		// program :
		do {
			System.out.println("Entrez un programme (ex: " + String.join(", ", validPrograms) + "):");
			program = scan.nextLine().toUpperCase();
		}
		while ( !isValidProgram(program) || program.isEmpty());
		
		//phase :
		do {
			System.out.println("Entrez une phase (ex: " + String.join(", ", validPhases) + "):");
			phase = scan.nextLine();
		}
		while ( !isValidPhase(phase) || phase.isEmpty());
		
		//type :
		do {
			System.out.println("Entrez une phase (ex: " + String.join(", ", validTypes) + "):");
			type = scan.nextLine();
		}
		while ( !isValidType(type) || type.isEmpty());
		
		airplans.add(new String[] {id, program, phase,type});
		
		//2/ Rechercher une liste d’avions à partir d’un mot clé affichant tous les avions dont le programme 
		//contient par ex la lettre A ou 320 ou A350…
		searchAirplane(scan, airplans);
		
	}
	public static void showAirplans(ArrayList<String[]> airplans) {
		// Trouver plusieurs moyens de les afficher (j’en ai trouvé 5)
		for(String[] airplane : airplans) {
			// System.out.println(Arrays.toString(airplan));
			System.out.println("id: " + airplane[0] +
			", programme: " + airplane[1] + 
			", phase: " + airplane[2] + 
			", type: " + airplane[3]);
			// System.out.println(String.join(" - ", airplan));
		}
	}
	public static boolean isValidProgram(String program) {
		for(String validProgram : validPrograms) {
			if(program.equalsIgnoreCase(validProgram)) return true;
		}
		return false;
	}
	public static boolean isValidPhase(String phase) {
		for(String validPhase : validPhases) {
			if(phase.equalsIgnoreCase(validPhase)) return true;
		}
		return false;
	}
	public static boolean isValidType(String type) {
		for(String validType : validTypes) {
			if(type.equalsIgnoreCase(validType)) return true;
		}
		return false;
	}
	public static void searchAirplane(Scanner scan, ArrayList<String[]> airplans) {
		System.out.println("Entrez un mot clé du programme");
		String search = scan.nextLine().toUpperCase();
		
		boolean found = false;
		for(String[] airplane : airplans) {
			if(airplane[1].toUpperCase().contains(search)) {
				System.out.println("id: " + airplane[0] +
						", programme: " + airplane[1] + 
						", phase: " + airplane[2] + 
						", type: " + airplane[3]);
				found = true;
			}
		}
		if(!found) {
			System.out.println("Aucune avion trouvé");
		}
	}
}
