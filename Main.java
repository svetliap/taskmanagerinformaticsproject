import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        //creating an instance of the taskManager class
        TaskManager manager=new TaskManager();
        //inputting raw data
        Scanner in=new Scanner(System.in);

        //run while not end
        for(;;){
            System.out.printf("Please select one of the options:\n1.Make Task\n2.Check as done\n3.Erase\n4.Display all\n5.Display due today\n6.End\nPlease select one of the options:");
            int select=in.nextInt();
            in.nextLine();
            if(select==1) add(manager,in);
            else if(select==2) mark(manager,in);
            else if(select==3) erase(manager,in);
            else if(select==4) manager.displayAll();
            else if(select==5) manager.displayToday();
            else if(select==6) {
                System.out.println("Exiting.\n");
                return;
            }
            else System.out.println("Try again. You need to write a number between 1 and 6."); //worst case
        }
    }
    private static void add(TaskManager manager,Scanner in){
        System.out.println("Please input on 2 new lines: name of task, due date in format YYYY-MM-DD, as well as whether it is important (0 or 1).\n");
        String name=in.nextLine();
        //we inputted name, now we input date
        LocalDate time=LocalDate.parse(in.next());
        //we input boolean additional variable whether it needs to be important
        boolean importance=((in.nextInt()==0)?false:true);
        //we call the add function insdie the TaskManager class
        manager.add(name,time,importance);
        System.out.printf("Done. This task will bear the number %d\n",manager.getTasks().size());
    }
    private static void mark(TaskManager manager,Scanner in){
        System.out.print("Number of task to be marked as done: ");
        int num=in.nextInt(); //input number of task
        boolean f=false; //found?
        for(Task u:manager.getTasks()){
            if(u.getTaskNum()==num){
                manager.mark(num);
                f=true;
                break;
            }
        }
        //task was found:
        if(f) System.out.println("Done.");
        //task not found:
        else System.out.println("Task not found.");
    }
    //erase tasks from list
    private static void erase(TaskManager manager,Scanner in){
        System.out.print("Number of task to be erased from the list: ");
        int num=in.nextInt(); //input number of task
        boolean f=manager.erase(num);
        //task was found:
        if(f) System.out.println("Done.");
        //task not found:
        else System.out.println("Task not found.");
    }
    //display all tasks that are due today's date
    private static void displayToday(TaskManager manager){
        System.out.println("Here is a list of all tasks due today:");
        for (Task u: manager.displayToday()) {
            System.out.println("Task number: "+u.getTaskNum()+", Name: "+u.getName() + ", due: " + u.getDue());
        }
    }
    //display all
    private static void displayAll(TaskManager manager){
        System.out.println("Here is a list of all tasks:");
        manager.displayAll();
    }

}

