package Client;

import java.net.*;
import Control.Estructure;
import Control.GeneralConstants;
import Crypto.Encryption;
import Util.ToolSender;

/**
 * Client
 * Client instance class
 * @author Suneo
 *
 */

public class Client extends Estructure{  
   
	/**
    * Consructor of the instance
    * @param encrypterObj
    */
	public Client(Encryption encrypterObj) {
		ToolSender.cls();
    	this.encrypter = encrypterObj;
    	comunicador = "\r[" + GeneralConstants.SERVER_INSTANCE_LONG + "] > ";        
        ToolSender.print("Server IP (default "+GeneralConstants.LOCALHOST+"): ");
        String ip = scanner.nextLine();
        if (ip.length() <= 0) ip = GeneralConstants.LOCALHOST;
       
        ToolSender.print("Port (default "+ GeneralConstants.DEFAULT_PORT +"): ");        
        String port = scanner.nextLine();
        if (port.length() <= 0) port = GeneralConstants.DEFAULT_PORT;
        this.runConnection(ip, Integer.parseInt(port));
        this.writeData();
	}
	
    /**
     * Start connection
     * @param server ip
     * @param server ip port
     */
    private void startConnection(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            ToolSender.print("Connected with " + socket.getInetAddress().getHostName() + ".\n");
            ToolSender.print(GeneralConstants.IsoLevel.IL2);
        } catch (Exception e) {
        	ToolSender.print("Starting connection error.");
            System.exit(1);
        }
    }

    /**
     * Run on connection by thread
     * @param port
     */
    public void runConnection(final String ip, final int port) {
        Thread threadClient = new Thread(new Runnable() {
            public void run() {
                try {
                    startConnection(ip, port);
                    stream();
                    getData();
                } finally {
                	ToolSender.print("Connection server error.");
                    closeConnection();
                }
            }
        });
        threadClient.start();
    }
}
