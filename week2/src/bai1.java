import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bai1 {
    static final List<String> names = new ArrayList<>();
    static final List<Double> prices = new ArrayList<>();
    static final List<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do{
            System.out.println("-----   MENU   -----");
            printMenu();
            System.out.println("====================");
            System.out.println("Chon: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addItem(sc);
                    break;
                case 2:
                    System.out.print("Nhap so thu tu can xoa: ");
                    int displayNumber = Integer.parseInt(sc.nextLine());
                    charge(displayNumber);
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tong tien: " + calculateTotal());
                    break;
                case 0:
                    System.out.println("Ket thuc.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }while(choice !=0);
    }
    static void printMenu() {
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("0. Thoát");
    }
    static void addItem(String name, double price, int quantity) {
        names.add(name);
        prices.add(price);
        quantities.add(quantity);
    }
    static void addItem(Scanner sc) {
        System.out.print("Nhap ten hang: ");
        String name = sc.nextLine();

        System.out.print("Nhap don gia: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());

        addItem(name, price, quantity);
    }

    static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            double lineTotal = prices.get(i) * quantities.get(i);
            System.out.printf("%d. %s | %.1f | SL: %d | Thành tiền: %.1f%n",
                    i + 1,
                    names.get(i),
                    prices.get(i),
                    quantities.get(i),
                    lineTotal);
        }
    }
    static void removeItem(int index){
        if(index<0||index>=names.size()){
            System.out.println("Khong tim thay mat hang");
            return;
        }
        names.remove(index);
        prices.remove(index);
        quantities.remove(index);
    }
    static void charge( int displayNumber){
        int index = displayNumber -1;
        removeItem(index);
    }
    static double calculateTotal() {
        double tong = 0;
        for (int i = 0; i < names.size(); i++) {
            tong += prices.get(i) * quantities.get(i);
        }
        return tong;
    }

}

