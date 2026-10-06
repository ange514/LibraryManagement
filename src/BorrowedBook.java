public class BorrowedBook {

    private int memberId;
    private int bookId;

    public BorrowedBook(int memberId, int bookId) {
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "memberId=" + memberId +
                ", bookId=" + bookId +
                '}';
    }
}
