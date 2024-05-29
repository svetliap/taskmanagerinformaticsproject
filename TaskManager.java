import java.util.*;
import java.time.*;

//main body of the program
class TaskManager{
    private ArrayList<Task> tasks;
    private int currId; //index to assign id values

    //constructor
    public TaskManager(){
        tasks=new ArrayList<Task>();
        currId=0;//counter set value
    }
    //add task
    public void add(String name,LocalDate due,boolean imp){
        currId++;
        tasks.add(new Task(currId,name,due,imp));
    }
    //mark as done
    public void mark(int num){
        for(Task task:tasks){
            if(task.getTaskNum()==num){
                task.setDone(true);
                System.out.println("Success.");
                return;
            }
        }
        System.out.println("Try again.");
    }
    //erase
    public boolean erase(int num){
        int ind=0;
        for(Task task:tasks){
            if(task.getTaskNum()==num) {tasks.remove(ind); return true;}
            ind++;
        }
        return false;
    }
    //getter
     public List<Task> getTasks(){
        return tasks;
    }
    //display all tasks
    public void displayAll(){
        for(Task task: tasks){
            System.out.printf("Task No %d is called %s, has due date %s and the status of completion %s, although its importance was %s.",task.getTaskNum(),task.getName(),task.getDue(),task.doneOrNot(),task.isImp());
        }
    }
    //display due today
    public List<Task> displayToday(){
        List<Task> dueNow=new ArrayList<Task>();
        for(Task task:tasks){
            if(task.getDue().equals(LocalDate.now())){
                dueNow.add(task);
            }
        }
        return dueNow;
    }
}
