
/**
 *
 */
public class DistanceEditionRecursif implements IDistanceEdition{
    String u;
    String v;

    /**
     *  Distance d'Edition en Recursif; 'tres gourmant' avec le triple appel reccursif
     * @param u
     * @param v
     * @return
     */
    public int exec(String u, String v){
        //Math.min(23,23);
        if (u.length()==0) return v.length();
        else if (v.length()==0) return u.length();
        else if (u.charAt(0)==v.charAt(0))//pb.
            return exec(u.substring(1),v.substring(1));
        else return 1+
                    Math.min(Math.min(exec(u.substring(1),v),exec(u,v.substring(1))),exec(u.substring(1),v.substring(1)));
    }

    @Override
    public String toString() {
        return "DistanceEditionRecursif";
    }
}
