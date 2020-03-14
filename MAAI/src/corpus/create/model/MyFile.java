package corpus.create.model;

import corpus.model.Index;
import corpus.model.Page;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFile {
    private String pathname;
    private Document document;
    private String BALISE_TITLE="title";
    private String BALISE_TEXT="text";
    private String BALISE_PAGE="page";
    private Index index;
    private List<Page> pages;

    /**
     * Get document XML
     * @param pathname
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public MyFile(String pathname) throws IOException, SAXException, ParserConfigurationException {
        this.pathname=pathname;
        createDocument();
        this.pages=getListOfPages();
        index = new Index(pages);
    }

    /**
     * Create new document XML
     * @param pathname
     * @param root
     * @param pages
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public MyFile(String pathname, String root, List<Page> pages) throws IOException, SAXException, ParserConfigurationException {
        this.pathname=pathname;
        this.pages=pages;
        createNewDocument();
        addElement(root);
        index = new Index(pages);
    }

    /**
     * Get Document XML of pathname
     */
    private void createDocument()  {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            this.document=builder.parse(new File(pathname));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Create new Document XML
     */
    private void createNewDocument()  {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            this.document=builder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    public List<Page> getListOfPages(){
        NodeList children= document.getDocumentElement().getChildNodes();
        List<Page> pages= new ArrayList<>();
        int i=0;
        while (i<children.getLength()){
            //System.out.println("Node["+i+"] = "+racineNods.item(i).getNodeName());
            //E6 : Recuperation Que des noeuds qui sont des Elements
            if(children.item(i).getNodeType()== Node.ELEMENT_NODE){
                Element newPage=(Element) children.item(i);
                pages.add(new Page(newPage));
            }
            i++;
        }
        return  pages;
    }



    /**
     * List of pages
     * @List<Page> pages
     */
    public List<Page> getPages(){
        NodeList children= document.getDocumentElement().getChildNodes();
        List<Page> pages= new ArrayList<>();
        int i=0;
        while (i<children.getLength()){
            //System.out.println("Node["+i+"] = "+racineNods.item(i).getNodeName());
            //E6 : Recuperation Que des noeuds qui sont des Elements
            if(children.item(i).getNodeType()== Node.ELEMENT_NODE){
                Element newPage=(Element) children.item(i);
                Element newElementPage=document.createElement(BALISE_PAGE);
                Element newElementTitle=document.createElement(BALISE_TITLE);
                Element newElementText=document.createElement(BALISE_TEXT);
                newElementPage.appendChild(newElementTitle);
                newElementTitle.appendChild(document.createTextNode(newPage.getElementsByTagName(BALISE_TITLE).item(0).getTextContent()));
                newElementPage.appendChild(newElementText);
                newElementText.appendChild(document.createTextNode(newPage.getElementsByTagName(BALISE_TEXT).item(0).getTextContent()));
                pages.add(new Page(newElementPage));
            }
            i++;
        }
        return  pages;
    }

    public Document getDocument() {
        return document;
    }

    /**
     * Add element to root
     *
     * @param tagName
     */
    public void addElement(String tagName){
        Element rootElement = document.createElement(tagName);
        document.appendChild(rootElement);
    }

    public void copyAllNodes(List<Page> children){
        // System.out.println("children size :"+children.size());
        int i=0;
        while (i<children.size()){
            Node copyNode = document.importNode(children.get(i).getNode(),true);
            document.getDocumentElement().appendChild(copyNode);
            i++;
        }
    }

    /**
     * Write document to directory ressources
     *
     */
    public void write(){
        copyAllNodes(pages);
        try {
            TransformerFactory transformerFactory = TransformerFactory.newDefaultInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(this.pathname));
            transformer.transform(source,streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }


    public Index getIndex() {
        return index;
    }
}

