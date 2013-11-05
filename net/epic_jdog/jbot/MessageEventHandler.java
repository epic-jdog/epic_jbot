/**
 * Created by James Ward (epic_jdog)
 *
 * Date: 02/11/13
 * Time: 5:50 PM
 *
 *
 */

package net.epic_jdog.jbot;

import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class MessageEventHandler extends ListenerAdapter {
    public static String prefix = "!jbot";

    private PircBotX bot;
    private Authorization a = new Authorization();
    private JbotMath m = new JbotMath();

    public MessageEventHandler(PircBotX jbot) {
        bot = jbot;
    }


    public void onMessage(MessageEvent event) throws Exception {

        String message = event.getMessage();


        if (message.startsWith(prefix)) {
            if (message.startsWith(prefix + " math")) {
                Channel chan = event.getChannel();
                String[] mathparts = message.split("[ ]", 3);
                //System.out.println(mathparts[2]);
                bot.sendMessage(chan, m.calculate(mathparts[2], false));
                return;
            }
            if (message.startsWith(prefix + " maath")) {
                Channel chan = event.getChannel();
                String[] mathparts = message.split("[ ]", 3);
                bot.sendMessage(chan, m.miscalculate(mathparts[2]));
                return;
            }
            Channel chan = event.getChannel();
            User u = event.getUser();
            String n = u.getNick();
            boolean authorized = false;
            if (a.isOperator(n))
                authorized = true;

            String messageraw = message;
            String[] commandparts = messageraw.split("[ ]");

            int i = commandparts.length;

            String commandname = "DEFAULT";
            String param1 = "DEFAULT";
            String param2 = "DEFAULT";

            if (i >= 4) {
                commandname = commandparts[1];
                param1 = commandparts[2];
                param2 = commandparts[3];
            }
            if (i == 3) {
                commandname = commandparts[1];
                param1 = commandparts[2];
            }
            if (i == 2) {
                commandname = commandparts[1];
            }

            Command c = new Command(commandname, param1, param2, u, n, chan, authorized);
            c.exec();

        }

    }

    public void onPrivateMessage(PrivateMessageEvent event) throws Exception {

        String pmessage = event.getMessage();
        User u = event.getUser();
        String n = u.getNick();
        if (a.isOperator(n)) {


            String delims = "[ ]";
            String[] commandparts = pmessage.split(delims);

            int i = commandparts.length;
            String commandname = "DEFAULT";
            String param1 = "DEFAULT";
            String param2 = "DEFAULT";
            if (i >= 3) {
                commandname = commandparts[1];
                param1 = commandparts[2];
            }
            if (i == 2) {
                commandname = commandparts[1];
            }

            PMCommand p = new PMCommand(commandname, param1, pmessage);
            p.exec();
        } else {
            event.respond("Hi there, I'm, epic_jdog's bot. I don't reply through here, so if you have questions about me, talk to epic_jdog if he's online. Good day, sir.");
            bot.sendMessage("epic_jdog",
                    "PM received from " + n + ": " + pmessage);
        }


    }


}
