public class MVCPatternExample {
    public static void main(String[] args) {
       
        Student student = new Student("Alice", "S101", "A");

     
        StudentView view = new StudentView();

       
        StudentController controller = new StudentController(student, view);

     
        controller.updateView();

        
        controller.setStudentName("Bob");
        controller.setStudentGrade("B+");

        
        controller.updateView();
    }
}
