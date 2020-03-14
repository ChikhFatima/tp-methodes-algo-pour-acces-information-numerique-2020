package corpus.run;

import corpus.factory.CorpusFactory;
import corpus.model.MyFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CreateCorpus {
        public static final String PATHNAME = "ressources/";
        public static final String FILENAME_SOURCE = "frwiki-debut.xml";
        public static final String FILENAME_NEWCORPUS= "frwiki-corpus-2.xml";
        public static final String TEXT="text";
        public static final String CONTENT = "mathématique";
        public static String ROOT_NEWCORPUS="frwiki";

        public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
            CorpusFactory factory = new CorpusFactory();
            MyFile newCorpus=factory.createCorpusFile(PATHNAME.concat(FILENAME_SOURCE),PATHNAME.concat(FILENAME_NEWCORPUS),ROOT_NEWCORPUS,CONTENT);
            newCorpus.write();

        }
}
