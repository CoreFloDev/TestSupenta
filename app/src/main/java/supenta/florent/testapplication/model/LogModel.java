package supenta.florent.testapplication.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by florent on 27/01/15.
 */
public class LogModel {

    // model data to store

    private List<LogEntry> logs;


    // singleton of the model

    private static LogModel instance = null;

    public static LogModel getInstance() {
        if(instance == null) {
            instance = new LogModel();
        }
        return instance;
    }

    private LogModel(){
        this.logs = new ArrayList();
    }

    // actions available on the log
    public void addLog(LogEntry.Type type,String message) {
        logs.add(new LogEntry(type,new Date(),message));
    }

    public List<LogEntry> getLogs() {
        return logs;
    }

    public void clearLog() {
        logs.clear();
    }

    public LogEntry getLastLog() {
        return logs.get(logs.size()-1);
    }
}
