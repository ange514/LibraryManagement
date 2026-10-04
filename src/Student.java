public class Student extends Member {

        public Student(int id, String name, String email) {
            super(id, name, email);
        }

        @Override
        public double calculateFees(int day) {
            return day * 100;
        }

        @Override
        public String toString() {
            return "Student: " + super.toString();
        }
    }
