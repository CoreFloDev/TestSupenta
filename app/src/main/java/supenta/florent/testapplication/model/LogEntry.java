package supenta.florent.testapplication.model;

import java.util.Date;

/**
 * Created by florent on 28/01/15.
 * Data stored in a log line
 */
public class LogEntry {

    // possible data to store
    public enum Type {
        APP_INSTALLED,
        APP_REMOVED,
        APP_UPDATED
    }

    // data to store in a log
    private Type type;
    private Date date;
    private String message;

    public LogEntry(Type type,Date date,String string) {
        this.type = type;
        this.date = date;
        this.message = string;
    }

    public Type getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

}
