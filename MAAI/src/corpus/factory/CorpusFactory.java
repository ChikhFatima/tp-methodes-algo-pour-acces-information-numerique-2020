package corpus.factory;

import corpus.model.MyFile;
import corpus.model.Page;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CorpusFactory {
    public MyFile createCorpusFile(String sourceFile, String newFile, String rootBalise, String content ) throws ParserConfigurationException, SAXException, IOException {
        MyFile source = new MyFile(sourceFile);
        List<Page> pages = source.getPages();
        List<Page> selectedpages = new ArrayList<>();
        System.out.println("SIZE :"+ pages.size());
        int i=0;
        while (i<pages.size()) { ;
            if(pages.get(i).wordFrequency(content)>0){
                selectedpages.add(pages.get(i));
            }
            i++;
        }
        MyFile corpus=new MyFile(newFile,rootBalise,selectedpages);
        return corpus;
    }

    public MyFile instanceOfCorpus(String filename) throws ParserConfigurationException, SAXException, IOException {
        return new MyFile(filename);
    }
}
