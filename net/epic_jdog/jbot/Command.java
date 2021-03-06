/**
 * Created by James Ward (epic_jdog)
 *
 * Date: 02/11/13
 * Time: 5:50 PM
 *
 *
 */
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
                case "vleebot": {
                    VleeBot.init();
                    break;
                }

                case "readln": {
                    try {
                        bot.sendMessage(chan, TextRead.ReadLine((Integer.parseInt(param1)), param2, false));
                    } catch (Exception ex) {
                        bot.sendMessage(chan, "Invalid Line number or filename! Usage: !jbot readln <linenumber> <file>");
                    }

                    break;
                }
                case "readfile": {
                    try {
                        String[] meh = TextRead.getWholeFile(param1);
                        String mehh = "v";
                        for (int q = 0; q < meh.length; q++){
                        mehh = "" + mehh + meh[q];
                        }
                        bot.sendMessage(chan, mehh);
                    } catch (Exception ex) {
                        bot.sendMessage(chan, "Invalid Line number or filename! Usage: !jbot readln <linenumber> <file>");
                    }

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
                    System.out.println("Attempting to kick '" + param1 +"'");
                    bot.kick(chan, bot.getUser(param1), param2);
                    break;
                }
                case "read2": {

                    if (param2.equals("exact")) {
                        bot.sendMessage(chan, BotInfo.BotInfo2(param1, true));
                    } else {
                        bot.sendMessage(chan, BotInfo.BotInfo2(param1, false));
                    }

                    break;
                }
                case "filelength": {
                    bot.sendMessage(chan, ("Length of " + param1 + " : " + TextRead.getFileLength(param1)));
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
                case "isbotoperator": {
                    Authorization a = new Authorization();
                    if (a.isOperator(param1)) {
                        bot.sendMessage(chan, "Yes, yes quite.");
                    } else {
                        bot.sendMessage(chan, "Nah m8.");
                    }

                    break;
                }
                case "istrusted": {
                    Authorization a = new Authorization();
                    if (a.isTrusted(param1)) {
                        bot.sendMessage(chan, "Yes, yes quite.");
                    } else {
                        bot.sendMessage(chan, "Nah m8.");
                    }

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
                default: {
                }
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
            case "ping": {
                bot.sendMessage(chan, "pong?!");

                break;
            }
            case "time": {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                String currenttime = sdf.format(calendar.getTime());
                bot.sendMessage(chan, "It's currently " + currenttime + " PST.");

                break;
            }
            case "quadratic": {
                JbotMath j = new JbotMath();;
                bot.sendMessage(chan, j.solveQuadratic(param1));
                break;
            }
            case "solverekkyn": {
                JbotMath j = new JbotMath();;
                bot.sendMessage(chan, j.rekkyncalculate(param1));
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


            default: {
            }

        }

    }


}

