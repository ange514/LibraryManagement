 import java.util.List;

    public class BookReports {

        public static void showJavaBooks(List<Book> books) {
            books.stream()
                    .filter(book -> book.getTitle().contains("Java"))
                    .forEach(System.out::println);
        }

        public static void showBookTitles(List<Book> books) {
            books.stream()
                    .map(Book::getTitle)
                    .forEach(System.out::println);
        }

        public static void showSortedBooks(List<Book> books) {
            books.stream()
                    .sorted((book1, book2) ->
                            book1.getTitle().compareTo(book2.getTitle()))
                    .forEach(System.out::println);
        }
    }

