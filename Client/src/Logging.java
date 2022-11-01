
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {
	
    private final static Logger LOG = Logger.getGlobal();
    Logger logger = Logger.getLogger("mylogger");
	private static Logging instance = new Logging();
    
    public static void main(String[] args) throws SecurityException, IOException {
        //=============================================
        // 기본 로그 제거
        //------------
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }
        //=============================================
        
        LOG.setLevel(Level.INFO);
        
        Handler handler = new FileHandler("client.log", true);
        
        LogFormatter formatter = new LogFormatter();
        handler.setFormatter(formatter);
        LOG.addHandler(handler);
        
        LOG.severe("severe Log");
        LOG.warning("warning Log");
        LOG.info("info Log");
    }  
}