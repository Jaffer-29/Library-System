//An Abstract Class Code along with it's Child Class
public abstract class Staff {
    protected String name;
    protected String staffID;
    protected String role;

    Staff(String name,String staffID, String role){
        this.name = name;
        this.staffID = staffID;
        this.role = role;
    }

    public abstract void assistMember(Member member);

    public String getName(){
        return name;
    }

}
//Child Class : Assistant
public class assistant extends Staff{

    assistant(String name,String id){
        super(name,id,"Assistant");
    }

    public void assistMember(Member member) {
        System.out.println("Assistant ("+getName()+") helping: " + member.getName());
    }

    public void assistantInfo(){
        System.out.printf("%11s : %-5s\n","Name",name);
        System.out.printf("%11s : %-5s\n","Staff ID",staffID);
        System.out.printf("%11s : %-5s\n","Staff Role",role);
        System.out.printf("%11s : %-5s\n","Shift Time","9am to 5pm");
        System.out.println("________________________________________");

    }

}
//Child Class : Librarian
public class Librarian extends Staff{

    Librarian(String name, String id){
        super(name,id,"Librarian");
    }

    public void assistMember(Member member) {
        System.out.println("Librarian ("+getName()+") helping " + member.getName());
    }

    public void addBook(library l, Book book) {
        System.out.println("Librarian add a New Book to the System");
        l.addBook(book);
    }

    public void removeBook(library l, Book book) {
        System.out.println("Librarian remove a Book from the System");
        l.removeBook(book);
    }

    public void librarianInfo(){
        System.out.printf("%11s : %-5s\n","Name",name);
        System.out.printf("%11s : %-5s\n","Staff ID",staffID);
        System.out.printf("%11s : %-5s\n","Staff Role",role);
        System.out.printf("%11s : %-5s\n","Shift Time","10am to 5pm");
        System.out.println("________________________________________");
    }



}







