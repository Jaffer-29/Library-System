public class Student extends Member{

    Student(String name, String id){
        super(name,id,5);
    }

    public void studentInfo(){
        System.out.printf("%11s : %-5s\n","Name",name);
        System.out.printf("%11s : %-5s\n","Student ID",iD);
        System.out.printf("%11s : %-5s\n","Book Limits",borrowingLimit);
    }

    public String role(){
        return "(is a Student)";
    }
    public void borrowBook(){
        System.out.println("Borrowed Books: ");
        for (Book b : borrowedBooks) {
            System.out.println(" - " + b.getTitle());
        }

    }

}
