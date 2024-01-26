import java.io.*;
import java.util.Scanner;

public class ListeEtudiants {
    
    /** Charge dans un tableau la liste des étudiants
     *  @param   pfFileName IN le nom du fichier à lire
     *  @param   pfDelimiter IN le délimiteur de champs dans le fichier csv
     *  @return le tableau
     **/
    public static TNPEtud getListe(String pfFileName, String pfDelimiter) 
        throws FileNotFoundException{
        
        // Ouvre un fichier et compte le nombre  de lignes du fichier.
        //   Ce nombre de lignes correspond au nombre d'étudiants
        BufferedReader read = new BufferedReader(new FileReader(pfFileName));
        int nbElt = 0;

        // le try catch est la pour recuperer des erreurs eventuelles de lecture
        // dans le fichier. Si une erreur se produit, ce sont les instructions
        // du catch qui seront executees (sera vu en semaine 46).
        try {
            while (read.readLine() != null) {
                nbElt++;
            }
            read.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        } 
       
        System.out.println("nombre de lignes/etudiants : " + nbElt);

        // Création d'un tableu de type Etudiant à une entré, qui sera retourné.
        
        TNPEtud res = new TNPEtud(nbElt);
        // lecture du fichier pour récupérer les noms et prénoms
        String line = "";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pfFileName));
            int cpt = 0; // numero de l'etudiant en lecture
            System.out.println("nombre de lignes : " + nbElt);

            // loops through every line until null found
            while ((line = reader.readLine()) != null) {
                
                // separate every token by comma
                String[] token = line.split(pfDelimiter);    

                // Ajout d'un étudiant dans le tableau res.
                res.etud[cpt] = new Etudiant(token[0], token[1], Integer.parseInt(token[2]),token[3]);
                 
                 
                cpt ++;
            }
            res.nbEtud = cpt;
            reader.close(); 
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return res;
    }
    
    
/**
 *
 * Trie un tableau TNPEtud (TNPEtud.tab.etud) contenant des objets de type Etudiant
 * en utilisant l'ordre lexicographique des noms et prénoms des étudiants.
 *
 * @param tab IN/OUT Le tableau TNPEtud à trier.
 */
public static void triEtud(TNPEtud tab) {
    // Déclaration d'une variable booléenne pour indiquer si une permutation a été effectuée
    boolean permut = true;
    
    // Déclaration d'une variable temporaire pour stocker un étudiant lors d'une permutation
    Etudiant ech;

    // Boucle principale pour le tri
    while (permut) {
        // Initialisation de permut à false avant de parcourir le tableau
        permut = false;

        // Boucle parcourant le tableau d'étudiants jusqu'à l'avant-dernier élément
        for (int i = 0; i < tab.nbEtud - 1; i++) {
            // Comparaison lexicographique des noms et prénoms des étudiants consécutifs
            if ((tab.etud[i].nom).compareTo(tab.etud[i + 1].nom) > 0 ||
                ((tab.etud[i].nom).compareTo(tab.etud[i + 1].nom) == 0 &&
                (tab.etud[i].prenom).compareTo(tab.etud[i + 1].prenom) > 0)) {
                // Permutation des étudiants si l'ordre n'est pas respecté
                ech = tab.etud[i];
                tab.etud[i] = tab.etud[i + 1];
                tab.etud[i + 1] = ech;
                // Modification de permut à true pour indiquer qu'une permutation a eu lieu
                permut = true;
            }
        }
    }
}
    
    
/**
  *
 * Recherche dichotomique dans un tableau trié TNPEtud (TNPEtud.tab.etud)
 * basée sur les noms et prénoms d'étudiants.
 *
 * @param tab IN Le tableau TNPEtud trié dans lequel effectuer la recherche.
 * @param pfNom IN Le nom partiel pour la recherche dichotomique.
 * @param pfPrenom IN Le prénom partiel pour la recherche dichotomique.
 * @return L'indice de l'étudiant correspondant ou -1 si non trouvé.
 */
