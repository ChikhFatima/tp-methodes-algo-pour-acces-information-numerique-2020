package corpus.dictonary.clean.test;

import corpus.dictonary.clean.Text;
import corpus.factory.CorpusFactory;
import corpus.model.MyFile;
import corpus.model.Page;
import corpus.processtext.ProcessText;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainTextClean {
    public static CorpusFactory factory;
    public static final String PATHNAME = "ressources/";
    public static final String FILENAME_NEWCORPUS= "frwiki-corpus-2.xml";
    public static List<String> stopWords = Arrays.asList("être","des","et",".",":","=","les","la","le","à"," ","de","du","avec","*",";");
    public static List<String> term = Arrays.asList("a","e","i","r","u","s","z","o","y","t","n");
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {


        factory=new CorpusFactory();
        MyFile corpus = factory.instanceOfCorpus(PATHNAME.concat(FILENAME_NEWCORPUS));
        List<Page> pages=corpus.getPages();
        int i=0;
        while (i<1){
            Text text = new Text(pages.get(i).getText());
            System.out.println(text.getText());
            System.out.println("--------------------------------------------");
            System.out.println(Arrays.deepToString(text.getWords().toArray()));
            i++;
        }
    }
}
