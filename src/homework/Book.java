package homework;

import java.util.Scanner;

public class Book extends Product{
    private int ISBN;
    private String author;
    private String bookName;
    private static final Scanner sc = new Scanner(System.in);

    public Book(int id, String desc, String producer, int price, int ISBN, String author, String bookName) {
        super(id, desc, producer, price);
        this.ISBN = ISBN;
        this.author = author;
        this.bookName = bookName;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    static Book constructor(Product product) {

        System.out.print("책 제목 >> ");
        String bookName = sc.next();

        System.out.print("저자 >> ");
        String author = sc.next();

        System.out.print("ISBN >> ");
        int isbn = sc.nextInt();

        return new Book(
                product.getId(),
                product.getDesc(),
                product.getProducer(),
                product.getPrice(),
                isbn,
                author,
                bookName
        );
    }

    void print() {
        super.print();
        System.out.print("책 제목 >> " + this.bookName);
        System.out.print("저자 >> " + this.author);
        System.out.print("ISBN >> " + this.ISBN);
    }
}
