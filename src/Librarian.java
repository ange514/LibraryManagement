public class Librarian extends Member {

        public Librarian(int id, String name, String email) {
            super(id, name, email);
        }

        @Override
        public double calculateFees(int daysLate) {
            return 0;
        }

        @Override
        public String toString() {
            return "Librarian: " + super.toString();
        }
    }
