
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {
	
    private final static Logger LOG = Logger.getGlobal();
    private static String methodName;
    private static String id;
    
    Logger logger = Logger.getLogger("mylogger");
	private static Logging instance = new Logging();
    
    public static void main(String[] args) throws SecurityException, IOException {
    }  
    
    public static Logging getLogger() {
		return instance;
	}
    
    public void log(String msg, String userId) throws SecurityException, IOException {
    	
    	 // remove default log handler
        logger.setUseParentHandlers(false);
        methodName = msg;
        id = userId;
        

        // add new log handler
        Handler handler = new FileHandler("server.log", true);
        handler.setFormatter(new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] %2$-20s | %3$s %n";
            
            @Override
            public synchronized String format(LogRecord lr) {
            	lr.setSourceMethodName(methodName);

                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getSourceMethodName(),
                        id
                );
            }
        });
        logger.addHandler(handler);

        // logging
        logger.info("");
	}
    
}