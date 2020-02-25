package corpus.model;

import org.w3c.dom.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Page  {

    private Element node;
    private NamedNodeMap attributes;
    private String title;
    private String BALISE_TITLE="title";
    private String BALISE_TEXT="text";

    private int INDEX=0;

    public Page(Element node){
        this.node=node;
        this.title=node.getElementsByTagName(BALISE_TITLE).item(INDEX).getTextContent();
    }

    public Element getNode() {
        return node;
    }

    public String getTitle() {
        return title;
    }

    public String getText(){
        return node.getElementsByTagName(BALISE_TEXT).item(INDEX).getTextContent();
    }

    public void showAttributs(){
        System.out.println("Title :"+title+"\n" +
                           "Text :" + getText());

    }


    public int wordFrequency(String word){
        int frequency=0;
        Pattern pattern = Pattern.compile(word);
        String text=getText();
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            frequency++;
        }
        return frequency;
    }

}
