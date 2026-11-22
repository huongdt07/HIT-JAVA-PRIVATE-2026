public class MoMoPaymentService implements PaymentService{
    @Override
    public String pay(String orderId) {
        return "Đơn hàng O01 của bạn đã được thanh toán thành công qua MoMo." + orderId;
    }
}
