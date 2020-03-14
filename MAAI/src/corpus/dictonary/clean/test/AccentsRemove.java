package corpus.dictonary.clean.test;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class AccentsRemove
    {

        public static String sansAccent(String s)
        {

            String strTemp = Normalizer.normalize(s, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(strTemp).replaceAll("");
        }

        public static void main(String arg[]) {
            // Chaîne avec accent
            String test="Marché public, école, j'ai programmé, chaîne de caractère";

            // Effacer les accents de la chaîne de caractère 'test'
            String str_sans_accent=sansAccent(test);

            //Afficher le résultat
            System.out.println(str_sans_accent);

        }
}

