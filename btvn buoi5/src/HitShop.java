import java.util.Scanner;
public class HitShop {

    private static final Customer currentCustomer =
            new Customer("C01", "Linh Nguyễn", "0900000001");
    private static ProductService productService = new ProductServiceImpl();
    private static OrderService orderService = new OrderServiceImpl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product p1 = new GeneralProduct("P01", "Áo thun", 150000, 20);
        Product p2 = new GeneralProduct("P01", "Áo thun mới", 160000, 10);

        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());
        int choice;

        do {
            System.out.println("====== HITSHOP - QUẢN LÝ ĐƠN HÀNG ======");
            System.out.println("1. Thêm mặt hàng");
            System.out.println("2. Xem danh sách đơn hàng");
            System.out.println("3. Sửa đơn hàng theo ID");
            System.out.println("4. Xóa đơn hàng theo ID");
            System.out.println("5. Kiểm tra sản phẩm có đắt không");
            System.out.println("6. Thanh toán đơn hàng");
            System.out.println("0. Thoát");
            System.out.println("==================");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addOrder(sc);
                    break;

                case 2:
                    orderService.printOrders();
                    break;

                case 3:
                    System.out.print("Nhập ID đơn hàng cần sửa: ");
                    String suaID = sc.nextLine();
                    orderService.updateOrder(suaID);
                    break;

                case 4:
                    System.out.print("Nhập ID đơn hàng cần xóa: ");
                    String xoaID = sc.nextLine();
                    orderService.deleteOrder(xoaID);
                    break;

                case 5:
                    checkExpensive(sc);
                    break;
                case 6:
                    payment(sc);
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
            product = new GeneralProduct(id, name, price, stock);

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
            System.out.println("Số lượng mua không hợp lệ.");
            return;
        }
        Order order = new Order(currentCustomer, product, quantity);
        productService.addProduct(product);
        orderService.addOrder(order);
        System.out.println("Thêm đơn hàng thành công!");
    }

    static void checkExpensive(Scanner sc) {
        System.out.print("Nhập ID sản phẩm cần kiểm tra: ");
        String id = sc.nextLine();

        Product product = productService.findById(id);
        if (product != null) {
            if (product.isExpensive()) {
                System.out.println("Sản phẩm đắt.");
            } else {
                System.out.println("Sản phẩm không đắt.");
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }
    static void payment(Scanner sc){
        System.out.print("Nhập ID đơn hàng cần thanh toán: ");
        String orderId = sc.nextLine();

        System.out.println("1. MoMo");
        System.out.println("2. HITBank");
        System.out.print("Chọn phương thức thanh toán: ");

        int choice = Integer.parseInt(sc.nextLine());
        PaymentService paymentService;

        if (choice == 1) {
            paymentService = new MoMoPaymentService();
        } else if (choice == 2) {
            paymentService = new BankPaymentService();
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }
        paymentService.pay(orderId);
    }
}


