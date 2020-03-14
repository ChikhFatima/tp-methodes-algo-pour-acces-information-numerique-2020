package corpus.pageRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class RankOfPage implements Comparable<RankOfPage> {

	int page;
	float rank;
	String titre;

	public RankOfPage(int page, float rank, String titre) {
		this.page = page;
		this.rank = rank;
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "RankOfPage [page=" + page + ", rank=" + rank + ", titre=" + titre + "]";
	}

	@Override
	public int compareTo(RankOfPage o) {
		if (rank - o.rank > 0)
			return -1;
		else
			return 1;
	}

}

public class TestMergeSort {

//	
//	
//	public void mergeSort (List<RankOfPage> array,int lowIndex, int highIndex) {
//		if (lowIndex == highIndex)
//			return;
//		else {
//			int midIndex = (lowIndex + highIndex) / 2;
//			mergeSort(array, lowIndex, midIndex);
//			mergeSort(array, midIndex + 1, highIndex);
//			merge(array, lowIndex, midIndex, highIndex);
//		} 
//	}
//	
//	public void merge(List<RankOfPage> array ,int lowIndex, int midIndex, int highIndex) {
//		RankOfPage[] L = new RankOfPage[midIndex - lowIndex + 2];
//		
//		for (int i = lowIndex; i <= midIndex; i++) {
//			L[i - lowIndex] = array.get(i);
//		}
//		L[midIndex - lowIndex + 1] = new RankOfPage(Integer.MAX_VALUE, Float.MAX_VALUE);
//		RankOfPage[] R = new RankOfPage[highIndex - midIndex + 1];
//		
//		for (int i = midIndex + 1; i <= highIndex; i++) {
//			R[i - midIndex - 1] = array.get(i);
//		}
//		
//		R[highIndex - midIndex] = new RankOfPage(Integer.MAX_VALUE, Float.MAX_VALUE);
//		
//		int i = 0, j = 0;
//		
//		for (int k = lowIndex; k <= highIndex; k++) {
//			
//			// pageRank.get(i) <= pageRank.get(j)
//			if (L[i].rank <= R[j].rank) {
//				array.set(k, L[i]);
//				i++;
//			}
//			else {
//				array.set(k, R[j]);
//				j++;
//			}
//		} 
//	}
//	
	public static void main(String[] args) {

		TestMergeSort m = new TestMergeSort();
		List<Integer> list = new ArrayList<Integer>();
		List<Float> pageRank = new ArrayList<Float>();
		List<RankOfPage> myList = new ArrayList<RankOfPage>();

		list = Arrays.asList(3, 2, 1, 4, 6, 5);
		pageRank = Arrays.asList((float) 0.33, (float) 0.2, (float) 0.40, (float) 0.10, (float) 0.01, (float) 0.22);

		for (int i = 0; i < list.size(); i++) {
			myList.add(new RankOfPage(list.get(i), pageRank.get(i), "Titre " + i));
		}
		// m.mergeSort(myList, 0, 5);
		for (RankOfPage x : myList) {
			System.out.println(x);
		}

		System.out.println("After Sorting");

		Collections.sort(myList);

		for (RankOfPage x : myList) {
			System.out.println(x);
		}
	}

}
