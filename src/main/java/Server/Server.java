package Server;

import java.net.*;
import Control.Estructure;
import Control.GeneralConstants;
import Crypto.Encryption;
import Util.ToolSender;

/**
 * Server Server instance class
 * 
 * @author Suneo
 *
 */

public class Server extends Estructure {

	/**
	 * Consructor of the instance
	 * 
	 * @param encrypterObj
	 */
	public Server(Encryption encrypterObj) {
		ToolSender.cls();
		this.encrypter = encrypterObj;
		comunicador = "\r[" + GeneralConstants.CLIENT_INSTANCE_LONG + "] > ";
		ToolSender.print("Port (default " + GeneralConstants.DEFAULT_PORT + "): ");
		String port = scanner.nextLine();
		if (port.length() <= 0)
			port = GeneralConstants.DEFAULT_PORT;
		this.runConnection(Integer.parseInt(port));
		this.writeData();
	}

	/**
	 * Start connection
	 * 
	 * @param port
	 */
	public void startConnection(int port) {
		try {
			serverSocket = new ServerSocket(port);
			ToolSender.print("Waiting for a connection at " + String.valueOf(port) + ".");
			// Wait for a client accept the connection
			socket = serverSocket.accept();
			ToolSender.print("Connected with " + socket.getInetAddress().getHostName() + ".\n");
			ToolSender.print(GeneralConstants.IsoLevel.IL2);
		} catch (Exception e) {
			ToolSender.print("Starting connection error.");
			System.exit(1);
		}
	}

	/**
	 * Run on connection by thread
	 * 
	 * @param port
	 */
	public void runConnection(final int port) {
		Thread threadServer = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						startConnection(port);
						stream();
						getData();
					} finally {
						ToolSender.print("Connection client error.");
						closeConnection();
					}
				}
			}
		});
		threadServer.start();
	}
}
