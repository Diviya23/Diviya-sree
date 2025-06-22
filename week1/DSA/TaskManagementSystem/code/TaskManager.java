public class TaskManager {
    private Task head;

  
    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added.");
    }

  
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
        } else {
            Task current = head;
            while (current != null) {
                current.printTask();
                current = current.next;
            }
        }
    }

  
    public Task searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

 
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Task current = head;
        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task deleted.");
        }
    }

   
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();

        tm.addTask(1, "Design Module", "Pending");
        tm.addTask(2, "Code Module", "In Progress");
        tm.addTask(3, "Test Module", "Completed");

        System.out.println("\nAll Tasks:");
        tm.traverseTasks();

        System.out.println("\nSearching for Task ID 2:");
        Task found = tm.searchTask(2);
        if (found != null) {
            found.printTask();
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task ID 1:");
        tm.deleteTask(1);

        System.out.println("\nAll Tasks After Deletion:");
        tm.traverseTasks();
    }
}
