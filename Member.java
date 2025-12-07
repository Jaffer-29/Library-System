//Abstact Class Member with it's Child Classes

import java.util.ArrayList;

public abstract  class Member {
    protected String name;
    protected String iD;
    protected int borrowingLimit;
    protected ArrayList<Book> borrowedBooks = new ArrayList<>();

    Member(String name, String iD, int limit){
        this.name = name;
        this.iD = iD;
        this.borrowingLimit = limit;
    }
    public String getName(){
        return name;
    }

    public abstract String role();



    public void borrowBook(Book b) throws Exception {
        if (borrowedBooks.size() >= borrowingLimit) {
            throw new Exception(getName() + " reached borrowing limit of " + borrowingLimit);
        }
        if (b.isBorrowed()) {
            throw new Exception("Book \"" + b.getTitle() + "\" is already borrowed.");
        }
        b.borrowBook(this);
        borrowedBooks.add(b);
        System.out.println("Book \"" + b.getTitle() + "\" has been given to Member " + getName());
    }


    public void returnBook(Book b) throws Exception {
        if (!borrowedBooks.contains(b)) {
            throw new Exception(getName() + " did not borrow \"" + b.getTitle() + "\"");
        }
        b.returnBook(this);
        borrowedBooks.remove(b);
        System.out.println("Book \"" + b.getTitle() + "\" has been returned to the library by " + getName() +
                " at " + java.time.LocalDateTime.now());
    }

    public void displayBorrowed(){

        if (borrowedBooks.isEmpty()) {
            System.out.println(getName() + " has no borrowed books.");
        } else {
            System.out.println(getName() + " has borrowed:");
            for (Book b : borrowedBooks) {
                System.out.println(" - " + b.getTitle());
            }
        }
    }
}
//Child Class : Faculty
public class Faculty extends Member{

    Faculty(String name, String id){
        super(name,id,10);
    }

    public void facultyInfo(){
        System.out.printf("%11s : %-5s\n","Name",name);
        System.out.printf("%11s : %-5s\n","Faculty ID",iD);
        System.out.printf("%11s : %-5s\n","Book Limits",borrowingLimit);
    }

    public String role(){
        return "(is a Faculty Member)";
    }

}
//Child Class : Student
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
//Child Class : externalMember
public class externalMember extends Member{

    externalMember(String name, String id){
        super(name,id,3);
    }

    public void externalMemberInfo(){
        System.out.printf("%11s : %-5s\n","Name",name);
        System.out.printf("%11s : %-5s\n","Member ID",iD);
        System.out.printf("%11s : %-5s\n","Book Limits",borrowingLimit);
    }

    public String role(){
        return "(is a External Member)";
    }

}









