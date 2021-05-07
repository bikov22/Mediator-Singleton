import java.util.ArrayList;
import java.util.List;

public class Chat implements MessageMediator {

    private List<User> users;

    private static User bot = Bot.getChatBot();

    public Chat() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.users.remove(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        if (message.equals("addBot")){
            bot.mediator = this;
            users.add(bot);
        }
        for (User chatUser : this.users) {
            if (user != chatUser){
                chatUser.receive(message);
            }
        }
        if (message.equals("cat") && users.contains(bot)){
            String removedUserName = user.name;
            users.remove(user);
            bot.send(String.format("%n'Cat' is forbidden word therefore %s was removed from the chat. " +
                    "Please don't use it otherwise you will be removed also.", removedUserName));
        }
    }
}
