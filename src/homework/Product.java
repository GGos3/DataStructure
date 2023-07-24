package homework;

import java.util.Scanner;

public class Product {
    private int id;
    private String desc;
    private String producer;
    private int price;
    private static final Scanner sc = new Scanner(System.in);

    public Product(int id, String desc, String producer, int price) {
        this.id = id;
        this.desc = desc;
        this.producer = producer;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getProducer() {
        return producer;
    }

    public int getPrice() {
        return price;
    }


    static Product constructor(int i) {
        System.out.print("상품ID >> ");
        int id = sc.nextInt();

        System.out.print("상품 설명 >> ");
        String desc = sc.next();

        System.out.print("생산자 >> ");
        String producer = sc.next();

        System.out.print("가격 >> ");
        int price = sc.nextInt();

        Product product = new Product(id, desc, producer, price);

        return switch (i) {
            case 1 -> Book.constructor(product);
            case 2 -> CompactDisc.constructor(product);
            case 3 -> ConversationBook.constructor(Book.constructor(product));
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }

    void print() {
        System.out.println("상품ID >> " + this.id);
        System.out.println("상품 설명 >> " + this.desc);
        System.out.println("생산자 >> " + this.producer);
        System.out.println("가격 >> " + this.price);
    }
}
