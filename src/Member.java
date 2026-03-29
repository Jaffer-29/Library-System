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
