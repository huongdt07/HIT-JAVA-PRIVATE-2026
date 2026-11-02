import java.util.ArrayList;
import java.util.Scanner;

public class HitShop {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("======    MENU    ======");
            printMenu();
            System.out.println("========================");
            System.out.print("Chọn: ");

            if (!sc.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {

                    String productName;
                    do {
                        System.out.print("Tên mặt hàng: ");
                        productName = sc.nextLine().trim();
                    } while (productName.isEmpty());

                    double unitPrice;
                    do {
                        System.out.print("Đơn giá: ");
                        while (!sc.hasNextDouble()) {
                            System.out.print("Vui lòng nhập số hợp lệ: ");
                            sc.next();
                        }
                        unitPrice = sc.nextDouble();
                    } while (unitPrice <= 0);

                    int quantity;
                    do {
                        System.out.print("Số lượng: ");
                        while (!sc.hasNextInt()) {
                            System.out.print("Vui lòng nhập số nguyên hợp lệ: ");
                            sc.next();
                        }
                        quantity = sc.nextInt();
                    } while (quantity <= 0);

                    sc.nextLine();
                    addItem(productName, unitPrice, quantity);
                    System.out.println("Thêm mặt hàng thành công!");
                }

                case 2 -> {
                    System.out.print("Nhập stt cần xóa: ");
                    if (sc.hasNextInt()) {
                        int stt = sc.nextInt();
                        sc.nextLine();
                        removeItem(stt - 1);
                    } else {
                        System.out.println("Không tìm thấy mặt hàng.");
                        sc.nextLine();
                    }
                }

                case 3 -> printItems();

                case 4 -> {
                    double subtotal = calculateTotal();
                    double VAT = names.isEmpty() ? 0 : subtotal * 0.10;
                    double shippingFee = names.isEmpty() ? 0 : 20000;
                    double thanhTien = subtotal + VAT + shippingFee;

                    System.out.printf("Tiền hàng: %,.0f\n", subtotal);
                    System.out.printf("VAT (10%%): %,.0f\n", VAT);
                    System.out.printf("Phí vận chuyển: %,.0f\n", shippingFee);
                    System.out.printf("Tổng thanh toán: %,.0f\n", thanhTien);
                }

                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
        sc.close();
    }

    //hien thi menu
    static void printMenu() {
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa theo số thứ tự");
        System.out.println("3. Xem danh sách mặt hàng");
        System.out.println("4. Xem tổng tiền");
        System.out.println("0. Kết thúc");
    }

    //them mh
    static void addItem(String name, double price, int quantity) {
        names.add(name);
        prices.add(price);
        quantities.add(quantity);
    }

    //xoa mh
    static void removeItem(int index) {
        if (index >= 0 && index < names.size()) {
            names.remove(index);
            prices.remove(index);
            quantities.remove(index);
            System.out.println("Đã xóa mặt hàng.");
        } else {
            System.out.println("Không tìm thấy mặt hàng!");
        }
    }

    //xem ds mh
    static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Giỏ hàng rỗng.");
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println(
                    (i + 1) + " - Tên: " + names.get(i)
                            + " - Giá: " + prices.get(i)
                            + " - SL: " + quantities.get(i)
            );
        }
    }

    // tinh tt
    static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }
        return total;
    }
}
