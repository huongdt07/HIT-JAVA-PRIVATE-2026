package src;

import src.model.Product;
import src.model.Book;
import src.model.Cake;
import src.model.Customer;
import src.model.Order;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class HitShop {

    private static final Customer currentCustomer =
            new Customer("C01", "Linh Nguyễn", "0900000001");

    private static final List<Order> orders = new ArrayList<>();
    private static final List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== MENU ======");
            System.out.println("1. Thêm mặt hàng");
            System.out.println("2. Xóa mặt hàng");
            System.out.println("3. Xem giỏ hàng");
            System.out.println("4. Xem tổng tiền");
            System.out.println("5. Kiểm tra sản phẩm có đắt không");
            System.out.println("0. Thoát");
            System.out.println("==================");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addOrder(sc);
                    break;

                case 2:
                    if (orders.isEmpty()) {
                        System.out.println("Không tìm thấy mặt hàng.");
                        break;
                    }

                    System.out.print("Nhập STT cần xóa: ");
                    int displayNumber = Integer.parseInt(sc.nextLine());
                    removeOrder(displayNumber - 1);
                    break;

                case 3:
                    printOrders();
                    break;

                case 4:
                    System.out.println("Tổng tiền: " + calculateTotal());
                    break;

                case 5:
                    checkExpensive(sc);
                    break;

                case 0:
                    System.out.println("Kết thúc.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (choice != 0);

        sc.close();
    }

    static void addOrder(Scanner sc) {
        System.out.println("=== Chọn loại sản phẩm ===");
        System.out.println("1. Product - Sản phẩm thông thường");
        System.out.println("2. Book - Sách");
        System.out.println("3. Cake - Bánh");
        System.out.print("Lựa chọn: ");

        int type = Integer.parseInt(sc.nextLine());

        if (type < 1 || type > 3) {
            System.out.println("Loại sản phẩm không hợp lệ.");
            return;
        }

        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();

        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập tồn kho: ");
        int stock = Integer.parseInt(sc.nextLine());

        Product product = null;

        if (type == 1) {
            product = new Product(id, name, price, stock);

        } else if (type == 2) {
            System.out.print("Nhập tên tác giả: ");
            String author = sc.nextLine();

            product = new Book(id, name, price, stock, author);

        } else if (type == 3) {
            System.out.print("Nhập thương hiệu: ");
            String brand = sc.nextLine();

            product = new Cake(id, name, price, stock, brand);
        }

        System.out.print("Nhập số lượng mua: ");
        int quantity = Integer.parseInt(sc.nextLine());

        if (quantity <= 0) {
            System.out.println("Số lượng phải lớn hơn 0.");
            return;
        }

        Order order = new Order(currentCustomer, product, quantity);

        products.add(product);
        orders.add(order);

        System.out.println("Thêm đơn hàng thành công!");
    }

    static void removeOrder(int index) {
        if (index < 0 || index >= orders.size()) {
            System.out.println("Không tìm thấy mặt hàng.");
            return;
        }

        Product product = orders.get(index).getProduct();

        orders.remove(index);
        products.remove(product);

        System.out.println("Xóa mặt hàng thành công!");
    }

    static void printOrders() {
        System.out.println("Khách hàng: " + currentCustomer);

        if (orders.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
            return;
        }

        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". " + orders.get(i));
        }
    }

    static double calculateTotal() {
        double total = 0;

        for (int i = 0; i < orders.size(); i++) {
            total += orders.get(i).getTotal();
        }

        return total;
    }

    static void checkExpensive(Scanner sc) {
        System.out.print("Nhập ID sản phẩm cần kiểm tra: ");
        String id = sc.nextLine();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            if (product.getId().equalsIgnoreCase(id)) {

                if (product.isExpensive()) {
                    System.out.println("Sản phẩm đắt.");
                } else {
                    System.out.println("Sản phẩm không đắt.");
                }

                return;
            }
        }

        System.out.println("Không tìm thấy sản phẩm.");
    }
}

