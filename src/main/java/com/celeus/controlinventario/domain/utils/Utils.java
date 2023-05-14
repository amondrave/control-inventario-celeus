package com.celeus.controlinventario.domain.utils;

public class Utils {
	
	public static boolean isEmailValid(String email) {
	    String patron = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	    return email.matches(patron);
	}
	
	public static String cleanPath(String path) {
	    if (path == null) {
	        return null;
	    }
	    String pathToUse = path;
	    if (pathToUse.contains("\\")) {
	        pathToUse = pathToUse.replace("\\", "/");
	    }
	    if (pathToUse.contains("//")) {
	        pathToUse = pathToUse.replaceAll("/{2,}", "/");
	    }
	    if (!pathToUse.startsWith("/")) {
	        pathToUse = "/" + pathToUse;
	    }
	    return pathToUse;
	}

}
