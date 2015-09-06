package com.youshen.sortclass;

import java.util.ArrayList;
import java.util.List;

import com.youshen.interfacetest.PrintTime;
import com.youshen.interfacetest.Sort;
import com.youshen.interfacetest.YouCompare;

import comg.youshen.testclass.SortordStaticWay;
import comg.youshen.youenum.Sortord;

public class ShellSort<T> extends SortordStaticWay<T> implements Sort<T> {

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

	public T[] sort(T[] a, Sortord asce, PrintTime printTime) {
		
		Class arrrClass = a[0].getClass();
		boolean isbaseType=true;
		if(super.checkType(arrrClass)){
			isbaseType = true;
		}else{
			isbaseType=false;
			
		}
		if(arrrClass.equals(String.class)){
			
			new Exception("²»Ö§³ÖStringÅÅÐò").printStackTrace();
		}
	        
	        int d=a.length;
	        int count=1;
	            while(true)
	            {
	            	 d=d/2;
	            	  for(int i=0;i<d;i++){
	                      for(int j=i;j+d<a.length;j+=d){
	                    	  
	                    	  if(!isbaseType){
	                    	
	                      T temp;
	                      if(Sortord.ASCE==asce){
	                    
	                      if(((YouCompare)a[j]).compare((YouCompare)a[j+d])){
	                          temp=a[j];
	                          a[j]=a[j+d];
	                          a[j+d]=temp;
	                          }
	                	  
	                      }else{
	                    	  
	                    	  if(((YouCompare)a[j+d]).compare((YouCompare)a[j])){
		                          temp=a[j];
		                          a[j]=a[j+d];
		                          a[j+d]=temp;
		                          }
	                      }
	                    	  }else{
	                    		  T temp;
	                    		  if(Sortord.ASCE==asce){
	    	                      if(Double.parseDouble(a[j].toString())>Double.parseDouble(a[j+d].toString())){
	    	                          temp=a[j];
	    	                          a[j]=a[j+d];
	    	                          a[j+d]=temp;
	    	                          } 
	                    		  }else {
	                    			  if(Double.parseDouble(a[j].toString())<Double.parseDouble(a[j+d].toString())){
		    	                          temp=a[j];
		    	                          a[j]=a[j+d];
		    	                          a[j+d]=temp;
		    	                          } 
								}
	                    	  }
	                      
	                      
	                      }
	                  }
	                
	              
	            	  
	                 
	                if(printTime!=null){
	                	printTime.println(a, count++);
	                }
	                if(d==1){break;}
	            }
	           
		return a;
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
