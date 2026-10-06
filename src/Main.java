import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static BookRepository repository = new BookRepository();
    static List<Member> members = new ArrayList<>();
    static List<BorrowedBook> borrowedBooks = new ArrayList<>();

    public static void main(String[] args) {

        // Sample books
        repository.add(new Book(
                1,
                "Java Programming",
                "John Smith",
                "2025-01-10",
                "PUB001"
        ));

        repository.add(new Book(
                2,
                "Python Basics",
                "Jane Smith",
                "2024-05-20",
                "PUB002"
        ));

        boolean running = true;

        while (running) {

            System.out.println("\n==============================");
            System.out.println("   LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Book Management");
            System.out.println("2. Member Management");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Borrowed Books");
            System.out.println("6. Lab 2 Reports");
            System.out.println("7. Lab 3 Reports");
            System.out.println("8. Save Data");
            System.out.println("9. Load Data");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    bookMenu();
                    break;

                case 2:
                    memberMenu();
                    break;

                case 3:
                    borrowBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    viewBorrowedBooks();
                    break;

                case 6:
                    lab2Reports();
                    break;

                case 7:
                    lab3Reports();
                    break;

                case 8:
                    saveData();
                    break;

                case 9:
                    loadData();
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using the Library Management System.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }


    // =========================
    // BOOK MANAGEMENT
    // =========================

    public static void bookMenu() {

        boolean running = true;

        while (running) {

            System.out.println("\n--- BOOK MANAGEMENT ---");
            System.out.println("1. View all books");
            System.out.println("2. Add book");
            System.out.println("3. Search book");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    LibraryUtils.showBooks(repository.getAll());
                    break;

                case 2:
                    addBook();
                    break;

                case 3:
                    searchBook();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }


    public static void addBook() {

        System.out.print("Enter book ID: ");
        int id = readInt();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter publication date (YYYY-MM-DD): ");
        String publicationDate = scanner.nextLine();

        System.out.print("Enter publisher ID: ");
        String publisherId = scanner.nextLine();

        Book book = new Book(
                id,
                title,
                author,
                publicationDate,
                publisherId
        );

        repository.add(book);

        System.out.println("Book added successfully.");
    }


    public static void searchBook() {

        System.out.print("Enter book ID: ");
        int id = readInt();

        Book book = repository.findById(id);

        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }


    // =========================
    // MEMBER MANAGEMENT
    // =========================

    public static void memberMenu() {

        boolean running = true;

        while (running) {

            System.out.println("\n--- MEMBER MANAGEMENT ---");
            System.out.println("1. Register member");
            System.out.println("2. View members");
            System.out.println("3. Calculate late fee");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    registerMember();
                    break;

                case 2:
                    viewMembers();
                    break;

                case 3:
                    calculateLateFee();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }


    public static void registerMember() {

        System.out.print("Enter member ID: ");
        int id = readInt();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("Choose member type:");
        System.out.println("1. Student");
        System.out.println("2. Publisher");
        System.out.println("3. Librarian");
        System.out.print("Choice: ");

        int type = readInt();

        Member member;

        if (type == 1) {
            member = new Student(id, name, email);

        } else if (type == 2) {
            member = new Publisher(id, name, email);

        } else if (type == 3) {
            member = new Librarian(id, name, email);

        } else {
            System.out.println("Invalid member type.");
            return;
        }

        members.add(member);

        System.out.println("Member registered successfully.");
    }


    public static void viewMembers() {

        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        for (Member member : members) {
            System.out.println(member);
        }
    }


    public static void calculateLateFee() {

        System.out.print("Enter member ID: ");
        int id = readInt();

        Member foundMember = null;

        for (Member member : members) {

            if (member.getId() == id) {
                foundMember = member;
                break;
            }
        }

        if (foundMember == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.print("Enter number of days late: ");
        int daysLate = readInt();

        System.out.println(
                "Late fee: " +
                        foundMember.calculateFees(daysLate)
        );
    }


    // =========================
    // BORROW BOOK
    // =========================

    public static void borrowBook() {

        System.out.print("Enter member ID: ");
        int memberId = readInt();

        Member member = null;

        for (Member m : members) {
            if (m.getId() == memberId) {
                member = m;
                break;
            }
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.print("Enter book ID: ");
        int bookId = readInt();

        Book book = repository.findById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        borrowedBooks.add(
                new BorrowedBook(memberId, bookId)
        );

        System.out.println(
                "Book borrowed successfully."
        );
    }


    // =========================
    // RETURN BOOK
    // =========================

    public static void returnBook() {

        System.out.print("Enter member ID: ");
        int memberId = readInt();

        System.out.print("Enter book ID: ");
        int bookId = readInt();

        for (BorrowedBook borrowedBook : borrowedBooks) {

            if (borrowedBook.getMemberId() == memberId
                    && borrowedBook.getBookId() == bookId) {

                borrowedBooks.remove(borrowedBook);

                System.out.println(
                        "Book returned successfully."
                );

                return;
            }
        }

        System.out.println(
                "Borrowed book record not found."
        );
    }


    // =========================
    // VIEW BORROWED BOOKS
    // =========================

    public static void viewBorrowedBooks() {

        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
            return;
        }

        for (BorrowedBook borrowedBook : borrowedBooks) {
            System.out.println(borrowedBook);
        }
    }


    // =========================
    // LAB 2 REPORTS
    // =========================

    public static void lab2Reports() {

        System.out.println("\n--- LAB 2 REPORTS ---");

        System.out.println("\nJava Books:");
        BookReports.showJavaBooks(repository.getAll());

        System.out.println("\nBook Titles:");
        BookReports.showBookTitles(repository.getAll());

        System.out.println("\nSorted Books:");
        BookReports.showSortedBooks(repository.getAll());
    }


    // =========================
    // LAB 3 REPORTS
    // =========================

    public static void lab3Reports() {

        System.out.println("\n--- LAB 3 REPORTS ---");

        AdvancedReports.countBorrowedBooks(
                borrowedBooks
        );

        System.out.println();

        AdvancedReports.groupBooksByFirstLetter(
                repository.getAll()
        );

        System.out.println();

        AdvancedReports.groupBooksByPublicationYear(
                repository.getAll()
        );
    }


    // =========================
    // SAVE DATA
    // =========================

    public static void saveData() {

        FileManager.saveBooks(
                repository.getAll(),
                "books.txt"
        );

        FileManager.saveMembers(
                members,
                "members.txt"
        );

        FileManager.saveBorrowedBooks(
                borrowedBooks,
                "borrowed_books.txt"
        );

        System.out.println("All data saved successfully.");
    }


    // =========================
    // LOAD DATA
    // =========================

    public static void loadData() {

        List<Book> loadedBooks =
                FileManager.loadBooks("books.txt");

        List<Member> loadedMembers =
                FileManager.loadMembers("members.txt");

        List<BorrowedBook> loadedBorrowedBooks =
                FileManager.loadBorrowedBooks(
                        "borrowed_books.txt"
                );

        repository = new BookRepository();

        for (Book book : loadedBooks) {
            repository.add(book);
        }

        members = new ArrayList<>(loadedMembers);

        borrowedBooks =
                new ArrayList<>(loadedBorrowedBooks);

        System.out.println("All data loaded successfully.");
    }


    // =========================
    // READ INTEGER SAFELY
    // =========================

    public static int readInt() {

        while (true) {

            try {

                int number = Integer.parseInt(
                        scanner.nextLine()
                );

                return number;

            } catch (NumberFormatException e) {

                System.out.print(
                        "Please enter a valid number: "
                );
            }
        }
    }
}