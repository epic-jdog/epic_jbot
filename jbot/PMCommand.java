package jbot;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.pircbotx.PircBotX;


public class PMCommand {
	public String commandname = "empty";
	public String param1 = "DEFAULT";
	public String pmessage = "DEFAULT";;
	private PircBotX bot = Epic_Jbot.mecha_jdog;
	
	public String chatchannel = "#epic_jdog";

	public PMCommand(String commandname, String param1, String pmessage) {
		this.commandname = commandname;
		this.param1 = param1;
		this.pmessage = pmessage;
	}
	
	public final void exec()  throws Exception{

		if(!commandname.startsWith("!")){
			bot.sendMessage(chatchannel, pmessage);
		} else {
		
		switch (commandname) {
		
		case "!disconnect": {
			bot.disconnect();
		}

		case "!join": {
			bot.joinChannel(param1);
		}

		case "!leave": {
			
				bot.partChannel(bot.getChannel(param1));	
		}
		case "!nick": {
			bot.changeNick(param1);
		}
		case "!pmchat": {
			chatchannel = param1;
			bot.sendMessage("epic_jdog", "Target channel/nick changed to " + chatchannel);
		}
		
		}
		
		
		
		}
	}
	
	}