import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedReports {

    // Count borrowed books
    public static void countBorrowedBooks(List<BorrowedBook> borrowedBooks) {

        System.out.println("TOTAL BORROWED BOOKS: "
                + borrowedBooks.size());
    }

    // Group books by first character of title
    public static void groupBooksByFirstLetter(List<Book> books) {

        Map<Character, List<Book>> groupedBooks =
                books.stream()
                        .collect(Collectors.groupingBy(
                                book -> book.getTitle().charAt(0)
                        ));

        System.out.println("BOOKS GROUPED BY FIRST LETTER:");

        for (Map.Entry<Character, List<Book>> entry
                : groupedBooks.entrySet()) {

            System.out.println(entry.getKey() + ":");

            for (Book book : entry.getValue()) {
                System.out.println("  " + book.getTitle());
            }
        }
    }

    // Group books by publication year
    public static void groupBooksByPublicationYear(List<Book> books) {

        Map<String, List<Book>> groupedBooks =
                books.stream()
                        .collect(Collectors.groupingBy(
                                book -> book.getPublicationDate()
                                        .substring(0, 4)
                        ));

        System.out.println("BOOKS GROUPED BY PUBLICATION YEAR:");

        for (Map.Entry<String, List<Book>> entry
                : groupedBooks.entrySet()) {

            System.out.println(entry.getKey() + ":");

            for (Book book : entry.getValue()) {
                System.out.println("  " + book.getTitle());
            }
        }
    }
}