public static int testDichotomique(TNPEtud tab, String pfNom, String pfPrenom) {
    // Initialisation du compteur d'itérations
    int cpt = 0;
    
    // Initialisation des indices de début et de fin de recherche dans le tableau
    int idMin = 0;
    int idMax = tab.nbEtud - 1;
    
    // Déclaration de la variable pour le milieu de la recherche
    int milieu;

    // Boucle de recherche dichotomique
    while (idMin < idMax) {
        // Calcul du milieu entre idMin et idMax
        milieu = (idMin + idMax) / 2;
        
        // Comparaison du nom de l'étudiant au milieu avec le nom partiel
        if (tab.etud[milieu].nom.equals(pfNom)) {
            // Comparaison du prénom de l'étudiant au milieu avec le prénom partiel
            if ((tab.etud[milieu].prenom).compareTo(pfPrenom) < 0) {
                idMin = milieu + 1;
            } else if ((tab.etud[milieu].prenom).compareTo(pfPrenom) > 0) {
                idMax = milieu - 1;
            } else {
                // L'étudiant correspondant est trouvé, affichage et retour de l'indice
                System.out.println("Le test dichotomique est fini en " + cpt + " tours ");
                return milieu;
            }
        } else {
            // Si le nom de l'étudiant au milieu ne correspond pas, ajustement des indices
            if ((tab.etud[milieu].nom).compareTo(pfNom) < 0) {
                idMin = milieu + 1;
            } else {
                idMax = milieu - 1;
            }
        }
        
        // Incrémentation du compteur d'itérations
        cpt++;
    }

    // Si la recherche ne trouve pas d'étudiant correspondant, affichage et retour de -1
    System.out.println("La recherche par dichotomique est finie en " + cpt + " itérations et n'a trouvé personne ");
    return -1;
}
    
    /**
 * Décrivez votre classe AvecRupture ici.
 * 
 * @author Pas de moi
 * @version 11/01/2024
 */

    /**
     * recherche des éléments avec rupture
     * 
     * @param NbEtud IN tableau d'étudiants
     * @param Nom     IN le nom des étudiants
     * @param Prenom  IN le prénom des étudiants
     * @return 0 ou 1
     */
    public static void rupture(TNPEtud NbEtud, String pfNom, String pfPrenom) {
        boolean exist = false; // Innitialisation de existe à false
        int cpt = 0;
        for (int i = 0; i < NbEtud.nbEtud && exist == false; i++) { // Tant que i est inférieur au total du tableau on lui ajoute 1
            cpt++;
            if (NbEtud.etud[i].nom.equals(pfNom) && NbEtud.etud[i].prenom.equals(pfPrenom)) {
                exist = true; // Si nom trouver nnitialisation de existe à true
            }
        } 
        System.out.println("La recherche avec rupture est fini en " + cpt + " itérations");
    }
    
    /**
     * Recherche d'un étudiant sans ruptureà
     *
     * @author Pas de moi
     *
     * Cherche un nom et un prenom dans une matrice sans rupture
     * @param NbElt IN Le tableau d'étudiant
     * @param pfNom IN Le nom de l'etudiant rechercher
     * @param pfPrenom IN Le prenom de l'etudiant rechercher
     * @return le dernier indice de la position du nom et prenom dans le tableau
     */
    public static int SansRupture(TNPEtud pfTNP , String pfNom,String pfPrenom){
        int cpt = 0;
        int exist = 0;
        for ( int i = 0; i < pfTNP.nbEtud; i++){
            cpt++;
            if((pfTNP.etud[i].nom.compareTo(pfNom)==0 && pfTNP.etud[i].prenom.compareTo(pfPrenom)==0)){
                exist = 1;
            }
        }
        System.out.println("La recherche sans rupture est fini en " + cpt + " itérations");
        return exist;
        }
    
    /**
     *
     * Méthode principale du programme, responsable de l'exécution du tri, de la recherche et de l'affichage des résultats.
     */
    public static void main() {
        try {
            // Appel de la fonction getListe pour lire le fichier CSV et créer un objet TNPEtud
            // avec le nom du fichier "listenomssansaccent.csv" et le séparateur de colonnes ","
            TNPEtud promo = getListe("listenomssansaccent50.csv", ",");
            
            // Affichage du nombre total d'étudiants dans la promotion
            System.out.println("Il y a : " + promo.nbEtud + " étudiants.");
            
            // Tri du TNPEtud par ordre alphabétique du nom et prénom
            triEtud(promo);
            
            // Initialisation d'un scanner pour la saisie depuis la console
            Scanner clavier = new Scanner(System.in);
            
            // Saisie du nom à rechercher
            System.out.println("Saisir un nom à rechercher : ");
            String rechNom = clavier.next();
            
            // Saisie du prénom à rechercher
            System.out.println("Saisir un prénom à rechercher : ");
            String rechPrenom = clavier.next();

            System.out.println("-------------------");
            // Recherche sans rupture
            SansRupture(promo, rechNom, rechPrenom); 
            
            System.out.println("-------------------");
            
            // Recherche avec rupture
            rupture(promo, rechNom, rechPrenom);
            
            System.out.println("-------------------");

            // Recherche par dichotomie
            int resDico = testDichotomique(promo, rechNom, rechPrenom);
            
            System.out.println("-------------------");
            
            // Affichage de l'index du TNPEtud.etud ou se trouve / ou pas le nom et prenom rechercher par la fonction testDichotomique
            if (resDico != -1) {
                System.out.println("La personne : "+rechNom+" "+rechPrenom+" se trouve en position "+resDico);
            } else {
                System.out.println("La personne : "+rechNom+" "+rechPrenom+" ne se trouve pas dans la liste");
            }
            
        } catch (Exception e) {
            // Gestion des exceptions : Affichage du message d'erreur en cas de problème
            System.out.println("Erreur : " + e.getMessage());
        }
    }
      
}

