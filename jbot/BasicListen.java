package jbot;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ActionEvent;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class BasicListen extends ListenerAdapter {
	public static boolean disconnectcommand = false;

	public static void setDiscValue(boolean disconnect) {
		disconnectcommand = disconnect; // change the value
	}

	private PircBotX bot;

	public BasicListen(PircBotX jbot) {
		bot = jbot;
	}

	@Override
	public void onAction(ActionEvent event) throws Exception {
		String firedmessage = null;
		if (event.getMessage().toLowerCase().contains("vlees")) {
			firedmessage = event.getUser().getNick() + ", you're fired.";
			bot.sendMessage(event.getChannel(), firedmessage);
		}

		if (event.getMessage().contains("runs")) {
			String strung = event.getUser().getNick().toString();
			bot.sendMessage(event.getChannel(), "Nooo, please, " + strung
					+ "! Come baaack!!!");

		}

	}

	/*
	 * @Override public void onConnect(ConnectEvent event) throws Exception {
	 * 
	 * for (;;) { Thread.sleep(100);
	 * 
	 * if (disconnectcommand == true) {
	 * 
	 * bot.disconnect();
	 * 
	 * } Thread.sleep(1000);
	 * 
	 * }
	 * 
	 * }
	 */
	@Override
	public void onMessage(MessageEvent event) throws Exception {

		String message = event.getMessage();

		try {

			if (message.startsWith("!jbot uptime")) {
				RuntimeMXBean rtime = ManagementFactory.getRuntimeMXBean();
				long uptimelong = rtime.getUptime();
				String uptime = String.valueOf(uptimelong);
				bot.sendMessage((event.getChannel()),
						"Current uptime (In milliseconds): " + uptime);

			}
			if (message.toLowerCase().contains(("vlee")))
				bot.sendMessage(event.getChannel(), "Aww.");
			
			if (message.startsWith("!jbot read")) {
				String readnameraw = event.getMessage();
				String[] parts = readnameraw.split("[ ]");
				if (TextRead.ReadFile("test", "lel") == null){
					System.out.println("DERPERPERPE");
				}
				
				String a = "None Yet";
				String b = "None Yet";
				
				System.out.println(parts.length);
				if(parts.length <= 3){
					System.out.println("NOOB");
					a = "None Yet";
					b = "None Yet";
					bot.sendMessage(event.getChannel(), "Usage: !jbot read filename itemname");
				} else {
				a = parts[2];
				b = parts[3];
				
				
				bot.sendMessage((event.getChannel()),TextRead.ReadFile(a, (b)));
				}
			}
			if (message.contains("spam"))
				bot.sendMessage((event.getChannel()),
						"Spam, spam, spam, spam, SPASPAAM!");

			if (message.equals("jbot, I KILL YOU")
					&& event.getUser().getNick().toString().equals("epic_jdog")) {
				bot.disconnect();
			}

			// if (message.equals("!jbot terrorize")
			// && event.getUser().getNick().toString().equals("epic_jdog")) {
			// Terrorize t = new Terrorize(event.getUser.getNick());
			// }

			if (message.equals("!jbot disconnect")
					&& event.getUser().getNick().toString().equals("epic_jdog"))
				bot.disconnect();

			if (message.contains("epic_jbot")) {

				if (message.startsWith("epic_jbot, pls")) {
					bot.sendMessage(event.getChannel(), "It's what I do!");
					return;
				}
				if (message.startsWith("epic_jbot pls")) {
					bot.sendMessage(event.getChannel(),
							"You got a problem with me!?!");
					return;
				}

				if (message.equals("epic_jbot, I KILL YOU")
						&& event.getUser().getNick().toString()
								.equals("epic_jdog")) {
					bot.disconnect();
					return;
				}
				if (message.equals("!jbot reconnect")
						&& event.getUser().getNick().toString()
								.equals("epic_jdog")) {
					bot.reconnect();
					return;
				}

				final Random rand = new Random();

				String[] phrases = { "Yo!",
						"That would be this fine bot right here.",
						"G'day, sirs.", "This is the jbot you're looking for!",
						"Yea Buddy!", "jbot is best bot!", "Hello, mates!" };
				final String response = phrases[rand.nextInt(phrases.length)];
				bot.sendMessage(event.getChannel(), response);

			}

			if (message.startsWith("!jbot time")) {

				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				String currenttime = sdf.format(calendar.getTime());
				bot.sendMessage(event.getChannel(), "It's currently "
						+ currenttime + " PST.");
			}

		} catch (Exception ey) {
			ey.printStackTrace();
			System.out.println("IT DONE GOOFT ON LISTENING TO CHAT!!");

		}

	}

}
