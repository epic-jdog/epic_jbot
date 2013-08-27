package jbot;
import org.pircbotx.PircBotX;
import jbot.Epic_Jbot;

public class Epic_Jbot {

	
	public static void main(String[] args) throws Exception {
		final PircBotX bot = new PircBotX();
		bot.setName("epic_jbot");
		bot.setVerbose(true);
		bot.getListenerManager().addListener(new BasicListen());
		bot.getListenerManager().addListener(new ChannelJoin());
		bot.getListenerManager().addListener(new PMListen());
		bot.getListenerManager().addListener(new Administrative());
		
		
		//bot.getListenerManager().addListener(new ConsoleCommands());
		//ConsoleCommands.main();
		
		
		try {
		bot.connect("irc.esper.net");
		bot.joinChannel("#epic_jdog");
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
