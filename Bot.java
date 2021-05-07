public class Bot extends User{

    public static Bot chatBot = null;

    public Bot(MessageMediator mediator, String name) {
        super(mediator, name);
    }


    public static Bot getChatBot(){
        if (chatBot == null){
            chatBot = new Bot(null, "Bot");
        }
        return chatBot;
    }

    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }


    public void receive(String message) {
        System.out.println(this.name + " received: " + message);
    }

}
