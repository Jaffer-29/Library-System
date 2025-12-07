//This class is most dominant in among the others

import java.util.ArrayList;

public class library {

    private String name;
    private final String location;
    protected ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> member = new ArrayList<>();
    private ArrayList<Staff> staff = new ArrayList<>();


    library(String name,  String location){
        this.name = name;
        this.location = location;
    }

    public void addBook(Book b){
        books.add(b);
        b.bookInfo();
        System.out.println("\n\"Location to Search : "+name+" "+ location+"\"");

    }

    public void removeBook(Book b){
        books.remove(b);
        System.out.println("Book has been Removed From the System with following info:");
        b.bookInfo();
        System.out.println("Space is Free now at : "+location);
    }

    public void regNewMem(Member m){
        member.add(m);
        System.out.println("New Member Welcomed in Library");
        System.out.println("\t\""+m.getName()+" is Our New Respected Member\"");

    }

    public void addStaff(Staff s){
        staff.add(s);
        System.out.println("Staff Member is Added in Faculty");
    }

    public void displayBooks(){
        System.out.println("\n\tBooks Collection");
        if(books.isEmpty()){
            System.out.println("No Book Available in the System right now");
        }else {
            System.out.println("Books in System : "+books.size());
            for (Book b : books) {
                System.out.println("- Title: " + b);
            }
        }
    }

    public void displayMember(){
        System.out.println("\n\t\t\"Member Details\"");
        if(member.isEmpty()){
            System.out.println("No Member is Registered Yet");
            System.out.println("Total No. of Members : "+member.size());
        }else{
        System.out.println("Total No. of Members : "+member.size());
        for(Member m : member){
            System.out.println("- " + m.getName() + " "+m.role());
            System.out.println(" Member ID: "+m.iD);
        }
    }
    }

    public boolean searchBook(String search) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(search)) {
                System.out.println("Book has been Found in System");
                System.out.printf("%11s : %-5s\n", "Book Title", b.getTitle());
                System.out.println("\"Location to Search : " + location + "\"");
                return true;
            }
        }

        System.out.println("No Such Book Exist in System");
        return false;
    }

    public int availableBooksCount() {
        int count = 0;
        for (Book b : books) {
            if (!b.isBorrowed()) count++;
        }
        return count;
    }

    public void displayBorrowedBooks() {
        boolean anyBorrowed = false;
        System.out.println("\n\tBorrowed Books:");
        for (Book b : books) {
            if (b.isBorrowed()) {
                System.out.println("- Title:  " + b.getTitle() + " by " + b.getBorrower().getName());
                anyBorrowed = true;
            }
        }
        if (!anyBorrowed) {
            System.out.println("No books are currently borrowed.");
        }
    }
    public int getMembersCount() {
        return member.size();
    }
    public ArrayList<Staff> getStaffList() {
        return staff;
    }

    public int getStaffCount() {
        return staff.size();
    }


    public ArrayList<Member> getMemberList() {
        return member;
    }

}
