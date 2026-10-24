import java.util.Scanner;

    public class HitShop {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String tenMH=sc.nextLine();
            double donGia=sc.nextDouble();
            int soLuong= sc.nextInt();

            System.out.println("Ten mat hang :"+tenMH);
            System.out.println("Don gia      :"+donGia);
            System.out.println("So luong     :"+soLuong);

            double thanhTien = donGia*soLuong;
            System.out.println("Thanh tien   :"+thanhTien);

            double VAT_RATE = 0.10;
            double SHIPPING_FEE=20000;
            double tongTT = thanhTien + thanhTien*VAT_RATE + SHIPPING_FEE;
            System.out.println("Tong thanh toan la: "+tongTT);

        }
    }

