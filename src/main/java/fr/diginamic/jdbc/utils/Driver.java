package fr.diginamic.jdbc.utils;

import java.util.ResourceBundle;

public class Driver {
	public static void driver(){
		ResourceBundle result = ResourceBundle.getBundle("database");
		try {
			Class.forName(result.getString("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
