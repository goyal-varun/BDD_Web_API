package com.hcl.withoutframework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0, "Hello");
		hm.put(1, "Good Morning");
		hm.put(2, "Good Evening");
		System.out.println(hm);
		// System.out.println(hm.get(2));
		
		
		/*Set sn = hm.entrySet();
		Iterator it = sn.iterator();

		while (it.hasNext()) {
			// System.out.println(it.next());
			Map.Entry mp = (Map.Entry) it.next();
			System.out.println(mp.getKey());
			System.out.println(mp.getValue());
		}*/
		
		Iterator <Integer> it = hm.keySet().iterator();       //keyset is a method  
		/*while(it.hasNext())  
		{  
			//System.out.println(it.next().getClass());
			int key=it.next();  
			System.out.println(key+" "+hm.get(key));  
		}*/
		int count =0;
		for(Map.Entry mapEntry : hm.entrySet()){    
			count = count+(int)mapEntry.getKey();
			System.out.println(mapEntry.getKey()+" "+mapEntry.getValue());
			System.out.println(mapEntry.getKey().getClass()+" "+mapEntry.getValue().getClass());
		}
		
		

	}

}
