
import java.util.ArrayList;
import java.util.Scanner;

public class HitShop {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== HITSHOP =====");
            System.out.println("1. Them mat hang");
            System.out.println("2. Xoa mat hang");
            System.out.println("3. Xem gio hang");
            System.out.println("4. Xem tong tien");
            System.out.println("0. Ket thuc");
            System.out.print("Nhap lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ten mat hang: ");
                    String name = sc.nextLine();

                    System.out.print("Nhap don gia: ");
                    double price = sc.nextDouble();

                    System.out.print("Nhap so luong: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    if (name.trim().isEmpty() || price <= 0 || quantity <= 0) {
                        System.out.println("Du lieu khong hop le!");
                    } else {
                        addItem(name, price, quantity);
                        System.out.println("Them mat hang thanh cong!");
                    }
                    break;
                case 2:
                    printItems();
                    if (!names.isEmpty()) {
                        System.out.print("Nhap so thu tu mat hang can xoa: ");
                        int stt = sc.nextInt();
                        sc.nextLine();
                        removeItem(stt - 1);
                    }
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tong tien: " + calculateTotal());
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);
    }
    //them mh
    public static void addItem(String name, double price, int quantity) {
        names.add(name);
        prices.add(price);
        quantities.add(quantity);
    }
    //xoa mh
    public static void removeItem(int index) {
        if (index >= 0 && index < names.size()) {
            names.remove(index);
            prices.remove(index);
            quantities.remove(index);
            System.out.println("Xoa mat hang thanh cong!");
        } else {
            System.out.println("Khong tim thay mat hang.");
        }
    }
    //xem ds hang
    public static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Gio hang trong!");
            return;
        }
        System.out.println("\n===== DANH SACH GIO HANG =====");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("So thu tu: " + (i + 1));
            System.out.println("Ten mat hang: " + names.get(i));
            System.out.println("Don gia: " + prices.get(i));
            System.out.println("So luong: " + quantities.get(i));
            System.out.println("--------------------------");
        }
    }
    //tinh tong
    public static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }
        return total;
    }
}
