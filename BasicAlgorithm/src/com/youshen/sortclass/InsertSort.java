package com.youshen.sortclass;

import java.util.ArrayList;
import java.util.List;

import com.youshen.interfacetest.PrintTime;
import com.youshen.interfacetest.Sort;
import com.youshen.interfacetest.YouCompare;

import comg.youshen.testclass.SortordStaticWay;
import comg.youshen.youenum.Sortord;

public class InsertSort<T> extends SortordStaticWay<T> implements Sort<T> {

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
		boolean isBaseType=true;
		Class arrrClass = array[0].getClass();
		
		if(arrrClass.equals(String.class)){
			
			new Exception("²»Ö§³ÖStringÅÅÐò").printStackTrace();
		}
		if(super.checkType(arrrClass)){
			isBaseType=true;
		}else {
			isBaseType=false;
		}
		
		for(int i =1;i<array.length;i++){
			T valueT =array[i];
			for(int j=i-1;j>=-1;j--){
				if(j==-1){
					array[j+1]=valueT;
					break;
				}
				if(isBaseType){
					double comp1 = Double.parseDouble(valueT.toString());
					double comp2 = Double.parseDouble(array[j].toString());
					if(Sortord.ASCE==asce){
					if(comp1<comp2){
						array[j+1]=array[j];
					}else {
						array[j+1]=valueT;
						break;
					}
					}else{
						if(comp1>comp2){
							array[j+1]=array[j];
						}else {
							array[j+1]=valueT;
							break;
						}
						
					}
			}else{
				YouCompare comp11 = (YouCompare) valueT;
				YouCompare comp21 = (YouCompare) array[j];
				if(Sortord.ASCE==asce){
					if(comp21.compare(comp11)){
						array[j+1]=array[j];
					}else {
						array[j+1]=valueT;
						break;
					}
					}else{
						if(comp11.compare(comp21)){
							array[j+1]=array[j];
						}else {
							array[j+1]=valueT;
							break;
						}
						
					}
				
			}
			}
			if(printTime!=null){
				printTime.println(array, i);
				}
		}
		return array;
	}

	public void mathswap(T[] array, int b, int c) {
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
