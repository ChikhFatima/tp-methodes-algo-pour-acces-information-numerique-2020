package corpus.run;

import corpus.factory.CorpusFactory;
import corpus.model.Index;
import corpus.model.MatrixCLI;
import corpus.model.MyFile;
import corpus.model.Page;
import corpus.processtext.ProcessText;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCLI {
    public static final String PATHNAME = "ressources/";
    public static final String FILENAME_NEWCORPUS= "frwiki-corpus-2.xml";
    public static CorpusFactory factory;
    public static MatrixCLI cli;
    public static Index index;
    public static int KEYNOTFOUND=-1;

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        factory=new CorpusFactory();
        MyFile corpus = factory.instanceOfCorpus(PATHNAME.concat(FILENAME_NEWCORPUS));
        List<Page> pages = corpus.getPages();
        //index
        index=corpus.getIndex();
        //Matrice CLI
        cli=new MatrixCLI();
        ArrayList<String> urls;

        int i=0;
        while (i<pages.size()){
            urls=ProcessText.getURLS(pages.get(i).getText());
           // System.out.println(Arrays.toString(urls.toArray()));
            ArrayList<Integer> I=buildArrayI(urls);
            if(I.size()>0){
                cli.buildCIL(I);
            }
            i++;
          //  System.out.println("PAGE "+i);
         /*   cli.printI();
            cli.printL();
            cli.printC();


          */

        }
        cli.printCLI();

    }

    public static ArrayList<Integer> buildArrayI(ArrayList<String> urls){
        ArrayList<Integer> urlToAdd=new ArrayList<>();
        int i=0;
        while (i<urls.size()){
            int key=index.getKey(urls.get(i));
            if(key>KEYNOTFOUND){
                urlToAdd.add(key);
            }
            i++;
        }
        return urlToAdd;
    }



}
