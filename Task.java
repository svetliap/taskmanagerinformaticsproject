import java.util.*;
import java.time.*;

class Task {
    private int taskNum;
    private LocalDate due;
    private String name;
    private boolean done;
    private boolean importance;
    //constructor
    public Task(int a,String b,LocalDate c,boolean d) {
        taskNum=a;
        due=c;
        name=b;
        importance=d;
        done=false;
    }

   //returns taskNum
    public String getName() {
        return name;
    }
    public LocalDate getDue() {
        return due;
    }
    public boolean isImp() {
        return importance;
    }
    public int getTaskNum() {
        return this.taskNum;
    }
    public boolean doneOrNot() {
        return done;
    }
    //setter
    public void setDone(boolean done){
        this.done=done;
    }
}
