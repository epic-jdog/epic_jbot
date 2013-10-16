package jbot;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;

public class Command {
	public String commandname = "empty";
	public String param1 = "DEFAULT";
	public String param2 = "DEFAULT";
	public String nick = "DEFAULT";
	public User sender = null;
	public boolean authorized = false;
	public Channel chan = null;
	private PircBotX bot = Epic_Jbot.mecha_jdog;

	public Command(String commandname, String param1, String param2,
			User sender, String nick, Channel chan, boolean authorized) {
		this.commandname = commandname;
		this.param1 = param1;
		this.param2 = param2;
		this.sender = sender;
		this.nick = nick;
		this.chan = chan;
		this.authorized = authorized;
	}

	public final void main() throws Exception {

		if (authorized == true) {

			switch (commandname) { //commands available only if have perms (currently, that is, being me)

			case "disconnect": {
				bot.disconnect();
			}

			case "join": {
				bot.joinChannel(param1);
			}

			case "leave": {
				if (chan.toString().equals("DEFAULT")) {
					bot.partChannel(chan);
				} else {
					bot.partChannel(bot.getChannel(param1));
				}

			}

			case "kick": {
				System.out.println("Attempting to kick '" + nick
						+ "' please stand by.");
				bot.kick(chan, sender, param1);
			}

			case "selfop": {
				bot.sendMessage(chan, "!op");
			}

			case "nick": {
				bot.changeNick(param1);
			}

			case "verbose": {
				if (param1.equals("on"))
					Epic_Jbot.mecha_jdog.setVerbose(true);
				if (param1.equals("off"))
					Epic_Jbot.mecha_jdog.setVerbose(false);

			}

			case "reconnect": {
				bot.reconnect();
			}

			case "DEFAULT": {
				bot.sendMessage(chan, "Command not recognized. Do !jbot commands");
				
			}
			default: {
			
			bot.sendMessage(chan, "Error somewhere: Command not recognized. Do !jbot commands");
			
			}

			switch (commandname) {  //these commands are for everyone

			case "uptime": {
				RuntimeMXBean rtime = ManagementFactory.getRuntimeMXBean();
				long uptimelong = rtime.getUptime();
				String uptime = String.valueOf(uptimelong);
				bot.sendMessage(chan, "Current uptime (In milliseconds): "
						+ uptime);

			}
			case "time": {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				String currenttime = sdf.format(calendar.getTime());
				bot.sendMessage(chan, "It's currently " + currenttime + " PST.");
			}
			case "testmsg2": {
				TextRead t = new TextRead();
				t.TestTalk2();
			}
			case "read": {
				String a = "None Yet";
				String b = "None Yet";
				if (param1.equals("DEFAULT") || (param2.equals("DEFAULT"))) {
					System.out.println("NOOB");
					a = "None Yet";
					b = "None Yet";
					bot.sendMessage(chan, "Usage: !jbot read filename itemname");
				} else {
					a = param1;
					b = param2;
					bot.sendMessage(chan, TextRead.ReadFile(a, (b)));
				}
			}
			
			/** case "write":{
			
				String a = "None Yet";
				String b = "None Yet";
			
				System.out.println(parts.length);
				if (param1.equals("DEFAULT") || (param2.equals("DEFAULT"))) {
				System.out.println("NOOB");
				a = "None Yet";
				b = "None Yet";
				bot.sendMessage(chan, "Usage: !jbot write filename itemname");
				} else {
				a = param1;
				b = param2;
				bot.sendMessage((event.getChannel()),TextRead.WriteFile(a, (b)));
				}
			}
		 **/
			
			
			default: {
				bot.sendMessage(chan, "What sort of command is that?! !jbot commands");
			}
			
			}

		}
		}

	}
}
