package net.epic_jdog.jbot;

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

	public final void exec() throws Exception {

		if (authorized == true) {

			switch (commandname) { //commands available only if have perms (currently, that is, being me)

			case "disconnect": {
				bot.disconnect();
			break;
			}

			case "join": {
				bot.joinChannel(param1);
				break;
			}

			case "leave": {
				if (chan.toString().equals("DEFAULT")) {
					bot.partChannel(chan);
				} else {
					bot.partChannel(bot.getChannel(param1));
				}
				break;
			}

			case "kick": {
				System.out.println("Attempting to kick '" + nick
						+ "' please stand by.");
				bot.kick(chan, sender, param1);
				break;
			}
			case "read2":{
				
				if (param2.equals("exact")){
				bot.sendMessage(chan, TextRead.Read2(param1, true));
				} else{
				bot.sendMessage(chan, TextRead.Read2(param1, false));	
				}
				
				break;
			}
			case "selfop": {
				bot.sendMessage(chan, "!op");
				break;
			}
			case "prefix": {
				MessageEventHandler.prefix = param1;
				bot.sendMessage(chan, "Command prefix set to '" + param1 + "'");
				break;
			}

			case "nick": {
				bot.changeNick(param1);
				break;
			}

			case "verbose": {
				if (param1.equals("on"))
					Epic_Jbot.mecha_jdog.setVerbose(true);
				if (param1.equals("off"))
					Epic_Jbot.mecha_jdog.setVerbose(false);
				break;
			}

			case "reconnect": {
				bot.reconnect();
				break;
			}

			case "DEFAULT": {
				bot.sendMessage(chan, "Command not recognized. Do !jbot commands");
				break;
			}
			default: {}
			}
		}
			switch (commandname) {  //these commands are for everyone

			case "uptime": {
				RuntimeMXBean rtime = ManagementFactory.getRuntimeMXBean();
				long uptimelong = rtime.getUptime();
				String uptime = String.valueOf(uptimelong);
				bot.sendMessage(chan, "Current uptime (In milliseconds): "
						+ uptime);
				break;
			}
			case "time": {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				String currenttime = sdf.format(calendar.getTime());
				bot.sendMessage(chan, "It's currently " + currenttime + " PST.");
			
				break;
			}
			
			
			
			case "testmsg2": {
				TextRead t = new TextRead();
			t.TestTalk2();
			
			break;
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
				break;
			}
			
			case "DEFAULT": {
			bot.sendMessage(chan, "epic_jbot command not found - do !jbot commands for help");
			break;
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
				} **/
			
		 
			
			
			default: {}
			
			}

		}
		

	}

