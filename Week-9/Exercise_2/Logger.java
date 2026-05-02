package Exercise_2;

import java.time.LocalDateTime;

public class Logger {
    void log(String userId, boolean success) {
        System.out.println("[LOG] " + LocalDateTime.now() 
        + " - User: " + userId 
        + " - Status: " + (success ? "SUCCESS" : "FAILURE"));
    }
}
