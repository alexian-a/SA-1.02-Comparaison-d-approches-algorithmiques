/**
 * Représente un tableau d'étudiants (TNPEtud) avec une capacité maximale spécifiée.
 */
public class TNPEtud {

    // Le nombre d'étudiants actuellement stockés dans le tableau.
    int nbEtud;

    // Tableau d'objets Etudiant destiné à stocker les étudiants.
    Etudiant[] etud;

    /**
     * Constructeur de la classe TNPEtud permettant d'initialiser un tableau d'étudiants
     * avec une capacité maximale spécifiée.
     *
     * @param pfEtudMax La capacité maximale du tableau d'étudiants.
     */
    TNPEtud(int pfEtudMax) {
        // Initialisation du tableau d'étudiants avec la capacité maximale spécifiée
        this.etud = new Etudiant[pfEtudMax];
        // Initialisation du nombre d'étudiants initialiser à 0
        this.nbEtud = 0;
    }
}

