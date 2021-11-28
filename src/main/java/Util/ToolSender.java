package Util;

import Control.GeneralConstants;

public class ToolSender extends GeneralConstants {
    
	public static void print(String s) {
        System.out.print(s);
    }
	
	public static void cls() {
		try {
			new ProcessBuilder ("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			print("CLS exception");
		}
	}
}
