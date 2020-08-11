package com.test.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Platforms {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//String arTimings[]= {"9:00", "9:40", "9:50", "11:00", "15:00", "18:00"} ;
		//String dptTimings[]= {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"} ;
		
		InputStreamReader r=new InputStreamReader(System.in);  
		BufferedReader br=new BufferedReader(r);  
		  
		System.out.println("Enter arraival timings\n");  
		String arTimings[]=(br.readLine()).split(",");
		
		System.out.println("Enter depature timings\n");  
		String dptTimings[]=(br.readLine()).split(",");
		System.out.println("arTimings====="+arTimings);
		System.out.println("dptTimings====="+dptTimings);
		
		
		if(arTimings.length!=dptTimings.length) {
			System.out.println("invalid input, no of arraials not matching with depatures");
		}else {
			Map<String,Integer> platformMap = new HashMap();
			int keySize =1;
			for(int i=0;i<arTimings.length;i++) {
				String key="p";
				boolean incKeySize = true;
				Integer dptTiming = getMinutes( dptTimings[i]);
				Integer arrTiming = getMinutes( arTimings[i]);
				System.out.println(" i======="+(i+1)+" ::"+dptTiming);
				if(platformMap.isEmpty()) {
					platformMap.put(key+keySize, dptTiming);
					
				}else {
					System.out.println("platformMap========"+platformMap);
					for(String keyVal : platformMap.keySet()) {
						if(platformMap.get(keyVal)<dptTiming && platformMap.get(keyVal)<arrTiming) {
							platformMap.put(keyVal, dptTiming);
							incKeySize= false;
							break;
						}
					}
					if(incKeySize) {
						keySize = keySize+1;
						platformMap.put(key+keySize, dptTiming);
					}
				}
				
			}
			System.out.println("KeySizes ======"+keySize);
		}
				
		
	}

	private static Integer getMinutes(String dptString) {
		// TODO Auto-generated method stub
		String ar[] = dptString.split(":");
		int minutes = Integer.parseInt(ar[0].trim())*60;
		if(ar.length>1) {
			minutes = minutes+Integer.parseInt(ar[1].trim());
		}
		return minutes;
	}

}
