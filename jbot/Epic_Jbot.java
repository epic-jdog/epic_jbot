package jbot;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.managers.ListenerManager;


public class Epic_Jbot {

	
	public static void main(String[] args) throws Exception {
		PircBotX bot = new PircBotX();
		bot.setName("epic_jbot");
		bot.setVerbose(true);
		bot.getListenerManager().addListener(new BasicListen());
		bot.getListenerManager().addListener(new ChannelJoin());
		
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
	
}
