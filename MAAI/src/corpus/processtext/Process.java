package corpus.processtext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * TraitementS TEXT
 */
public class Process {

    public static List<String> cleanText(String text, List<String> stopWords){
        Stream<String> stream= text.lines();
        List<String> words = stream.map(w -> w.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        int i=0;
        while (i<words.size()){
            int j=0;
            while (j<stopWords.size()){
                if(words.get(i).equals(stopWords.get(j))){
                    words.remove(i);
                }
                j++;
            }
            i++;
        }
        return words;
    }

    public static void createHachTable(List<String> list ){
        // demonstration of filter method
        try(Stream<String> stream= list.stream()){
            Map<String, Long> wordCount = stream.collect(groupingBy(identity(), counting()));
            System.out.println(wordCount.toString());
        }
    }

}
