package corpus.model;

import org.w3c.dom.Element;

import java.util.*;
import java.util.stream.Stream;

public class Index {
    private HashMap<Integer , String> hashMapIdenx;
    private ArrayList<String> indexTitle;
    private int INDEX=0;
    private String BALISE_TITLE="title";
    private int KEYNOTFOUND=-1;

    public Index(List<Page> pages) {
        hashMapIdenx = new HashMap<>();
        indexTitle = new ArrayList<String>();
        createIndex(pages);
    }

    public HashMap<Integer, String> getHashMapIdenx() {
        return hashMapIdenx;
    }

    public void createIndex(List<Page> pages){
        int i=0;
        while (i<pages.size()){
            String title = pages.get(i).getTitle();
            hashMapIdenx.put(i,title);
            indexTitle.add(title);
            i++;
        }
    }

    public String getValue(int key){
        return hashMapIdenx.get(key);
    }

    public int getKey(String value){
        int key =KEYNOTFOUND;
        int i=0;
        while (i<indexTitle.size()){
            if(indexTitle.get(i).equals(value)){
                key=i;
                break;
            }
            i++;
        }
        return key;
    }

    public void print(){
        hashMapIdenx.forEach((key, value) -> System.out.println(key + "  " + value));

    }
}
