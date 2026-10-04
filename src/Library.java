import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

    public class Library {

        private List<Book> books;
        private Set<Member> members;
        private Map<Integer, Member> memberAccounts;

        public Library() {
            books = new ArrayList<>();
            members = new HashSet<>();
            memberAccounts = new HashMap<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public void addMember(Member member) {
            members.add(member);
            memberAccounts.put(member.getId(), member);
        }

        public void showBooks() {
            for (Book book : books) {
                System.out.println(book);
            }
        }

        public void showMembers() {
            for (Member member : members) {
                System.out.println(member);
            }
        }

        public Member findMember(int id) {
            return memberAccounts.get(id);
        }
    }
}
