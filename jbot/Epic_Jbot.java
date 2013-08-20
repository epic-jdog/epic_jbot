package jbot;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.managers.ListenerManager;


public class Epic_Jbot {

    private PircBotX bot;

    public static void main(String[] args) {
        Epic_Jbot me = new Epic_Jbot();
        me.start(args);
    }

    private void start(String[] args) {
        bot = new PircBotX();
        bot.setName("epic_jbot");
        bot.setVerbose(true);
        bot.getListenerManager().addListener(new BasicListen(this));
        bot.getListenerManager().addListener(new ChannelJoin(this));
        bot.getListenerManager().addListener(new PMListen(this));
        //bot.getListenerManager().addListener(new ConsoleCommands());

        try {
            bot.connect("irc.esper.net");
            bot.joinChannel("#p_slice");
            bot.setAutoNickChange(true);
            bot.setLogin("vlee");
            bot.setName("Vlee");

        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("IT DONE GOOFT ON JOINING!");
        }
    }

    public PircBotX getBot() {
        return bot;
    }
}
