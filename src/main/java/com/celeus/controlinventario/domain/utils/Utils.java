package com.celeus.controlinventario.domain.utils;

public class Utils {
	
	public static boolean isEmailValid(String email) {
	    String patron = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	    return email.matches(patron);
	}

}
