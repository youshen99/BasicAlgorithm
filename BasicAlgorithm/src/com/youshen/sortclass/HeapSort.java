package com.youshen.sortclass;

import java.util.ArrayList;
import java.util.List;

import com.youshen.interfacetest.PrintTime;
import com.youshen.interfacetest.Sort;
import com.youshen.interfacetest.YouCompare;

import comg.youshen.testclass.SortordStaticWay;
import comg.youshen.youenum.Sortord;

public class HeapSort<T> extends SortordStaticWay<T> implements Sort<T> {

	
	private boolean isBaseType=true;
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
		if(super.checkType(array[0].getClass())){
			isBaseType=true;
		}else {
			isBaseType=false;
		}
		buildMaxHeapify(array,asce);
		heapSort(array,asce);
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
	
	private  void buildMaxHeapify(T[] data,Sortord asce) {
		// 没有子节点的才需要创建最大堆，从最后一个的父节点开始
		int startIndex = getParentIndex(data.length - 1);
		// 从尾端开始创建最大堆，每次都是正确的堆
		for (int i = startIndex; i >= 0; i--) {
			maxHeapify(data, data.length, i,asce);
		}
	}

	/**
	 * 创建堆
	 */
	private  void maxHeapify(T[] data, int heapSize, int index,Sortord asce) {
		// 当前点与左右子节点比较
		int left = getChildLeftIndex(index);
		int right = getChildRightIndex(index);

		int largest = index;
		if(isBaseType){
			if(asce==Sortord.ASCE){
		if (left < heapSize && Double.parseDouble(data[index].toString()) < Double.parseDouble(data[left].toString())) {
			largest = left;
		}
		if (right < heapSize &&  Double.parseDouble(data[largest].toString()) < Double.parseDouble(data[right].toString())) {
			largest = right;
		}
			}else {
				if (left < heapSize && Double.parseDouble(data[index].toString()) > Double.parseDouble(data[left].toString())) {
					largest = left;
				}
				if (right < heapSize &&  Double.parseDouble(data[largest].toString()) > Double.parseDouble(data[right].toString())) {
					largest = right;
				}
			}
		}else {
			if(asce==Sortord.ASCE){
			
			if (left < heapSize && ((YouCompare)data[left]).compare((YouCompare)data[index])) {
				largest = left;
			}
			if (right < heapSize &&   ((YouCompare)data[right]).compare((YouCompare)data[largest])) {
				largest = right;
			}
			
			}else{
				
				if (left < heapSize && ((YouCompare)data[index]).compare((YouCompare)data[left])) {
					largest = left;
				}
				if (right < heapSize &&   ((YouCompare)data[largest]).compare((YouCompare)data[right])) {
					largest = right;
				}
			}
		}
		// 得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整
		if (largest != index) {
			T temp = data[index];
			data[index] = data[largest];
			data[largest] = temp;
			maxHeapify(data, heapSize, largest,asce);
		}
	}

	/**
	 * 排序，最大值放在末尾，data虽然是最大堆，在排序后就成了递增的
	 */
	private  void heapSort(T[] data,Sortord asce) {
		// 末尾与头交换，交换后调整最大堆
		for (int i = data.length - 1; i > 0; i--) {
			T temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			maxHeapify(data, i, 0,asce);
		}
	}

	
	private static int getParentIndex(int current) {
		return (current - 1) >> 1;
	}

	
	private  int getChildLeftIndex(int current) {
		return (current << 1) + 1;
	}

	/**
	 * 右子节点position
	 * 
	 * @paramcurrent
	 * @return
	 */
	private  int getChildRightIndex(int current) {
		return (current << 1) + 2;
	}



}
