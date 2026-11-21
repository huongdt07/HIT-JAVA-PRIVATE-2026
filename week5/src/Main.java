//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void notifyUser(MessageSender sender, String message) {
        System.out.println(sender.send(message));
    }

    public static void main(String[] args) {
       notifyUser(new SmsSender(),"33564");
       notifyUser(new EmailSender(),"huong@gmail.com");
    }
}