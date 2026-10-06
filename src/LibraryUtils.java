import java.util.List;
public class LibraryUtils {

        public static void showBooks(List<? extends Book> books) {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
