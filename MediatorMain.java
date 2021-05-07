public class MediatorMain {


    public static void main(String[] args) {
        MessageMediator chat = new Chat();

        User user1 = new ChatUser(chat, "Ivan");
        User user2 = new ChatUser(chat, "Petar");
        User user3 = new ChatUser(chat, "Maria");

        user3.send("Hi, guys");
        user3.send("addBot");
        user3.send("cat");

    }
}
