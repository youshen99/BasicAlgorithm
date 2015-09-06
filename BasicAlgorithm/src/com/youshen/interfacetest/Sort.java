package com.youshen.interfacetest;

import java.util.ArrayList;
import java.util.List;

import comg.youshen.youenum.Sortord;

public interface Sort<T>{
	
     List<T> sort(List<T> arrayList, Sortord asce,PrintTime printTime);
     T[] sort(T[] array, Sortord asce,PrintTime printTime);
     List<T> sort(List<T> arrayList, Sortord asce);
     T[] sort(T[] array, Sortord asce);
     
}
