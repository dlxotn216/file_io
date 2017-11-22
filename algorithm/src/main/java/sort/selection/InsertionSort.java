package sort.selection;

import sort.Data;

public class InsertionSort {

	public static void main(String[] args) {
		//
		sort();
	}

	public static void sort() {
		// 90, 60, 0, 50, 40, 30
		int[] data = Data.createSample();
		print(data);
		System.out.println("-------------------");

		// 여기에 알고리즘을 구현합니다.
	}

	public static void print(int[] data) {
		//
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

}
