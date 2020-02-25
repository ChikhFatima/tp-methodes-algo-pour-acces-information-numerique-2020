package corpus.model;

import java.util.ArrayList;
import java.util.List;

public class MatCLI {
	
	private List<Integer> c ; 
	private List<Integer> k ; 
	private List<Integer> l ; 
	
	public void load() {
		
	}
	
	
	public void transposerMat() {
		
	}
	
	public MatCLI() {
		this.c = new ArrayList<Integer>() ;
		this.k = new ArrayList<Integer>(); 
		this.l = new ArrayList<Integer>() ;
	}

	public MatCLI(List<Integer> c, List<Integer> k, List<Integer> l) {
		this.c = c;
		this.k = k;
		this.l = l;
	}


	public List<Integer> getC() {
		return c;
	}


	public void setC(List<Integer> c) {
		this.c = c;
	}


	public List<Integer> getK() {
		return k;
	}


	public void setK(List<Integer> k) {
		this.k = k;
	}


	public List<Integer> getL() {
		return l;
	}


	public void setL(List<Integer> l) {
		this.l = l;
	}
	
	
	
	
}
