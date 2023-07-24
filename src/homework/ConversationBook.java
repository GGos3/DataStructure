package homework;

import java.util.Scanner;

public class ConversationBook extends Book{
    private String language;
    private static final Scanner sc = new Scanner(System.in);

    public ConversationBook(int id, String desc, String producer, int price, String author, String bookName, int ISBN, String language) {
        super(id, desc, producer, price, ISBN, author, bookName);
        this.language = language;
    }

    static ConversationBook constructor(Book book) {

        System.out.print("언어 >> ");
        String language = sc.next();

        return new ConversationBook(
                book.getId(),
                book.getDesc(),
                book.getProducer(),
                book.getPrice(),
                book.getAuthor(),
                book.getBookName(),
                book.getISBN(),
                language
        );
    }

    void print() {
        super.print();
        System.out.print("언어 >> " + this.language);
    }
}
