package fr.diginamic.props;

import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class TestConfiguration {

	public static void main(String[] args) {
		ResourceBundle monFichierConf = ResourceBundle.getBundle("monFichier");
		
//		String driverName = monFichierConf.getString("driver");
//		
//		System.out.println(driverName);
//		Enumeration<String> enums = monFichierConf.getKeys();
//		while (enums.hasMoreElements()) {
//			String enu = enums.nextElement();
//			  String valeur = monFichierConf.getString(enu);
//			  System.out.println(valeur);
//		}
		
		Set<String> set = monFichierConf.keySet();
		for (String a:set){
			System.out.println(a+" = "+monFichierConf.getString(a));
		}
	
	}

}
