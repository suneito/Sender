package Control;

public class GeneralConstants {
    protected final static String USER = "[Myself] > ";
    protected final static String SERVER_INSTANCE_LONG= "SERVER";
    protected final static String CLIENT_INSTANCE_LONG= "CLIENT";
    protected final static String SERVER_INSTANCE_SHORT= "S";
    protected final static String CLIENT_INSTANCE_SHORT= "C";
    protected final static String LOCALHOST= "127.0.0.1";
    protected final static String DEFAULT_PORT= "5050";  
    
    public class IsoLevel{   
    	public final static String IL1 = "ISOLATION LEVEL [1]";
        public final static String IL2 = "ISOLATION LEVEL [2]";
        public final static String IL3 = "ISOLATION LEVEL [3]";
        public final static String ILN = "NO ISOLATION LEVEL [N]";

    }
       
    public class Aesthetic{
		public final static String VERSION = "v1.2.2";
		public final static String BUSINESS = "babot.cat";
	    public static final String TITLE = "\n" +	                                     
	    	"   _____                _           \r\n" + 
	    	"  / ____|              | |          \r\n" + 
	    	" | (___   ___ _ __   __| | ___ _ __ \r\n" + 
	    	"  \\___ \\ / _ \\ '_ \\ / _` |/ _ \\ '__|\r\n" + 
	    	"  ____) |  __/ | | | (_| |  __/ |   " + VERSION + "\r\n" + 
	    	" |_____/ \\___|_| |_|\\__,_|\\___|_|   " + BUSINESS + " \r\n" + 
	    	"                                    \r\n" + 
	    	"                                    \r\n";	                                     
    }
    
    public class CryptoConstants{
    	public final static String ALGORITHM_LONG = "AES/ECB/PKCS5Padding";
    	public final static String ALGORITHM_SHORT = "AES";
    }
    
    public class Commands {
    	protected final static String END_CHAT = "/kill";   	
    }
}
