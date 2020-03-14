package corpus.model;

import java.util.ArrayList;
import java.util.List;

public class MatCLI {

	private int nombreSommet = 0;

	private List<Float> c;
	private List<Integer> i;
	private List<Integer> l;

	public void load(List<Float> c, List<Integer> k, List<Integer> l) {
		this.c = c;
		this.i = k;
		this.l = l;
	}

	public void loadExample() {
		// TP 2 figure 2

		c.add(((float) 1 / 2));
		c.add(((float) 1 / 2));
		c.add(((float) 1));
		c.add(((float) 1));
		c.add(((float) 1 / 3));
		c.add(((float) 1 / 3));
		c.add(((float) 1 / 3));

		i.add(1);
		i.add(3);
		i.add(2);
		i.add(3);
		i.add(0);
		i.add(1);
		i.add(2);

		l.add(0);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(7);

	}
	
	public void loadExampleCours() {
		c.add(((float) 1 / 2));
		c.add(((float) 1 / 2));
		c.add(((float) 1 / 2));
		c.add(((float) 1 / 2));
		c.add(((float) 1));		
				
		i.add(0);
		i.add(1);
		i.add(0);
		i.add(2);
		i.add(1);
		
		l.add(0);
		l.add(2);
		l.add(4);
		l.add(5);
		
	}

	public void loadExampleAvecPuis() {
		
		c.add(((float) 1 / 3));
		c.add(((float) 1 / 3));
		c.add(((float) 1 / 3));
		c.add(((float) 1 / 2));
		c.add(((float) 1 / 2));
		c.add(((float) 1));		
				
		i.add(1);
		i.add(2);
		i.add(3);
		i.add(0);
		i.add(2);
		i.add(1);
		
		l.add(0);
		l.add(3);
		l.add(5);
		l.add(5);
		l.add(6);
		
	}
	
	public void loadExampleAvecGroupe() {
		
		c.add(((float) 1 / 3));
		c.add(((float) 1 / 3));
		c.add(((float) 1 / 3));
		c.add(((float) 1 / 2));
		c.add(((float) 1 / 2));
		c.add(((float) 1 / 2));
		c.add(((float) 1 / 2));
		c.add(((float) 1));		
		c.add(((float) 1));		

		i.add(1);
		i.add(2);
		i.add(3);
		i.add(0);
		i.add(2);
		i.add(0);
		i.add(4);
		i.add(4);
		i.add(3);
		
		l.add(0);
		l.add(3);
		l.add(5);
		l.add(7);
		l.add(8);
		l.add(9);
		
	}
	
	
	public List<Float> produitMatVecteur() {
		List<Float> p = new ArrayList<Float>(nombreSommet);
		List<Float> v = new ArrayList<Float>(nombreSommet);
		// init vector v
		for (int i = 0; i < nombreSommet; i++) {
			v.add((float) 1 / nombreSommet);
			p.add((float) 0);
		}

		for (int i = 0; i < nombreSommet; i++) {
			int index = l.get(i);
			int nextIndex = l.get(i + 1);

			for (int t = index; t < nextIndex; t++) {
				p.set(this.i.get(t), p.get(this.i.get(t)) + c.get(t) * v.get(i));
			}
		}
		return p;
	}
	
	
	
	private float distanceVecteur(List<Float> v1 , List<Float> v2) {
		float res = 0  ;
		for(int i = 0 ; i < v1.size() ; i++) {
			res += v1.get(i)-v2.get(i) ; 
		}
		return res ; 
	}

	public void displayP(List<Float> p) {
		p.stream().forEach(x -> System.out.println(x));
	}

	public static void main(String[] args) {

		MatCLI mat = new MatCLI();
		mat.setNombreSommet(4);
		mat.loadExample();
		List<Float> result = mat.produitMatVecteur();
		mat.displayP(result);
	}

	public MatCLI() {
		this.c = new ArrayList<Float>();
		this.i = new ArrayList<Integer>();
		this.l = new ArrayList<Integer>();
	}

	public MatCLI(List<Float> c, List<Integer> k, List<Integer> l) {
		this.c = c;
		this.i = k;
		this.l = l;
	}

	public int getNombreSommet() {
		return nombreSommet;
	}

	public void setNombreSommet(int nombreSommet) {
		this.nombreSommet = nombreSommet;
	}

	public List<Float> getC() {
		return c;
	}

	public void setC(List<Float> c) {
		this.c = c;
	}

	public List<Integer> getI() {
		return i;
	}

	public void setI(List<Integer> i) {
		this.i = i;
	}

	public List<Integer> getL() {
		return l;
	}

	public void setL(List<Integer> l) {
		this.l = l;
	}

}
