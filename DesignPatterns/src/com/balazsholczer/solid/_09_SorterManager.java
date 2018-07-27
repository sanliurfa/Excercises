package com.balazsholczer.solid;

public class _09_SorterManager {
	
	public void sort(_09_Sorter sorter) {
		if (sorter.type == _09_SortType.INSERTIONSORT) {
			doInsertionSort(sorter);
		} else if (sorter.type == _09_SortType.MERGESORT) {
			doMergeSort(sorter);
		}
	}

	private void doMergeSort(_09_Sorter sorter) {
		sorter.sort();
	   
		
	}

	private void doInsertionSort(_09_Sorter sorter) {
		sorter.sort();
		
	}


}
