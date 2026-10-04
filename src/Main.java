public class Main {

    public static void main(String[] args) {

        Book book = new Book(
                1,
                "Java Programming",
                "John Smith",
                "2025-01-10",
                "PUB001"
        );

        Student student = new Student(
                101,
                "Ange",
                "ange@email.com"
        );

        Publisher publisher = new Publisher(
                102,
                "Alice",
                "alice@email.com"
        );

        Librarian librarian = new Librarian(
                103,
                "David",
                "david@email.com"
        );

        System.out.println(book);
        System.out.println(student);
        System.out.println(publisher);
        System.out.println(librarian);

        System.out.println();

        System.out.println("Student late fee: "
                + student.calculateFees(5));

        System.out.println("Publisher late fee: "
                + publisher.calculateFees(5));

        System.out.println("Librarian late fee: "
                + librarian.calculateFees(5));
    }
}