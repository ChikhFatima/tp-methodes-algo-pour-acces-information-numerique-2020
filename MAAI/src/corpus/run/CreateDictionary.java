package corpus.run;

import corpus.factory.CorpusFactory;
import corpus.model.MyFile;
import corpus.model.Page;
import corpus.processtext.Process;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateDictionary {
    public static final String PATHNAME = "ressources/";
    public static final String FILENAME_NEWCORPUS= "frwiki-corpus-2.xml";
    public static CorpusFactory factory;
    public static List<String> stopWords = Arrays.asList("être","des","et",".",":","=","les","la","le","à","","de","du","avec","*",";");
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        factory=new CorpusFactory();
        MyFile corpus = factory.instanceOfCorpus(PATHNAME.concat(FILENAME_NEWCORPUS));
        List<Page> pages=corpus.getPages();
        int i=0;
        while (i<1){
            System.out.println("TEXT :"+pages.get(i).getText());
            System.out.println("___________________________________________________________________________________________________");
            List<String> listOfWords = Process.cleanText(pages.get(i).getText(),stopWords);
            Process.createHachTable(listOfWords);
            i++;
        }

    }
}
