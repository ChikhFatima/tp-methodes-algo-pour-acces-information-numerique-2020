package corpus.processtext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * TraitementS TEXT
 */
public class ProcessText {
    private String DETERMIN_SPLIT="|";


    public static void words(String text){
        Stream<String> stream = Stream.of(text.toLowerCase().split("\\W+")).parallel();
        Map<String, Long> wordFreq = stream
                .collect(Collectors.groupingBy(String::toString,Collectors.counting()));
        wordFreq.forEach((k,v)->System.out.println(k + "=" + v));
    }

    public static List<String> cleanText(String text, List<String> stopWords, List<String> term){
        Stream<String> stream= Stream.of(text.toLowerCase().split("\\W+")).parallel();//text.lines();
        List<String> words = stream.map(w -> w.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println();
        List<String> cleanWords= new ArrayList<>();
        int i=0;
        while (i<words.size()){
            int j=0;
            while (j<stopWords.size()){
               /* if(!words.get(i).equals(stopWords.get(j))){
                    words.remove(i);
                }else{
                    String newWord=processWord(words.get(i),term);
                    cleanWords.add(newWord);
                }

                */
                j++;
            }
            i++;
        }
        return cleanWords;
    }

    public static void createHachTable(List<String> list ){
        // demonstration of filter method
        try(Stream<String> stream= list.stream()){
            Map<String, Long> wordCount = stream.collect(groupingBy(identity(), counting()));
            System.out.println(wordCount.toString());
        }
    }

    /**
     * Remove specialCaracters from String
     * @param word
     * @return
     */
    public static String removeSpecialCharacters(String word){

        String newWord = word
                .toLowerCase()
                .replaceAll("[\\d[^\\w\\s]]+", "")
                .trim();
        return newWord;
    }

    /**
     * Remove terminaison
     * @param word
     * @return
     */
    public static String removeTerminaison(String word,List<String> term){
        word=word.replaceFirst("er","");
        word=word.replace("ir","");
        word=word.replace("s","");
        word=word.replace("z","");
        word=word.replace("x","");
        word=word.replace("ez","");
        word=word.replace("ons","");
        word=word.replaceAll("y","");
        word=word.replaceAll("re","");
        return word;
    }

    /**
     * Process Word for dictionnary
     * @param word
     * @return
     */

    /**
     * CLean Word
     * @param word
     * @param term
     * @return
     */

    public static String processWord(String word, List<String> term){
        String newWord=removeSpecialCharacters(word);
        return removeTerminaison(newWord,term);
    }

    /**
     * Find URL IN THE TEXT : Get Array I of page
     * @param text
     * @return
     */
    public static ArrayList<String> getURLS(String text){
        ArrayList<String> urls = new ArrayList<>();
        Pattern p = Pattern.compile("\\[\\[.*?\\]\\]");
        Matcher matcher = p.matcher(text);
        while(matcher.find()) {
            CharSequence sq=(matcher.group().subSequence(2, matcher.group().length()-2));
            String newUrl= String.valueOf(sq);
            String[] subURL=newUrl.split("[|#():]+");
            int i=0;
            while (i<subURL.length){
                if(!ifUrlExist(urls,subURL[i])){
                    urls.add(subURL[i]);
                }
                i++;
            }
        }

        return urls;
    }

    public static boolean ifUrlExist(ArrayList<String> listOfURLS, String newUrl){
        boolean exist=false;
        int i=0;
        while (i<listOfURLS.size()){
            if(listOfURLS.get(i).equals(newUrl)){
                exist = true;
                break;
            }
            i++;
        }
        return  exist;
    }

}
