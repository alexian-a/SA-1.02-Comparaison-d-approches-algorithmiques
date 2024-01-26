/**
 *
 * Représente un objet Etudiant avec les paramètres suivant :
 * le nom, 
 * le prénom,
 * le numéro de groupe, 
 * et le groupe de travaux pratiques (TP).
 */
public class Etudiant {

	// Le nom de l'étudiant.
    String nom;

    // Le prénom de l'étudiant.
    String prenom;

    // Le numéro de groupe auquel l'étudiant appartient.
    int numGroupe;

    // Le groupe de travaux pratiques (TP) auquel l'étudiant est assigné.
    String groupeTP;

    /**
     * Constructeur de la classe Etudiant permettant d'initialiser les propriétés
     * nom, prenom, numGroupe, et groupeTP lors de la création d'un objet Etudiant.
     *
     * @param pfNom Le nom de l'étudiant.
     * @param pfPrenom Le prénom de l'étudiant.
     * @param pfNumGroupe Le numéro de groupe de l'étudiant.
     * @param pfGroupeTP Le groupe de TP de l'étudiant.
     */
    Etudiant(String pfNom, String pfPrenom, int pfNumGroupe, String pfGroupeTP) {
        // Initialisation des propriétés avec les valeurs fournies en paramètres
        this.nom = pfNom;
        this.prenom = pfPrenom;
        this.numGroupe = pfNumGroupe;
        this.groupeTP = pfGroupeTP;
    }
}
