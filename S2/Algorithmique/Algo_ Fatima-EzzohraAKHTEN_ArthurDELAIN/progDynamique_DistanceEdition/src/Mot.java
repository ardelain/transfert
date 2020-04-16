import java.util.Random;

public class Mot {
    private String mot;
    private char[] liste_lettre;

    public Mot(String mot) {
        this.mot = mot;
    }

    private static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static int charLength = chars.length();

    /**
     *
     * @param length
     * @return
     */
    public static String generateString(int length) {
        Random r = new Random();
        StringBuilder  nv = new StringBuilder (charLength);
        for (int x = 0; x < length; x++) {
            int i = (int) (Math.random() * charLength);
            nv.append(chars.charAt(i));
        }
        return nv.toString();
    }
}
