import java.util.logging.Logger;

public class LogfileProgram {
    private static Logger log= Logger.getLogger("request");

    public static void main(String[] args) {
        try{
            log.info("Line Number"+new Exception().getStackTrace()[0].getLineNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
