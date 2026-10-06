import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static void saveBooks(List<Book> books, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Book book : books) {
                writer.write(
                        book.getId() + "," +
                                book.getTitle() + "," +
                                book.getAuthor() + "," +
                                book.getPublicationDate() + "," +
                                book.getPublisherId()
                );
                writer.newLine();
            }

            System.out.println("Books saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    public static List<Book> loadBooks(String fileName) {

        List<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                String publicationDate = data[3];
                String publisherId = data[4];

                Book book = new Book(
                        id,
                        title,
                        author,
                        publicationDate,
                        publisherId
                );

                books.add(book);
            }

            System.out.println("Books loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }

        return books;
    }
    public static void saveMembers(List<Member> members, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Member member : members) {

                String role = member.getClass().getSimpleName();

                writer.write(
                        member.getId() + "," +
                                member.getName() + "," +
                                member.getEmail() + "," +
                                role
                );

                writer.newLine();
            }

            System.out.println("Members saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving members: " + e.getMessage());
        }
    }


    public static List<Member> loadMembers(String fileName) {

        List<Member> members = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                String role = data[3];

                Member member;

                if (role.equals("Student")) {
                    member = new Student(id, name, email);

                } else if (role.equals("Publisher")) {
                    member = new Publisher(id, name, email);

                } else {
                    member = new Librarian(id, name, email);
                }

                members.add(member);
            }

            System.out.println("Members loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading members: " + e.getMessage());
        }

        return members;
    }
    public static void saveBorrowedBooks(
            List<BorrowedBook> borrowedBooks,
            String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (BorrowedBook borrowedBook : borrowedBooks) {

                writer.write(
                        borrowedBook.getMemberId() + "," +
                                borrowedBook.getBookId()
                );

                writer.newLine();
            }

            System.out.println("Borrowed books saved successfully.");

        } catch (IOException e) {
            System.out.println(
                    "Error saving borrowed books: " + e.getMessage()
            );
        }
    }


    public static List<BorrowedBook> loadBorrowedBooks(String fileName) {

        List<BorrowedBook> borrowedBooks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int memberId = Integer.parseInt(data[0]);
                int bookId = Integer.parseInt(data[1]);

                BorrowedBook borrowedBook =
                        new BorrowedBook(memberId, bookId);

                borrowedBooks.add(borrowedBook);
            }

            System.out.println("Borrowed books loaded successfully.");

        } catch (IOException e) {
            System.out.println(
                    "Error loading borrowed books: " + e.getMessage()
            );
        }

        return borrowedBooks;
    }
}