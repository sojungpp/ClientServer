
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {
	
    private static String commandType;
    private static String id;
    Logger logger = Logger.getLogger("logger");
	private static Logging instance = new Logging();
    
    public void log(String methodName, String userId) throws SecurityException, IOException {
        logger.setUseParentHandlers(false);
        commandType = methodName;
        id = userId;
        Handler handler = new FileHandler("server.log", true);
        handler.setFormatter(new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] %2$-20s | %3$s %n";
            
            @Override
            public synchronized String format(LogRecord logRecord) {
            	logRecord.setSourceMethodName(commandType);
                return String.format(format, new Date(logRecord.getMillis()), logRecord.getSourceMethodName(), id);
            }
        });
        logger.addHandler(handler);
        logger.info("");
	}
    
    public static Logging getLogger() {
		return instance;
	}
}