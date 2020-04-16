package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    private int nom;// nom


    public Node(int nom) {
        this.nom = nom;
        //list_arcs = new HashMap<>();
    }


    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Node{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
