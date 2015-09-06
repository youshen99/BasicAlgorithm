package com.youshen.sortclass;

import java.util.ArrayList;
import java.util.List;

import com.youshen.interfacetest.PrintTime;
import com.youshen.interfacetest.Sort;
import com.youshen.interfacetest.YouCompare;

import comg.youshen.testclass.SortordStaticWay;
import comg.youshen.youenum.Sortord;

public class SelectSort<T>  extends SortordStaticWay<T> implements Sort<T> {

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
		for (int i = 0; i < array.length; i++) {
            
			int indexMinOrMax=findMinOrMaxMathIndex(array,asce,i,isBaseType);
			if(i!=indexMinOrMax){
				 mathswap(array, i, indexMinOrMax);
			}
           

			if(printTime!=null){
			printTime.println(array, i + 1);
			}
			}
		return array;
	}

	private int findMinOrMaxMathIndex(T[] array, Sortord asce, int start,
			boolean isBaseType) {
		int index=start;
		T value=array[start];
		for(int i=start+1;i<array.length;i++){
			if(asce==Sortord.ASCE){//ÉýÐò
				if(isBaseType){
					double comp1 = Double.parseDouble(array[i].toString());
					double comp2 = Double.parseDouble(value.toString());
				if(comp1<comp2){
					value=array[i];
					index=i;
					
				}
				}else{
					
					YouCompare comp11 = (YouCompare) array[i];
					YouCompare comp21 = (YouCompare) value;
					if(comp21.compare(comp11)){
						value=array[i];
						index=i;
					}
				}
				
			}else{//½µÐò
				if(isBaseType){
					double comp1 = Double.parseDouble(array[i].toString());
					double comp2 = Double.parseDouble(value.toString());
				if(comp1>comp2){
					value=array[i];
					index=i;
					
				}
				}else{
					
					YouCompare comp11 = (YouCompare) array[i];
					YouCompare comp21 = (YouCompare) value;
					if(comp11.compare(comp21)){
						value=array[i];
						index=i;
					}
				}
				
			}
		}
		return index;
	}

	public  void mathswap(T[] array, int b, int c) {
		try {
			super.swap(array, b, c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<T> sort(List<T> arrayList, Sortord asce) {
		// TODO Auto-generated method stub
		return this.sort(arrayList,asce,null);
	}

	public T[] sort(T[] array, Sortord asce) {
		// TODO Auto-generated method stub
		return this.sort(array, asce, null);
	}

}
