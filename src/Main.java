//public class Main {
//
//    public static void main(String[] args) {
//
//        Book book = new Book(
//                1,
//                "Java Programming",
//                "John Smith",
//                "2025-01-10",
//                "PUB001"
//        );
//
//        Student student = new Student(
//                101,
//                "Ange",
//                "ange@email.com"
//        );
//
//        Publisher publisher = new Publisher(
//                102,
//                "Alice",
//                "alice@email.com"
//        );
//
//        Librarian librarian = new Librarian(
//                103,
//                "David",
//                "david@email.com"
//        );
//
//        System.out.println(book);
//        System.out.println(student);
//        System.out.println(publisher);
//        System.out.println(librarian);
//
//        System.out.println();
//
//        System.out.println("Student late fee: "
//                + student.calculateFees(5));
//
//        System.out.println("Publisher late fee: "
//                + publisher.calculateFees(5));
//
//        System.out.println("Librarian late fee: "
//                + librarian.calculateFees(5));
//    }
//}
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BookRepository repository = new BookRepository();

        Book book1 = new Book(
                1,
                "Java Programming",
                "John Smith",
                "2025-01-10",
                "PUB001"
        );

        Book book2 = new Book(
                2,
                "Python Basics",
                "Jane Smith",
                "2024-05-20",
                "PUB002"
        );

        repository.add(book1);
        repository.add(book2);

        System.out.println("ALL BOOKS:");
        LibraryUtils.showBooks(repository.getAll());

        System.out.println();
        System.out.println("SEARCH BOOK:");
        System.out.println(repository.findById(1));

        System.out.println();
        System.out.println("FUNCTIONAL INTERFACE:");
        BookAction action = book -> System.out.println(book.getTitle());

        for (Book book : repository.getAll()) {
            action.perform(book);
        }

        System.out.println();
        System.out.println("JAVA BOOKS:");
        BookReports.showJavaBooks(repository.getAll());

        System.out.println();
        System.out.println("BOOK TITLES:");
        BookReports.showBookTitles(repository.getAll());

        System.out.println();
        System.out.println("SORTED BOOKS:");
        BookReports.showSortedBooks(repository.getAll());
    }
}