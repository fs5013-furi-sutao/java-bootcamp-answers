package master.trycatch.multi.util;

public class Logger {

    public enum LogType {
        DEBUG("DEBUG"), 
        INFO("INFO"), 
        WARN("WARN"),;

        private String name;
        
        private LogType(String name) {
            this.name = name;
        }

        private String getName() {
            return this.name;
        }
    }
    
    public static void log(LogType type, String message) {
        System.out.format(
            "[%s] %s %n", type.getName(), message
        );
    }
}
