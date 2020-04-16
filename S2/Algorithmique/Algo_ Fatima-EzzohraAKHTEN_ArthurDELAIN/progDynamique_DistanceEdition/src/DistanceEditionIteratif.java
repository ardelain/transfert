
/**
 *
 */
public class DistanceEditionIteratif implements IDistanceEdition {

    /**
     * Distance d'Edition en Iteratif
     * @param u
     * @param v
     * @return
     */
    public int exec(String u, String v){
        int D[][]=new int[u.length()+1][v.length()+1];
        // D[i][j] ---> d(u[i..|u|],v[j..|v|])
        // initialisation
         for (int i=u.length(); i>=0; i--)
              D[i][v.length()]=u.length()-i;
         for (int i=v.length(); i>=0; i--)
              D[u.length()][i]=v.length()-i;
         //remplissage du tableau
         for (int i=u.length()-1;i>=0;i--)
              for (int j=v.length()-1; j>=0; j--) {
              if (u.charAt(i)==v.charAt(j)){
                      D[i][j]= D[i+1][j+1];
              }else {
                  D[i][j]= 1+Math.min(Math.min(D[i+1][j+1],D[i][j+1]),D[i+1][j]);
              }
         }
         return D[0][0];
    }

    @Override
    public String toString() {
        return "DistanceEditionIteratif";
    }
}
