package com.company.Partition1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ArbrePartition servant a la Gestion de Partition
 */
public class ArbrePartition {
    int nom;
    int taille;
    int poid;
    private ArbrePartition pere;

    List<ArbrePartition> fils = new ArrayList<>();

    public ArbrePartition(int nom) {
        this.pere = this;
        this.nom = nom;
        this.taille = 1;
        this.poid = 0;
    }

    public ArbrePartition(int nom, int poid) {
        this.pere = this;
        this.nom = nom;
        this.taille = 1;
        this.poid = poid;
    }

    public ArbrePartition rechercheRacine(){
        if(this.pere == this){
            return this;
        }else{
            return this.pere.rechercheRacine();
        }
    }

    public void union(ArbrePartition gp){
        this.rechercheRacine().setPere(gp);
        this.rechercheRacine().poid += gp.poid;
    }

    public void union(ArbrePartition gp, int n){
        gp.rechercheRacine().poid += n + this.rechercheRacine().poid ;
        this.rechercheRacine().setPere(gp);
    }

    //La hauteur d'un arbre a n noeuds créé par union pondérée est au plus 1+[log2(n)]
    public void union_pondere(ArbrePartition gp, int n){
        ArbrePartition gpR1 = gp.rechercheRacine();
        ArbrePartition gpR2 = this.rechercheRacine();
        if(gpR1 == gpR2){
            //System.out.println("IDENTIQUE");
            return;}
        if(gpR1.taille > gpR2.taille){
            gpR2.setPere(gpR1);
            gpR1.poid += n + gpR2.poid ;
            //gpR1.taille += gpR2.taille;
        }else{
            if(gpR1.taille < gpR2.taille) {
                gpR1.setPere(gpR2);
                gpR2.poid += n + gpR1.poid;
                //gpR2.taille += gpR1.taille;
            }else{
                gpR1.taille ++;
            }
        }
        /*if (gpR1.taille == gpR2.taille) {
            gpR1.taille ++;
        }*/
        //this.rechercheRacine().setPere(gp);
    }

    public ArbrePartition getPere() {
        return pere;
    }

    public void setPere(ArbrePartition pere) {
        this.pere = pere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArbrePartition that = (ArbrePartition) o;
        return nom == that.nom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "ArbrePartition{" +
                "nom=" + nom +
                ", pere=" + pere.nom +
                '}';
    }
}
