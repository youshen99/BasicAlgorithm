package com.youshen.sortclass;

import java.util.ArrayList;
import java.util.List;

import com.youshen.interfacetest.PrintTime;
import com.youshen.interfacetest.Sort;
import com.youshen.interfacetest.YouCompare;

import comg.youshen.testclass.SortordStaticWay;
import comg.youshen.youenum.Sortord;

public class TwoWayMergeSort<T> extends SortordStaticWay<T> implements Sort<T> {

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
		mergeSort(array, 0, 1,asce,printTime);
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

	private  void merge(T[] a, int s, int m, int t,Sortord asce) {
		
		Object[] tmp = new Object[t - s + 1];
		
		int i = s, j = m, k = 0;
		
		while (i < m && j <= t) {
			if(isBaseType){
				if(Sortord.ASCE==asce){
			if (Double.parseDouble(a[i].toString()) <= Double.parseDouble((a[j].toString()))) {
				tmp[k] = a[i];
				k++;
				i++;
			} else {
				tmp[k] = a[j];
				j++;
				k++;
			}}else{
				
				if (Double.parseDouble(a[i].toString()) > Double.parseDouble((a[j].toString()))) {
					tmp[k] = a[i];
					k++;
					i++;
				} else {
					tmp[k] = a[j];
					j++;
					k++;
				}	
			}
			}else {
				if(Sortord.ASCE==asce){
				if (((YouCompare)a[j]).compare((YouCompare)a[i])) {
					tmp[k] = a[i];
					k++;
					i++;
				} else {
					tmp[k] = a[j];
					j++;
					k++;
				}}else{
					if (((YouCompare)a[i]).compare((YouCompare)a[j])) {
						tmp[k] = a[i];
						k++;
						i++;
					} else {
						tmp[k] = a[j];
						j++;
						k++;
					}	
				}
			}
		}
		while (i < m) {
			tmp[k] = a[i];
			i++;
			k++;
		}

		while (j <= t) {
			tmp[k] = a[j];
			j++;
			k++;
		}
		System.arraycopy(tmp, 0, a, s, tmp.length);
	}


	private boolean isBaseType=true;
	private int time=1;
	public  void mergeSort(T[] a, int s, int len,Sortord asce,PrintTime printTime) {
		//判断是否是基本数据类型
		if(super.checkType(a[0].getClass())){
			isBaseType=true;
		}else{
			isBaseType=false;
		}
		int size = a.length;
		int mid = size / (len << 1);
		int c = size & ((len << 1) - 1);
		//归并到只剩一个有序集合的时候结束算法
		if (mid == 0)
			return;
		//进行一趟归并排序
		for (int i = 0; i < mid; ++i) {
			s = i * 2 * len;
			merge(a, s, s + len, (len << 1) + s - 1,asce);
		}
		//将剩下的数和倒数一个有序集合归并
		if (c != 0){
			merge(a, size - c - 2 * len, size - c, size - 1,asce);
		}
		//递归执行下一趟归并排序
		printTime.println(a, time++);
		mergeSort(a, 0, 2 * len,asce,printTime);
	}



}
