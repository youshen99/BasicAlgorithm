package com.youshen.sortclass;

import java.util.ArrayList;
import java.util.List;

import com.youshen.interfacetest.PrintTime;
import com.youshen.interfacetest.Sort;
import com.youshen.interfacetest.YouCompare;

import comg.youshen.testclass.SortordStaticWay;
import comg.youshen.youenum.Sortord;

public class BubblSort<T> extends SortordStaticWay<T> implements Sort<T> {

	public List<T> sort(List<T> arrayList, Sortord asce,
			PrintTime printTime) {
		if (arrayList == null) {
             return null;
		}
		T[] array = (T[]) arrayList.toArray();
		T[] newArray = sort(array, asce, printTime);
		List<T> arrayListNew = new ArrayList<T>();
		for (int i = 0; i < array.length; i++) {

			arrayListNew.add(newArray[i]);
		}
		return arrayListNew;
	}

	public T[] sort(T[] array, Sortord asce, PrintTime printTime) {
		Class arrrClass = array[0].getClass();
		if(arrrClass.equals(String.class)){
			
			new Exception("²»Ö§³ÖStringÅÅÐò").printStackTrace();
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {

				if (super.checkType(array[j].getClass())) {
					double comp1 = Double.parseDouble(array[j - 1].toString());
					double comp2 = Double.parseDouble(array[j].toString());
					if (comp1>comp2) {
						if (asce == Sortord.ASCE) {
							mathswap(array, j - 1, j);
						}
					} else {
						if (asce == Sortord.DESC) {
							mathswap(array, j - 1, j);
						}
					}
				} else {

					YouCompare comp1 = (YouCompare) array[j - 1];
					YouCompare comp2 = (YouCompare) array[j];

					if (comp1.compare(comp2)) {
						if (asce == Sortord.ASCE) {
							mathswap(array, j - 1, j);
						}
					} else {
						if (asce == Sortord.DESC) {
							mathswap(array, j - 1, j);

						}
					}
				}
			}

			if(printTime!=null){
			printTime.println(array, i + 1);
			}
			}
		return array;
	}

	private void mathswap(T[] array, int b, int c) {

		try {
			super.swap(array, b, c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<T> sort(List<T> arrayList, Sortord asce) {
		// TODO Auto-generated method stub
		return this.sort(arrayList, asce, null);
	}

	public T[] sort(T[] array, Sortord asce) {
		// TODO Auto-generated method stub
		return this.sort(array, asce, null);
	}
}
