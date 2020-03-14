package corpus.dictonary.clean;

import java.sql.Struct;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Text {
    private List<String> words;
    private String text;
    public static List<String> stopWords = Arrays.asList("a"," l"," s","l","r","s","d","qui","pour","par","sous","est","et","sont","ete","comme","en","entre","alors","jusqu","un","deux","de","du","des","la","le","les","ce","cette","elle","il","dans","plus","leur","quelques","ici","meme","au","aux","eux","ou","encore","ainsi","tout","f","g","qu","memes","on","n","leurs","sont","tres","jpg","p","sur","se","ne","k","voir","homonymes","homonymie"," les");

    public Text(String textToClean) {
        this.text=cleanTextFromExpressions(textToClean);
        this.words=transformStreamToList(textToClean);
        removeStopWords();
    }

    /**
     * Remove Accents From String
     * @param text
     * @return
     */
    private String textWithOutAccents(String text){
        String stringTemp = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(stringTemp).replaceAll("").trim();
    }

    /**
     * Remove Stop Words
     * @param text
     * @return
     */
    private String removeStopWords(String text){
        String afterStopWords = text.replaceAll("(" + stopWords + ")\\s*", "").trim();
        System.out.println(afterStopWords);
        return afterStopWords;
    }

    /**
     * Clean Text From Expressions
     * @param text
     * @return
     */
    private String cleanTextFromExpressions(String text){
        String haveTextWithOutAccents=textWithOutAccents(text);
        return haveTextWithOutAccents
                .toLowerCase()
                .replaceAll("[\\d[^\\w\\s]]+", " ")
                .trim();
    }




    /**
     * Transform Yest to list ofWords
     * @param textToClean
     * @return
     */
    private List<String> transformStreamToList(String textToClean){
        Stream<String> stream= Stream.of(text.toLowerCase().split("\\W+")).parallel();//text.lines();
        List<String> words = stream.map(w -> w.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        return words;
    }


    private void removeStopWords(){
        int i=0;
        while (i<this.words.size()){

            int j=0;
            while (j<stopWords.size()){
               if(words.get(i).equals(stopWords.get(j))){
                    words.remove(i);
                }
                j++;
            }
            i++;
        }

    }




    public List<String> getWords() {
        return words;
    }

    public String getText() {
        return text;
    }


}
