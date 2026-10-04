public class Publisher extends Member {

        public Publisher(int id, String name, String email) {
            super(id, name, email);
        }

        @Override
        public double calculateFees(int daysLate) {
            return daysLate * 150;
        }

        @Override
        public String toString() {
            return "Publisher: " + super.toString();
        }
    }
