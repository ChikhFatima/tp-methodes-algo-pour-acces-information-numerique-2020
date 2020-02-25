package corpus.model;

import corpus.model.Page;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.List;

public class Index {
    private HashMap<Integer , String> hashMapIdenx;
    private int INDEX=0;
    private String BALISE_TITLE="title";

    public Index(List<Page> pages) {
        hashMapIdenx = new HashMap<>();
        //createIndex(pages);
    }

    public HashMap<Integer, String> getHashMapIdenx() {
        return hashMapIdenx;
    }

    public void createIndex(List<Page> pages){
        int i=0;
        while (i<pages.size()){
            Element page = (Element) pages.get(i);
            hashMapIdenx.put(i,page.getElementsByTagName(BALISE_TITLE).item(INDEX).getTextContent());
            i++;
        }
    }
}
