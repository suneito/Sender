package Control;

import java.io.Console;
import Client.Client;
import Server.Server;
import Util.ToolSender;
import Crypto.Encryption;

/**
 * Controller
 * 
 * Starter class
 * @author Suneo
 *
 */

public class Controller {
	
	public static void main(String[] args) {
		ToolSender.cls();
		ToolSender.print(GeneralConstants.Aesthetic.TITLE);
		Encryption encrypter = null; 
		Console console = System.console (); 
		console.printf(GeneralConstants.IsoLevel.ILN);		
		try {
			encrypter = new Encryption(new String (console.readPassword ("\nEnter passoword: ")));
			console.printf("\nPassword accepted.\n");
			console.printf(GeneralConstants.IsoLevel.IL3);
		} catch (Exception e) {
			console.printf("PASSWORD ERROR. Execution ended up.\n");	
			System.exit(1);
		} 
		String tipoInstancia = (console.readLine("\nChoose instance type (" + GeneralConstants.CLIENT_INSTANCE_SHORT + "/" + GeneralConstants.SERVER_INSTANCE_SHORT + "):" ));
		console.flush();
		if(tipoInstancia.equalsIgnoreCase(GeneralConstants.CLIENT_INSTANCE_SHORT)) {
        	new Client(encrypter);
        }else if(tipoInstancia.equalsIgnoreCase(GeneralConstants.SERVER_INSTANCE_SHORT)) {
        	new Server(encrypter);
        }else {
        	console.printf("Unrecognized instance. Execution ended up.");
        	System.exit(1);
        }

	}

}
