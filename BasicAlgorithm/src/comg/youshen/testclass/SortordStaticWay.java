package comg.youshen.testclass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

public class SortordStaticWay<T> {
	protected  void swap(T[] a, int b, int c) throws Exception {
             if(b>c){
            	throw new Exception("初始值异常"); 
             }
             
             if(a.length<=c){
            	 
            	 throw new Exception("数值不符合"); 
             }
             
             T tempObject =a[b];
             a[b] = a[c];
             a[c]=tempObject;
	}
	protected boolean checkType (Class clazz){
		return(clazz.equals(String.class)|| clazz.equals(Integer.class)||clazz.equals(Byte.class) ||clazz.equals(Long.class) ||clazz.equals(Double.class) ||   
		         clazz.equals(Float.class) ||   
		         clazz.equals(Character.class) ||   
		         clazz.equals(Short.class) ||   
		         clazz.equals(BigDecimal.class) ||   
		         clazz.equals(BigInteger.class) ||   
		         clazz.equals(Boolean.class) ||   
		         clazz.equals(Date.class) ||   
		         clazz.isPrimitive()   
		     );   
		 
}}
