import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneService {

    private final Map<Long, Phone> phoneMap = new HashMap<>();
    private Long sequence = 0L;
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PhoneService app = new PhoneService();
        app.run();
    }

    void run() {
        while (true) {
            System.out.print("삽입:0, 삭제:1, 찾기:2, 전체보기:3, 종료:4 >> ");
            switch (sc.nextInt()) {
                case 0 -> savePhone();
                case 1 -> deletePhone();
                case 2 -> print(findKeyByName());
                case 3 -> printAllPhone();
                case 4 -> throw new RuntimeException("종료");
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    void savePhone() {
        System.out.print("이름 >> ");
        String name = sc.next();

        System.out.print("주소 >> ");
        String address = sc.next();

        System.out.print("전화번호 >> ");
        String phoneNumber = sc.next();

        if (!validatePhoneNumber(phoneNumber)) {
            phoneMap.put(sequence, new Phone(name, address, phoneNumber));
            sequence++;
        } else
            System.out.println("이미 존재하는 전화번호 입니다.");
    }

    boolean validatePhoneNumber(String phoneNumber) {
        return phoneMap.entrySet().stream()
                .anyMatch(phone -> phone.getValue().phoneNumber().equals(phoneNumber));
    }

    void deletePhone() {
        phoneMap.remove(findKeyByName());
    }

    Long findKeyByName() {
        System.out.print("이름 >> ");
        String name = sc.nextLine();

        return phoneMap.entrySet().stream()
                .filter(it -> it.getValue().name().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getKey();
    }

    void printAllPhone() {
        phoneMap.forEach((sequence, phone) ->
                print(sequence));
    }


    void print(Long sequence) {
        Phone phone = phoneMap.get(sequence);

        System.out.println("이름 >> " + phone.name());
        System.out.println("주소 >> " + phone.address());
        System.out.println("전화번호 >> " + phone.phoneNumber());
    }
}

record Phone(
        String name,
        String address,
        String phoneNumber
) {
}