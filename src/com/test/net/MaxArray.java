package com.test.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MaxArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//String arTimings[]= {"9:00", "9:40", "9:50", "11:00", "15:00", "18:00"} ;
		//String dptTimings[]= {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"} ;
		
		InputStreamReader r=new InputStreamReader(System.in);  
		BufferedReader br=new BufferedReader(r);  
		  
		System.out.println("Enter array values : ");  
		String arr[]=(br.readLine()).split(",");
		int intarr[] = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			intarr[i] = Integer.parseInt(arr[i].trim());
		}
		System.out.println("Enter key Size ::");  
		String size=(br.readLine());
		int s = Integer.parseInt(size);
		
		for(int i=0;i<intarr.length;i++) {
			int maxVal= intarr[i];
			if((i+s)<=intarr.length) {
				for(int j=i+1;j<(i+s);j++) {
					if(maxVal<intarr[j]) {
						maxVal=intarr[j];
					}
				}
				System.out.println(maxVal + " ");
			}
		}
		
		
				
		
	}


}
