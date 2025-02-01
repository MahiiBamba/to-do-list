package toDoList;

import java.util.LinkedList;
import java.util.Scanner;

public class MainFile {
    private static LinkedList<Task> taskLinkedList = new LinkedList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("Enter your choice:\n1. Add task\n2. Mark done" +
                    "\n3. Remove task\n4. Display To do list\n5. Display All incomplete tasks");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1: addTask();
                break;
                case 2: markTaskDone();
                break;
                case 3: removeTask();
                break;
                case  4: display();
                break;
                case 5: displayAllUncompleted();
                break;
                default:
                    System.out.println("Enter a valid choice!!, Try Again");
            }
        }
    }
    public static void addTask(){
        System.out.println("Enter toDoList.Task Name: ");
        String taskName = sc.nextLine();
        System.out.println("Enter it's deadline: ");
        String dl = sc.nextLine();
        taskLinkedList.add(new Task(taskName, dl));
        System.out.println("toDoList.Task added successfully");
    }

    public static void markTaskDone(){
        System.out.println("Enter task Name to marks as done: ");
        String taskName = sc.nextLine();
        for(Task tsk : taskLinkedList){
            if(tsk.getTaskName().equalsIgnoreCase(taskName)){
                tsk.setIsCompleted();
            }
        }
        System.out.println("Marked task as a Done!!");
    }

    public static void removeTask(){
        System.out.println("Enter name of task to be removed: ");
        String taskName = sc.nextLine();
        Task taskToRemove = null;

        for(Task tsk : taskLinkedList){
            if(tsk.getTaskName().equalsIgnoreCase(taskName)){
                taskToRemove = tsk;
                break;
            }
        }
        if(taskToRemove != null){
            taskLinkedList.remove(taskToRemove);
            System.out.println("toDoList.Task removed successfully");
        } else{
            System.out.println("toDoList.Task do not exits");
        }
    }

    public static void display(){
        if(taskLinkedList.isEmpty()){
            System.out.println("List is Empty!!");
            return;
        }
        int i =0;
        for(Task tsk: taskLinkedList){
            System.out.println((++i)+". "+tsk);
        }
    }

    public static void displayAllUncompleted(){
        if(taskLinkedList.isEmpty()){
            System.out.println("List is Empty!!");
            return;
        }
        int i =0;
        for(Task tsk: taskLinkedList){
            if(!tsk.getIsCompleted()){
                System.out.println((++i)+". "+ tsk);
            }
        }
    }
}