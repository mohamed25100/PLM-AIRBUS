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
	
	public static final String[] options = {
			"Afficher tout les avions",
			"Afficher tout les avions contenant un mot clé dans le programme",
			"Ajouter ou supprimer une pièce pour un avion donné",
			"Afficher un avion avec les infos détaillées de chaque pièces",
			"Quitter l'application"
	};
	
	public static final String[] optionsParts = {
			"Afficher toutes les pièces dispo",
			"Ajouter une pièce",
			"Supprimer une pièce",
			"Quitter la boutique des pièces"
	};
	
	public static void main(String[] args) {
		

		 ArrayList<String[]> airplanes = new ArrayList<>();

		 airplanes.add(new String[] {"1", "A320","étude de faisabilité", "Fret"});
		 airplanes.add(new String[] {"2", "A400M","conception", "transport"});
		 airplanes.add(new String[] {"3", "A380","définition", "passager"});
		 airplanes.add(new String[] {"4", "A300","construction", "militaire"});
		 airplanes.add(new String[] {"5", "A380","en service", "transport"});
		 airplanes.add(new String[] {"6", "A380","clôturé", "avions d’affaires"});
		 airplanes.add(new String[] {"7", "A380","clôturé", "Fret"});
		 
		 // pièce
		 ArrayList<String[]> parts = new ArrayList<>();
		 
		 String[][] shopParts ={
				 {"1","compas", "navigation", "5000"},
				 {"2","gps", "navigation", "10000"},
				 {"3","indic vitesse", "pilotage", "7500"},
				 {"4","indic altitude", "pilotage", "3500"},
				 {"5","altimètre", "pilotage", "3500"},
				 {"6","radar météo", "environnement de vol", "15000"},
				 {"7","sys anti collision", "environnement de vol", "50000"}
		 };
		 

		 
		 Scanner scan = new Scanner(System.in);
		 //menu principal
		 int choice = 0;
		 while(choice != 5) {
			 System.out.println("******************************************************");
			 for (int i = 0; i < options.length; i++) {
				System.out.println(i + 1 + " : " + options[i]);
			}
			 System.out.println("******************************************************");
			if(scan.hasNextInt()) {
				choice = scan.nextInt();
				
				switch(choice) {
					case 1:
						showAirplans(scan, airplanes,parts);//"Afficher tout les avions"
						break;
					case 2 :
						searchAirplane(scan, airplanes);//"Afficher tout les avions contenant un mot clé dans le programme",
						break;
					case 3 :
						addOrDeletePart(scan, airplanes, parts, shopParts);//"Ajouter ou supprimer une pièce pour un avion donné",
						break;
					case 4 :
						showAirplaineParts(airplanes, parts);//"Afficher un avion avec les infos détaillées de chaque pièces",
						break;
					case 5 :
						System.out.println("Au revoir");
						break;
					default :
						System.out.println("Choix non valide.");
				
				}
			}
			else {
				System.out.println("Veuillez entrer un nombre valide.");
				scan.nextLine();
			}
		 }
		 
		 
		 
		 //1/ Votre application doit permettre d’afficher tous les avions (id, programme, phase, type) si 
		 //l’utilisateur le souhaite.
		 //showAirplans(scan, airplanes,parts);
		 
		 //Vous devez gérer les saisies erronées ?
		 //addAirplaine(scan, airplanes);
		 //showAirplans(scan, airplanes,parts);
		
		 //addPartToAirplane(scan, airplanes, parts);
		 //showAirplans(scan, airplanes,parts);
		//2/ Rechercher une liste d’avions à partir d’un mot clé affichant tous les avions dont le programme 
		//contient par ex la lettre A ou 320 ou A350…
		//searchAirplane(scan, airplanes);
		
		//4/ Votre appli permet de supprimer une pièce pour un avion, suite à une erreur par ex.
		//deletePartFromAirplane(scan, airplanes, parts);
		//showAirplans(scan, airplanes,parts);
	}

	public static void addAirplaine(Scanner scan, ArrayList<String[]>airplanes) {
		
		System.out.println("Souhaitez-vous ajouter une avion (Oui/Non)?");
		String response = scan.nextLine();
		while(!response.equalsIgnoreCase("oui") && !response.equalsIgnoreCase("non")) {
			System.out.println("Souhaitez-vous ajouter une avion (Oui/Non)?");
			response = scan.nextLine();
		}
		while (response.equalsIgnoreCase("oui")) {
			// generate id
			String id = String.valueOf(airplanes.size() + 1);
			
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
			
			airplanes.add(new String[] {id, program, phase,type});
			System.out.println("Souhaitez-vous ajouter une avion ?");
			response = scan.nextLine();
			while(!response.equalsIgnoreCase("oui") && !response.equalsIgnoreCase("non")) {
				System.out.println("Souhaitez-vous ajouter une avion (Oui/Non)?");
				response = scan.nextLine();
			}
		}
		
	}

	public static void showAirplans(Scanner scan, ArrayList<String[]> airplanes, ArrayList<String[]> parts) {

		// Trouver plusieurs moyens de les afficher (j’en ai trouvé 5)
		for(String[] airplane : airplanes) {
			// System.out.println(Arrays.toString(airplan));
			System.out.println("id: " + airplane[0] +
			", programme: " + airplane[1] + 
			", phase: " + airplane[2] + 
			", type: " + airplane[3]);
			//System.out.println(String.join(" - ", airplane));
//			for(String[] part : parts) {
//				if( part[0].equals(airplane[0]) ) {
//					System.out.println("Nom de pièce: " + part[1] + ", Catégorie: " + part[2] + ",Prix: " + part[3]);
//				}
//			}
		}
		 
	 

	}
	public static void searchAirplane(Scanner scan, ArrayList<String[]> airplanes) {
		System.out.println("Entrez un mot clé du programme");
		String search = scan.nextLine().toUpperCase();
		search = scan.nextLine().toUpperCase();
		boolean found = false;
		for(String[] airplane : airplanes) {
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
    public static void addOrDeletePart(Scanner scan, ArrayList<String[]> airplanes, ArrayList<String[]> parts, String[][] shopParts) {
		 //menu pièces:
		 int choice = 0;
		 while(choice != 4) {
			 System.out.println("******************************************************");
			 for (int i = 0; i < optionsParts.length; i++) {
				System.out.println(i + 1 + " : " + optionsParts[i]);
			}
			 System.out.println("******************************************************");
			if(scan.hasNextInt()) {
				choice = scan.nextInt();
				
				switch(choice) {
					case 1:
						showParts(shopParts);//"Afficher toutes les pièces dispo"
						break;
					case 2 :
						addPartToAirplane(scan, airplanes, parts,shopParts);//"Ajouter une pièce",
						break;
					case 3 :
						deletePartFromAirplane(scan, airplanes, parts);//"Supprimer une pièce",
						break;
					case 4 :
						System.out.println("A bientôt dans notre boutique");//"Quitter la boutique des pièces"
						break;
					default :
						System.out.println("Choix non valide.");
				
				}
			}
			else {
				System.out.println("Veuillez entrer un nombre valide.");
				scan.nextLine();
			}
		 }
	}
    public static void showParts(String[][] parts) {
    	System.out.println("ID=[NOM, CATEGORIE, PRIX]");
    	for(String[] part : parts) {
    		System.out.println(part[0] +"=[" + part[1] + ", " + part[2] + ", " + part[3] + "]");
    		
    	}
	}
	public static void addPartToAirplane(Scanner scan, ArrayList<String[]> airplanes, ArrayList<String[]> parts,String[][] shopParts) {
	    System.out.println("Entrez l'ID de l'avion pour ajouter une pièce:");
	    scan.nextLine();  // clear buffer
	    String airplaneId = scan.nextLine();
	    
	    // Find the airplane by ID
	    if (findAirplaneById(airplanes, airplaneId) != null) {
	        System.out.println("Sélectionnez la pièce à ajouter en entrant l'ID de la pièce:");
	        showParts(shopParts);
	        
	        String partId = scan.nextLine();  // ID of the part to add
	        boolean partExists = false;
	        String[] selectedPart = null;
	        
	        // Verify if the part exists in the shopParts
	        for (String[] part : shopParts) {
	            if (part[0].equals(partId)) {
	                partExists = true;
	                selectedPart = part;
	                break;
	            }
	        }
	        
	        if (partExists) {
	            // Add the part to the airplane's parts list
	            parts.add(new String[] {airplaneId, selectedPart[1], selectedPart[2], selectedPart[3]});
	            System.out.println("Pièce ajoutée avec succès à l'avion ID " + airplaneId);
	        } else {
	            System.out.println("ID de pièce non valide.");
	        }
	        
	    } else {
	        System.out.println("Avion introuvable.");
	    }

//		System.out.println("Entrez l'ID de l'avion pour ajouter une pièce:");
//        String airplaineId = scan.nextLine();
//        airplaineId = scan.nextLine();
//        
//        if (findAirplaneById(airplanes, airplaineId) != null) {
//        	
//            System.out.println("Entrez le nom de la pièce:");
//            String name = scan.nextLine();
//            System.out.println("Entrez la catégorie de la pièce:");
//            String category = scan.nextLine();
//            System.out.println("Entrez le prix de la pièce:");
//            String price = scan.nextLine();
//            parts.add(new String[] {airplaineId, name, category, price});
//            System.out.println("Pièce ajoutée avec succès.");
//            
//        } else {
//            System.out.println("Avion introuvable.");
//        }
		
	}
    public static void deletePartFromAirplane(Scanner scan, ArrayList<String[]> airplanes, ArrayList<String[]> parts) {
        System.out.println("Entrez l'ID de l'avion pour supprimer une pièce:");
        scan.nextLine();
        String airplaneId = scan.nextLine();
        
        if (findAirplaneById(airplanes, airplaneId) != null) {
            System.out.println("Entrez le nom de la pièce à supprimer:");
            String name = scan.nextLine();
            boolean removed = parts.removeIf(part -> part[0].equals(airplaneId) && part[1].equalsIgnoreCase(name));
            if (removed) {
                System.out.println("Pièce supprimée avec succès.");
            } else {
                System.out.println("Pièce non trouvée.");
            }
        } else {
            System.out.println("Avion introuvable.");
        }
    }
    public static void showAirplaineParts(ArrayList<String[]> airplanes, ArrayList<String[]> parts) {
        Scanner scan = new Scanner(System.in);
        
        // Demander à l'utilisateur d'entrer l'ID de l'avion dont il veut voir les détails
        System.out.println("Entrez l'ID de l'avion pour afficher les pièces:");
        String airplaneId = scan.nextLine();
        
        // Trouver l'avion par ID
        String[] selectedAirplane = null;
        for (String[] airplane : airplanes) {
            if (airplane[0].equals(airplaneId)) {
                selectedAirplane = airplane;
                break;
            }
        }
        
        if (selectedAirplane != null) {
            // Afficher les détails de l'avion
            System.out.println("Détails de l'avion :");
            System.out.println("ID: " + selectedAirplane[0] + 
                               ", Programme: " + selectedAirplane[1] + 
                               ", Phase: " + selectedAirplane[2] + 
                               ", Type: " + selectedAirplane[3]);
            
            // Afficher les pièces associées à cet avion
            System.out.println("Pièces associées à cet avion :");
            boolean hasParts = false;
            for (String[] part : parts) {
                if (part[0].equals(airplaneId)) {
                    System.out.println("Nom de pièce: " + part[1] + 
                                       ", Catégorie: " + part[2] + 
                                       ", Prix: " + part[3] + "€");
                    hasParts = true;
                }
            }
            
            if (!hasParts) {
                System.out.println("Aucune pièce associée à cet avion.");
            }
        } else {
            System.out.println("Avion introuvable avec l'ID fourni.");
        }
    }

    public static Object findAirplaneById(ArrayList<String[]> airplanes, String id) {
        for (String[] airplane : airplanes) {
            if (airplane[0].equals(id)) {
                return airplane;
            }
        }
        return null;
	}



    
	// Supprimer une pièce d'un avion

}
	