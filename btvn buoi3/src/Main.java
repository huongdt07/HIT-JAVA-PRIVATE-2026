import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tên mặt hàng: ");
        String productName = sc.nextLine();

        System.out.print("Đơn giá: ");
        double unitPrice = sc.nextDouble();

        System.out.print("Số lượng: ");
        int quantity = sc.nextInt();

        double subtotal = unitPrice * quantity;
        double VAT_RATE = 0.10;
        double shippingFee = 20000;
        System.out.println("=======================");
        System.out.println("Tên mặt hàng: " + productName);
        System.out.println("Đơn giá: " + unitPrice);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Thành tiền: " + subtotal + (subtotal * VAT_RATE) + shippingFee);

        sc.close();
    }
}