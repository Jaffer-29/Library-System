//This is Storge Class for thee books

import java.time.LocalDateTime;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private boolean isBorrowed;
    private Member borrower;
    private String lastTransaction;

    Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
        this.borrower = null;
        this.lastTransaction = "No transactions yet.";
    }

    String getTitle(){

        return title;
    }
    public void bookInfo(){
        System.out.printf("%11s : %-5s\n", "Book Title", title);
        System.out.printf("%11s : %-5s\n","Author Name", author);
        System.out.printf("%11s : %-5s\n","ISBN",isbn);
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook(Member borrower) throws Exception {
        if (isBorrowed) {
            throw new Exception("Book is already borrowed!");
        }
        this.isBorrowed = true;
        this.borrower = borrower;
        this.lastTransaction = "Borrowed by: " + borrower.getName() + " at " + LocalDateTime.now();
    }

    public void returnBook(Member borrower) throws Exception {
        if (!isBorrowed) {
            throw new Exception("Book is not borrowed!");
        }
        if (this.borrower != borrower) {
            throw new Exception("This member didn’t borrow this book!");
        }
        isBorrowed = false;
        this.borrower = null;
        lastTransaction = "Returned at " + LocalDateTime.now();
    }

    @Override
    public String toString() {
        return title + " | ISBN: " + isbn + " | Status : " + (isBorrowed ? "Borrowed" : "Available");
    }

    public Member getBorrower() {
        return borrower;
    }
}
