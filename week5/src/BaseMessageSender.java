public abstract class BaseMessageSender implements MessageSender {
    private String senderName;

    public BaseMessageSender(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderName() {
        return senderName;
    }
}
