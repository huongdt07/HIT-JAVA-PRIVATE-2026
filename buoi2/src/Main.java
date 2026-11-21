
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Double> scores = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addScore() {
        int i = 1;

        while (i <= 5) {
            System.out.print("Nhap diem thu " + i + ": ");
            double diem = sc.nextDouble();

            if (diem < 0 || diem > 10) {
                System.out.println("Diem khong hop le!");
                continue;
            }

            scores.add(diem);
            i++;
        }
    }

    public static void printScores() {
        System.out.println("Danh sach diem: " + scores);
    }

    public static double calculateAverage() {
        double tong = 0;

        for (double diem : scores) {
            tong += diem;
        }

        if (scores.isEmpty()) {
            return 0;
        }

        return tong / scores.size();
    }

    public static int countPassed() {
        int dem = 0;

        for (double diem : scores) {
            if (diem >= 5) {
                dem++;
            }
        }

        return dem;
    }

    public static void main(String[] args) {
        addScore();
        printScores();

        System.out.println("Diem trung binh: " + calculateAverage());
        System.out.println("So diem dat (tu 5 tro len): " + countPassed());
    }
}
