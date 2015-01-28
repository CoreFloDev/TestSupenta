package supenta.florent.testapplication.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by florent on 27/01/15.
 */
public class LogModel extends Observable{

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
    public void addLog(LogEntry.Type type,String message) {
        logs.add(new LogEntry(type,new Date(),message));
        this.notifyObservers();
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
