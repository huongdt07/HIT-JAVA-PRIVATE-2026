public class BankPaymentService implements PaymentService{
    @Override
    public String pay(String orderId) {
        return "Đơn hàng O01 của bạn đã được thanh toán thành công qua HITBank." + orderId;
    }
}
