package Control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.util.Scanner;
import Crypto.Encryption;
import Util.ToolSender;

/**
 * Estructure
 * Estructure for both instances
 * @author Suneo
 *
 */

public class Estructure extends GeneralConstants {	
	protected Socket socket;
	protected ServerSocket serverSocket;
	private DataInputStream entryBuffer = null;
    private DataOutputStream exitBuffer = null;
    protected Encryption encrypter = null;
    protected static Scanner scanner = new Scanner(System.in);
    protected static String comunicador = "";
    protected static Key key;
    
    /**
     * Get the data to send from console, previously encrypted
     */
    public void writeData() {
        String entrada = "";
        while (true) { 
        	ToolSender.print(USER); 
            entrada = encrypter.encrypt(scanner.nextLine());
            if (encrypter.decrypt(entrada).equalsIgnoreCase(Commands.END_CHAT)) {
            	closeConnection();
            } else if (entrada.length() > 0){
            	sendData(entrada);
            }
        }
    }
    
    /**
     * Send encrypted data with the DataOutputStream via buffer
     * @param String to send
     */
    public void sendData(String s) {
        try {
            exitBuffer.writeUTF(s);
            exitBuffer.flush();
        } catch (IOException e) {
        	ToolSender.print("Sending error.");
        	closeConnection();
        }
    }
    
    /**
     * Get encrypted data from DataInputStream and decrypts to show it
     */
    public void getData() {
        String st = "";
        try {
            do {
                st = encrypter.decrypt((String) entryBuffer.readUTF());
                ToolSender.print(comunicador + st);
                ToolSender.print('\n' + USER);
            } while (!st.equals(Commands.END_CHAT));
        } catch (IOException e) {
            closeConnection();
        }
    }
    
    /**
     * Ends the connection
     */
    public void closeConnection() {
        try {
        	socket.close();
            entryBuffer.close();
            exitBuffer.close();
            scanner.close();
            
        	ToolSender.cls();
            ToolSender.print("Connection ended.");
            ToolSender.print(GeneralConstants.IsoLevel.ILN);
        } catch (Exception e) {
        	ToolSender.print("Exception on closing conection. \nData may be exposed, manual delete required.");
        }finally{
            System.exit(0);
        }
    }
    
    /**
     * Start in-out streams
     */
    public void stream() {
        try {
            entryBuffer = new DataInputStream(socket.getInputStream());
            exitBuffer = new DataOutputStream(socket.getOutputStream());
            exitBuffer.flush();
        } catch (IOException e) {
        	ToolSender.print("Stream opening error.");
        	System.exit(0);
        }
    }
    

}
