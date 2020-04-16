package com.company.Partition2;

import java.util.ArrayList;
import java.util.List;

public class ListePartition {

    private int valeur;
    private List<Element> list = new ArrayList<>();

    public void ajouter(Element e){
        list.add(e);
    }

    public boolean recherche(Element e){
        for(Element elem: list){
            if(elem == e){
                return true;
            }
        }
        return false;
    }

    public boolean recherche(int num){
        for(Element elem: list){
            if(elem.getNum() == num){
                return true;
            }
        }
        return false;
    }

    public List<Element> getList() {
        return list;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        String s = "";
        for(Element elem: list){
               s+= elem.getNum()+" ";
        }
        return " {" +
                " list=" + s +
                '}';
    }
}
