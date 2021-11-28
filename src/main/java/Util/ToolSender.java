package Util;

import Control.GeneralConstants;

/**
 * ToolSender
 * 
 * @author Suneo
 *
 */

public class ToolSender extends GeneralConstants {

	/**
	 * Print on console
	 * 
	 * @param String to print
	 */
	public static void print(String s) {
		System.out.print(s);
	}

	/**
	 * Clear console on Win
	 */
	public static void cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			print("CLS exception");
		}
	}
}
