package supenta.florent.testapplication.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by florent on 27/01/15.
 */
public class LogModel {

    // model data to store

    private List<LogEntry> logs = new ArrayList();


    // singleton of the model

    private static LogModel instance = null;

    public static LogModel getInstance() {
        if(instance == null) {
            instance = new LogModel();
        }
        return instance;
    }

    private LogModel(){};

    // actions available on the log
    public void addToLog(LogEntry.Type type,String message) {
        logs.add(new LogEntry(type,new Date(),message));
    }

    public List<LogEntry> getLogs() {
        return logs;
    }

    public void clearLog() {
        logs.clear();
    }

}
