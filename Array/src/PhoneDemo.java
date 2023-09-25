import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Phone {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String creditCardNumber;
    private double debit;
    private double credit;
    private double localCallsTime;
    private double internationalCallsTime;

    public Phone(int id, String lastName, String firstName, String middleName, String address,
                 String creditCardNumber, double debit, double credit, double localCallsTime, double internationalCallsTime) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.localCallsTime = localCallsTime;
        this.internationalCallsTime = internationalCallsTime;
    }

    public double getLocalCallsTime() {
        return localCallsTime;
    }

    public double getInternationalCallsTime() {
        return internationalCallsTime;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nФамилия: " + lastName + "\nИмя: " + firstName + "\nОтчество: " + middleName +
                "\nАдрес: " + address + "\nНомер кредитной карточки: " + creditCardNumber + "\nДебет: " + debit +
                "\nКредит: " + credit + "\nВремя городских разговоров: " + localCallsTime +
                "\nВремя междугородных разговоров: " + internationalCallsTime + "\n";
    }
}

public class PhoneDemo {
    public static void main(String[] args) {
        ArrayList<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone(1, "Иванов", "Иван", "Иванович", "Москва", "1234-5678-9012-3456", 1000, 0, 50, 20));
        phoneList.add(new Phone(2, "Петров", "Петр", "Петрович", "Санкт-Петербург", "5678-9012-3456-7890", 500, 200, 30, 10));
        phoneList.add(new Phone(3, "Сидоров", "Сидор", "Сидорович", "Киев", "9876-5432-1098-7654", 300, 100, 70, 5));

        System.out.println("Абоненты с временем внутригородских разговоров больше 40 минут:");
        for (Phone phone : phoneList) {
            if (phone.getLocalCallsTime() > 40) {
                System.out.println(phone);
            }
        }

        System.out.println("Абоненты, использующие междугороднюю связь:");
        for (Phone phone : phoneList) {
            if (phone.getInternationalCallsTime() > 0) {
                System.out.println(phone);
            }
        }

        Collections.sort(phoneList, new Comparator<Phone>() {
            @Override
            public int compare(Phone p1, Phone p2) {
                return p1.toString().compareToIgnoreCase(p2.toString());
            }
        });

        System.out.println("Абоненты в алфавитном порядке:");
        for (Phone phone : phoneList) {
            System.out.println(phone);
        }
    }
}
