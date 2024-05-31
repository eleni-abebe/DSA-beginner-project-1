package todo;

import java.util.Scanner;

class Task {
    String statement;
    boolean completed;
    Task next;

    Task(String statement) {
        this.statement = statement;
        this.completed = false;
        this.next = null;
    }
}

class ToDoList {
    private Task head;

    public ToDoList() {
        this.head = null;
    }

    public void addTask(String statement) {
        Task newTask = new Task(statement);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added- " + statement);
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks currently found.");
        } else {
            System.out.println("ToDo Lists-");
            Task current = head;
            int index = 1;
            while (current != null) {
                System.out.println(index + ", " + current.statement + " - " + (current.completed ? "Completed" : "Incomplete"));
                current = current.next;
                index++;
            }
        }
    }

    public void markTasks(int index) {
        if (head == null) {
            System.out.println("No tasks to be checked");
        } else {
            Task current = head;
            int currentIndex = 1;
            while (current != null) {
                if (currentIndex == index) {
                    current.completed = true;
                    System.out.println("completed task- " + current.statement);
                    return;
                }
                current = current.next;
                currentIndex++;
            }
            System.out.println("Invalid task number.");
        }
    }

    public void deleteTask(int index) {
        if (head == null) {
            System.out.println("No tasks found.");
        } else if (index == 1) {
            head = head.next;
            System.out.println("Task deleted: " + head.statement);
        } else {
            Task current = head;
            int currentIndex = 1;
            while (current.next != null) {
                if (currentIndex == index - 1) {
                    Task taskToDelete = current.next;
                    current.next = current.next.next;
                    System.out.println("Task deleted: " + taskToDelete.statement);
                    return;
                }
                current = current.next;
                currentIndex++;
            }
            System.out.println("Invalid task number.");
        }
    }
}
public class ToDoLists {

	public static void main(String[] args) {

        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        boolean operating = true;

        while (operating) {
            System.out.println("\n To-Do List options");
            System.out.println("1. Add a task");
            System.out.println("2. Display all tasks");
            System.out.println("3. Mark a task as complete");
            System.out.println("4. Delete a task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter your tasks: ");
                    String todotask = scanner.nextLine();
                    toDoList.addTask(todotask);
                    break;
                case 2:
                    toDoList.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter the task number you have completed  ");
                    int Index = scanner.nextInt();
                    scanner.nextLine(); 
                    toDoList.markTasks(Index);
                    break;
                case 4:
                    System.out.print("Enter the task number you want to remove: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine(); 
                    toDoList.deleteTask(deleteIndex);
                    break;
                case 5:
                    operating = false;
                    System.out.println("stoping the operaton");
                    break;
                default:
                    System.out.println("Invalid number ");
            }
        }

        scanner.close();
    


	

	}

}
