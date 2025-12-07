//Main Output Class. This class is using polymorphism in very diverse manner
//I take User Input for "Everything" to make a User intractive code

import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("\n\t\"Welcome to COMSATS Library, Abbottabad Campus\"");
        library myLibrary = new library("COMSATS Library", "Abbottabad");

        boolean run = true;
        while (run) {
            System.out.println("\n\t\"System Frame Work\"");
            System.out.println("1: Manage Administration");
            System.out.println("2: Book Management");
            System.out.println("3: Members Management");
            System.out.println("4: Exit");

            System.out.print("Enter Your Choice : ");
            int choice = in.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    adminMenu(myLibrary, in);
                    break;
                case 2:
                    bookMenu(myLibrary, in);
                    break;
                case 3:
                    memberMenu(myLibrary, in);
                    break;
                case 4:
                    run = false;
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        }

        in.close();
    }

        public static void adminMenu(library myLibrary, Scanner in) {
            boolean back = true;
            Librarian lib ;
            assistant asst;

            while (back) {
                System.out.println("\n\tAdministration Menu ");
                System.out.println("1. Add Staff");
                System.out.println("2. View Staff Info");
                System.out.println("3. Go Back");
                System.out.print("Enter choice: ");
                int c = in.nextInt();
                in.nextLine();

                switch (c) {
                    case 1:
                        System.out.println("A: Add Librarian");
                        System.out.println("B: Add Assistant");
                        System.out.print("Enter your Choice : ");
                        String choice = in.nextLine();

                        if(choice.equalsIgnoreCase("A")){
                            System.out.print("Enter Staff Name: ");
                            String name = in.nextLine();
                            System.out.print("Allot ID: ");
                            String sID = in.nextLine();
                            lib = new Librarian(name, sID);
                            myLibrary.addStaff(lib);
                        } else if (choice.equalsIgnoreCase("B")) {
                            System.out.print("Enter Staff Name: ");
                            String name = in.nextLine();
                            System.out.print("Allot ID: ");
                            String sID = in.nextLine();
                            asst = new assistant(name, sID);
                            myLibrary.addStaff(asst);
                        } else {
                            System.out.println("Invalid Choice");
                            break;
                        }

                        System.out.println("Staff Added Successfully!");
                        break;
                    case 2:
                        if (myLibrary.getStaffCount() == 0) {
                            System.out.println("No staff added yet!");
                        } else {
                            for (Staff s : myLibrary.getStaffList()) {
                                System.out.println("\n\tDisplaying Staff Info");
                                if (s instanceof Librarian) {
                                    ((Librarian) s).librarianInfo();
                                } else if (s instanceof assistant) {
                                    ((assistant) s).assistantInfo();
                                }
                            }
                        }
                        break;
                        case 3:
                        back = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    public static void bookMenu(library myLibrary, Scanner in) {
        boolean back = true;
        while (back) {
            System.out.println("\n\tBook Management Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View All Books");
            System.out.println("4. Borrow a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. View Borrowed Books");
            System.out.println("7. Go Back");
            System.out.print("Enter choice: ");
            int c = in.nextInt();
            in.nextLine(); // consume newline

            switch (c) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = in.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = in.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = in.nextLine();
                    Book newBook = new Book(title, author, isbn);
                    Librarian lib = new Librarian("Sara", "L001"); // or from admin list
                    lib.addBook(myLibrary, newBook);
                    break;

                case 2:
                    System.out.print("Enter Book Title to Remove: ");
                    String removeTitle = in.nextLine();
                    Book removeBook = findBookByTitle(myLibrary, removeTitle);
                    if (removeBook != null) {
                        Librarian librarian = new Librarian("Sara", "L001");
                        librarian.removeBook(myLibrary, removeBook);
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 3:
                    myLibrary.displayBooks();
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    String memberID = in.nextLine();
                    Member borrower = null;
                    for (Member m : myLibrary.getMemberList()) {
                        if (m.iD.equalsIgnoreCase(memberID)) {
                            borrower = m;
                            break;
                        }
                    }
                    if (borrower == null) {
                        System.out.println("Member not found!");
                        break;
                    }

                    System.out.print("Enter Book Title to Borrow: ");
                    String borrowTitle = in.nextLine();
                    Book bookToBorrow = findBookByTitle(myLibrary, borrowTitle);
                    if (bookToBorrow == null) {
                        System.out.println("Book not found!");
                        break;
                    }

                    try {
                        borrower.borrowBook(bookToBorrow);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter Member ID: ");
                    String returnID = in.nextLine();
                    Member returningMember = null;
                    for (Member m : myLibrary.getMemberList()) {
                        if (m.iD.equalsIgnoreCase(returnID)) {
                            returningMember = m;
                            break;
                        }
                    }
                    if (returningMember == null) {
                        System.out.println("Member not found!");
                        break;
                    }

                    System.out.print("Enter Book Title to Return: ");
                    String returnTitle = in.nextLine();
                    Book bookToReturn = findBookByTitle(myLibrary, returnTitle);
                    if (bookToReturn == null) {
                        System.out.println("Book not found!");
                        break;
                    }

                    try {
                        returningMember.returnBook(bookToReturn);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    myLibrary.displayBorrowedBooks();
                    break;

                case 7:
                    back = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void memberMenu(library myLibrary, Scanner in) {
        boolean back = true;
        while (back) {
            System.out.println("\n\tMember Management Menu");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Go Back");
            System.out.print("Enter choice: ");
            int c = in.nextInt();
            in.nextLine(); // consume newline

            switch (c) {
                case 1:
                    System.out.print("Enter Member Name: ");
                    String name = in.nextLine();
                    System.out.println("Select Member Type: \n1.Student \n2.Faculty \n3.External Member");
                    int type = in.nextInt();
                    Member m = null;
                    switch (type) {
                        case 1:
                            m = new Student(name, "S" + (myLibrary.getMembersCount() + 1));
                            break;
                        case 2:
                            m = new Faculty(name, "F" + (myLibrary.getMembersCount() + 1));
                            break;
                        case 3:
                            m = new externalMember(name, "E" + (myLibrary.getMembersCount() + 1));
                            break;
                        default:
                            System.out.println("Invalid type!");
                            continue;
                    }
                    myLibrary.regNewMem(m);
                    break;
                case 2:
                    myLibrary.displayMember();
                    break;
                case 3:
                    back = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static Book findBookByTitle(library myLibrary, String title) {
        for (Book b : myLibrary.books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }
}
