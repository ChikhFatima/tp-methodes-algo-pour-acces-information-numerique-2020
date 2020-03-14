package corpus.run;

import corpus.factory.CorpusFactory;
import corpus.model.MyFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ShowIndex {
    public static final String PATHNAME = "ressources/";
    public static final String FILENAME_NEWCORPUS= "frwiki-corpus-2.xml";
    public static CorpusFactory factory;
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        factory=new CorpusFactory();
        MyFile corpus = factory.instanceOfCorpus(PATHNAME.concat(FILENAME_NEWCORPUS));
        corpus.getIndex().print();
        //Test
        String title = "abc";
        System.out.println(corpus.getIndex().getKey(title));

        String title2= "Algorithme";
        System.out.println(corpus.getIndex().getKey(title2));
    }
}
