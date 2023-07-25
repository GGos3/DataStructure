package homework;

import java.util.Scanner;

public class CompactDisc extends Product {
    private String albumName;
    private String singer;
    private static final Scanner sc = new Scanner(System.in);

    public CompactDisc(int id, String desc, String producer, int price, String albumName, String singer) {
        super(id, desc, producer, price);
        this.albumName = albumName;
        this.singer = singer;
    }

    static CompactDisc constructor(Product product) {

        System.out.print("엘범 제목 >> ");
        String albumName = sc.next();

        System.out.print("가수 >> ");
        String singer = sc.next();

        return new CompactDisc(
                product.getId(),
                product.getDesc(),
                product.getProducer(),
                product.getPrice(),
                albumName,
                singer
        );
    }

    void print() {
        super.print();
        System.out.println("엘범 제목 >> " + this.albumName);
        System.out.println("가수 >> " + this.singer);
    }
}
