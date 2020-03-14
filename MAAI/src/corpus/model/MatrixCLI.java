package corpus.model;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixCLI {
    private ArrayList<Integer> I;
    private ArrayList<Integer> L;
    private ArrayList<Float> C;
    private int currentL;



    public MatrixCLI() {
        I = new ArrayList<>();
        L = new ArrayList<>();
        C = new ArrayList<>();
        currentL=0;
        addL(currentL);
    }

    public void addI(int i){
        I.add(i);
    }

    public void buildCIL(ArrayList<Integer> newI){
        int nodes=newI.size();
        float newC;
        int i=0;
        while (i<newI.size()){
            this.I.add(newI.get(i));
            newC=(float)1/nodes;
            this.C.add(newC);

            i++;
        }
        currentL=currentL+nodes;
        addL(currentL);
    }
    public void addL(int l){
        L.add(l);
    }

    public  void addC(float c){
        C.add(c);
    }

    public ArrayList<Integer> getI() {
        return I;
    }

    public ArrayList<Integer> getL() {
        return L;
    }

    public ArrayList<Float> getC() {
        return C;
    }

    public void printI(){
       System.out.println( Arrays.toString(I.toArray()));
    }

    public void printL(){
       System.out.println( Arrays.toString(L.toArray()));
    }

    public void printC(){
        System.out.println(Arrays.toString(C.toArray()));
    }

    public void printCLI(){
        System.out.println( "C  : "+ Arrays.toString(C.toArray()));
        System.out.println( "L  : "+ Arrays.toString(L.toArray()));
        System.out.println( "I  : "+ Arrays.toString(I.toArray()));
    }
}
