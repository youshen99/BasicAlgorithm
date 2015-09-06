package com.youshen.sortclass;

import java.util.ArrayList;
import java.util.List;

import com.youshen.interfacetest.PrintTime;
import com.youshen.interfacetest.Sort;
import com.youshen.interfacetest.YouCompare;

import comg.youshen.testclass.SortordStaticWay;
import comg.youshen.youenum.Sortord;

public class QuickSort<T> extends SortordStaticWay<T> implements Sort<T>{
	private int time=1;
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


	public  void qsort(T arr[], int low, int high,Sortord asce,PrintTime printTime) {
		int l = low;
		int h = high;
		T povit = arr[low];

		while (l < h) {
			if(isBaseType){
				if(Sortord.ASCE == asce){
			while (l < h && Double.parseDouble((arr[h].toString())) >= Double.parseDouble(povit.toString()))
				h--;
			if (l < h) {
				T temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}

			while (l < h && Double.parseDouble(arr[l].toString()) <= Double.parseDouble((povit.toString())))
				l++;
				}else{
					
					while (l < h && Double.parseDouble((arr[h].toString())) <= Double.parseDouble(povit.toString()))
						h--;
					if (l < h) {
						T temp = arr[h];
						arr[h] = arr[l];
						arr[l] = temp;
						l++;
					}

					while (l < h && Double.parseDouble(arr[l].toString()) >= Double.parseDouble((povit.toString())))
						l++;
				}
			}else {
				if(Sortord.ASCE == asce){
				while (l < h && ((YouCompare)arr[h]).compare((YouCompare)povit))
					h--;
				if (l < h) {
					T temp = arr[h];
					arr[h] = arr[l];
					arr[l] = temp;
					l++;
				}

				while (l < h && ((YouCompare)povit).compare((YouCompare)arr[l]))
					l++;
				}else {
					while (l < h && ((YouCompare)povit).compare((YouCompare)arr[h]))
						h--;
					if (l < h) {
						T temp = arr[h];
						arr[h] = arr[l];
						arr[l] = temp;
						l++;
					}

					while (l < h && ((YouCompare)arr[l]).compare((YouCompare)povit))
						l++;
				}
			}
			if (l < h) {
				T temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;
			}
		}
		printTime.println(arr, time++);
		
		if (l > low)
			qsort(arr, low, l - 1,asce,printTime);
		if (h < high)
			qsort(arr, l + 1, high,asce,printTime);
	}
	private boolean isBaseType=true;
	public T[] sort(T[] array, Sortord asce, PrintTime printTime) {
		//判断类型
		Class arrrClass = array[0].getClass();
		if(arrrClass.equals(String.class)){
			
			new Exception("不支持String排序").printStackTrace();
		}
		if(super.checkType(arrrClass)){
			isBaseType=true;
		}else{
			isBaseType=false;
		}
		qsort(array, 0, array.length-1,asce, printTime);
		return array;
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
