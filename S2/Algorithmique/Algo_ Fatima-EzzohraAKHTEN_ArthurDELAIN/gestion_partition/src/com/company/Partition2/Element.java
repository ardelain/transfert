package com.company.Partition2;

public class Element {

    private int num;
    private int taille;

    public Element(int num, int taille) {
        this.num = num;
        this.taille = taille;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        if (num != element.num) return false;
        return taille == element.taille;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + taille;
        return result;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
}
