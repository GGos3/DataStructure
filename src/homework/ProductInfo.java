package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductInfo {
    private final List<Product> productList = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ProductInfo app = new ProductInfo();
        app.run();
    }

    public void run() {
        while (true) {
            System.out.print("상품 추가 <1>, 모든 상품 조회 <2>, 끝내기 <3> >> ");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> addProduct();
                case 2 -> getProduct();
                case 3 -> {
                    System.out.println("종료합니다.");
                    throw new RuntimeException("종료");
                }
            }
        }
    }

    private void addProduct() {
        System.out.print("상품 종류 책 <1>, 음악CD <2>, 회화책 <3> >> ");
        switch (sc.nextInt()) {
            case 1 -> productList.add(Product.constructor(1));
            case 2 -> productList.add(Product.constructor(2));
            case 3 -> productList.add(Product.constructor(3));
            default -> System.out.println("잘못된 입력입니다.");
        }
    }

    private void getProduct() {
        productList.forEach(Product::print);
    }
}