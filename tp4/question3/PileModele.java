package question3;

import question3.tp3.PileI;
import question3.tp3.PileVideException;
import question3.tp3.PilePleineException;
import java.util.Observable;
import java.util.Observer;

public class PileModele<T> extends Observable implements PileI<T> {
    private PileI<T> pile;
   /**Constructeur.*/
    public PileModele(PileI<T> pile) {
        this.pile = pile;
    }
    /**Empiler.
     * Ajoute des éléments à la pile.
     * @param
     *      o object à empiler.
     */
    public void empiler(T o) throws PilePleineException {
        if (estPleine()) throw new PilePleineException(o.toString());
        try{
            this.pile.empiler(o);
        }catch(Exception e){

        }finally{
            setChanged();
            notifyObservers();
        } 
    }
    /**Dépiler.
     * @return l'état de la pile avec un élément en moins.
     */
    public T depiler() throws PileVideException {
        if (estVide()) throw new PileVideException();
        
        try{
            return this.pile.depiler();
        }catch(Exception e){
            
        }finally{
            setChanged();
            notifyObservers();
        }
        return null;
    }
    /**Retourne le sommet de la pile.
     * @return le sommet.
     */
    public T sommet() throws PileVideException {
        if (estVide()) throw new PileVideException();
        return  this.pile.sommet();
    }
    /**Retourne le nombre d'éléments de la pile.
     * @return la taille.
     */
    public int taille() {
        return pile.taille();
    }
    /**Donne le nombre d'éléments maximum que peut contenir la pile.
     * @return la capacité.
     */
    public int capacite() {
        return pile.capacite();
    }
    /**Retourne vrai si la pile est vide.
     * @return vrai si vide.
     */
    public boolean estVide() {
        return pile.estVide();
    }
    /**Retourne vrai si la pile est pleine.
     * @return vrai si pleine.
     */
    public boolean estPleine() {
        return pile.estPleine();
    }
    /**Méthode toString.*/
    public String toString() {
        return pile.toString();
    }
}
