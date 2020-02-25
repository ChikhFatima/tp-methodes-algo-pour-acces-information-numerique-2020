package corpus.run;

import corpus.factory.CorpusFactory;
import corpus.model.MyFile;
import corpus.model.Page;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
           /* MyFile source = new MyFile(PATHNAME.concat(FILENAME));
            List<Page> pages = source.getPages();
            List<Page> selectedpages = new ArrayList<>();
            System.out.println("SIZE :"+ pages.size());
            int i=0;
            while (i<pages.size()) { ;
                    if(pages.get(i).wordFrequency(CONTENT)>0){
                        selectedpages.add(pages.get(i));
                    }
                    i++;
            }
            MyFile corpus=new MyFile(PATHNAME.concat(FILE_CORPUS),ROOT_CORPUS,selectedpages);
            corpus.write();

            */



        }
}
