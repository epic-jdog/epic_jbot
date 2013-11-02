package net.epic_jdog.jbot;

import org.pircbotx.PircBotX;

public class PMCommand {
    private final PircBotX bot = Epic_Jbot.mecha_jdog;
    public String chatchannel = "#epic_jdog";
    public String commandname = "empty";
    ;
    public String param1 = "DEFAULT";

    public String pmessage = "DEFAULT";

    public PMCommand(String commandname, String param1, String pmessage) {
        this.commandname = commandname;
        this.param1 = param1;
        this.pmessage = pmessage;
    }

    public final void exec() throws Exception {

        if (commandname.startsWith("!")) {

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
                    bot.sendMessage("epic_jdog", "Target channel/nick changed to "
                            + chatchannel);
                }

            }

        } else {

            bot.sendMessage(chatchannel, pmessage);
        }
    }

}