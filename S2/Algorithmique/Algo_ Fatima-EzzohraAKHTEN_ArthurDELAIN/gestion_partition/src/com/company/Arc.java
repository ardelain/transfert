package com.company;

import java.util.Objects;

/**
 * arc orienté tpe A->B
 */
public class Arc {
    private Node a;//premier sommer
    private Node b;//second sommet
    private int valeur = 0;//valeur de l'arc

    public Arc(Node a, Node b) {
        this.a = a;
        this.b = b;
    }

    public Arc(Node a, Node b,int valeur) {
        this.a = a;
        this.b = b;
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Node getA() {
        return a;
    }

    public void setA(Node a) {
        this.a = a;
    }

    public Node getB() {
        return b;
    }

    public void setB(Node b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arc arc = (Arc) o;
        return valeur == arc.valeur &&
                Objects.equals(a, arc.a) &&
                Objects.equals(b, arc.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, valeur);
    }

    @Override
    public String toString() {
        return "Arc{" +
                "a=" + a +
                ", b=" + b +
                ", valeur=" + valeur +
                '}';
    }
}
