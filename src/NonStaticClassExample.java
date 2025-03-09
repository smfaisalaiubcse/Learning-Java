import java.time.LocalDate;
import java.time.Period;

public class NonStaticClassExample {
    public static void main(String[] args) {
        // Example using the Person class
        Person person = new Person(LocalDate.of(1950, 5, 15));
        if (person.isEligible()) {
            System.out.println("Eligible");
        } else {
            System.out.println("Not eligible");
        }

        // Example using the PersonAnonymous class
        PersonAnonymous personAnonymous = new PersonAnonymous(LocalDate.of(1950, 5, 15));
        if (personAnonymous.isEligible()) {
            System.out.println("Eligible");
        } else {
            System.out.println("Not eligible");
        }
    }
}

// Local class example
class Person {
    LocalDate dateOfBirth;

    public Person(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    boolean isEligible() {
        class CalculateAge {
            int getAge() {
                Period period = Period.between(dateOfBirth, LocalDate.now());
                return period.getYears();
            }
        }

        CalculateAge calculateAge = new CalculateAge();
        int age = calculateAge.getAge();
        return age >= 60; // Eligibility check based on age >= 60
    }
}

// Anonymous class example
interface CalculateAge {
    int getAge();
}

class PersonAnonymous {
    LocalDate dateOfBirth;
    public PersonAnonymous(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    boolean isEligible() {
        CalculateAge calculateAge = new CalculateAge() {
            @Override
            public int getAge() { //public access modifier because interface should be public
                Period period = Period.between(dateOfBirth, LocalDate.now());
                return period.getYears();
            }
        };
        int age = calculateAge.getAge();
        return age >= 60;
    }
}
