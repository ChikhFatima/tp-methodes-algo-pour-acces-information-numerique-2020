package corpus.model;

import java.util.Arrays;
import java.util.Hashtable;

public class CorpusDictionary {
    private Hashtable<String, Integer> hashTable;

    public CorpusDictionary() {
        this.hashTable = new Hashtable();
    }

    public void setHashTable(Hashtable<String, Integer> hashTable) {
        this.hashTable = hashTable;
    }

    public void addWord(String newWord, Integer frequency){
        this.hashTable.put(newWord,frequency);
    }

    public void removeWord(String word){
        this.hashTable.remove(word);
    }


    public void show(){
        //System.out.println(Arrays.toString());
    }
}
