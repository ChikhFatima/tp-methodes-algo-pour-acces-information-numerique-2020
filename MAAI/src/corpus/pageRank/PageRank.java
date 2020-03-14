package corpus.pageRank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import corpus.model.MatCLI;

public class PageRank {

	private MatCLI mat;

	// Trier l'index selon le page rank 
	// faire l'intersection entre deux liste 
	
	
	public List<Float> produitMatVecteur(MatCLI matrice, List<Float> v) {
		List<Float> p = new ArrayList<Float>(matrice.getNombreSommet());
		for (int i = 0; i < matrice.getNombreSommet(); i++) {
			p.add((float) 0);
		}

		for (int i = 0; i < matrice.getNombreSommet(); i++) {
			int index = matrice.getL().get(i);
			int nextIndex = matrice.getL().get(i + 1);
			
			for (int t = index; t < nextIndex; t++) {
				p.set(matrice.getI().get(t), p.get(matrice.getI().get(t)) + matrice.getC().get(t) * v.get(i));
			}
		}
		return p;
	}
	
	// Condition d'arret ->  sigma < e AND e = 0.0001 

	public List<Float> pageRaneZero(MatCLI matrice, List<Float> v, float e) {
		List<Float> pFirst = v;
		List<Float> pNext = null;
		float sigma = 0;
		for (int k = 0; k < 30; k++) {
			pNext = produitMatVecteur(matrice, pFirst);
			sigma = distanceVecteur(pNext, pFirst);
			System.out.println("sigma =  " + sigma);
			pFirst = cloneVecteur(pNext);
			displayVecteur(pNext);
			System.out.println("------------------------------------\n\n");
		}
		return pNext;
	}

	public List<Float> pageRaneZap(MatCLI matrice, List<Float> v, float e, float d) {

		// P = (1 − d) × T × P + d × I
		// I: vector with entries = 1/n
		// Usually 0.1 ≤ d ≤ 0.2.

		List<Float> pFirst = v;
		List<Float> pNext = null;
		float sigma = 0;
		for (int k = 0; k < 10000; k++) {
			pNext = produitMatVecteur(matrice, pFirst);
			// need to be optimazed later
			for (int j = 0; j < pNext.size(); j++) {
				pNext.set(j, (1 - d) * pNext.get(j) + d / matrice.getNombreSommet());
			}
			sigma = distanceVecteur(pNext, pFirst)/matrice.getNombreSommet();
			System.out.println("sigma =  " + sigma);
			pFirst = cloneVecteur(pNext);
			displayVecteur(pNext);
			System.out.println("------------------------------------\n\n");
		}

		return pNext;
	}

	private float distanceVecteur(List<Float> v1, List<Float> v2) {
		float res = 0;
		for (int i = 0; i < v1.size(); i++) {
			float temp = v1.get(i) - v2.get(i) ; 
			res += Math.abs(temp);
		}
		return res;
	}

	private List<Float> cloneVecteur(List<Float> v) {
		List<Float> temp = new ArrayList<Float>(v.size());
		for (int i = 0; i < v.size(); i++) {
			temp.add(v.get(i));
		}
		return temp;
	}

	public void displayVecteur(List<Float> p) {
		p.stream().forEach(x -> System.out.println(x));
	}
	
	
	public List<Integer> trierSelonPageRank(List<Integer> list) {
		List<Integer> result = new ArrayList<>(list.size());  
		
		// Trier list selon l'ordre trouvé par le page rank 
		// pageRank de result[0] > pageRank de result[1].... >pageRank de result[n] 
		
		
		return result ;
	}

	public static void main(String[] args) {
		PageRank pageRank = new PageRank();
		MatCLI mat = new MatCLI();
		mat.setNombreSommet(5);
		mat.loadExampleAvecGroupe();
		
		List<Float> v = new ArrayList<Float>(mat.getNombreSommet());
		
		for (int i = 0; i < mat.getNombreSommet(); i++) {
			v.add((float) 1 / mat.getNombreSommet());
		}

		List<Float> z = new ArrayList<Float>(mat.getNombreSommet());
		z.add((float) 1);
		for (int i = 1; i < mat.getNombreSommet(); i++) {
			z.add((float) 0);
		}
		
		// List<Float> result = pageRank.produitMatVecteur(mat, v) ;
		List<Float> result = pageRank.pageRaneZap(mat, z, (float) 0.3,(float)0.2);
		//List<Float> result = pageRank.pageRaneZero(mat, v, (float) 0.3);
		
		// pageRank.displayVecteur(result);

	}
	
	public List<Integer> intersect(List<Integer> l1 , List<Integer>l2) {
		List<Integer> res = l1.stream().filter(l2::contains).collect(Collectors.toList()) ;
		return res ;
	}


}
