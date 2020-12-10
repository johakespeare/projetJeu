package Armes;

public class Epee extends Arme{
    //ATTRIBUTS
    private int poids;

    //CONSTRUCTEUR
    public Epee(Portee taille, int degats , int poids) {
        super(taille,degats);
    }

    //GETTERS
    public int getPoids() {
        return this.poids;
    }
    //SETTERS
    public void setPoids(int poids) {
        this.poids = poids;
    }

    //METHODES
    @Override
    public int calculDegats() {
        return poids*degats;
    }
}
