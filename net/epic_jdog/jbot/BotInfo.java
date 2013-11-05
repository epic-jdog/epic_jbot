
/**
 * Created by James Ward (epic_jdog)
 *
 * Date: 02/11/13
 * Time: 5:50 PM
 *
 *
 */
package net.epic_jdog.jbot;

import org.pircbotx.PircBotX;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class BotInfo {
    private static PircBotX bot = Epic_Jbot.mecha_jdog;

    public static String BotInfo(String item, boolean exact) throws IOException {
        int linenumber = 1;
        switch (item) {

            case "password": { //Not making this work from irc, so I don't accidentally have it blurt out my password in front of everyone :)
                linenumber = 2;
                break;
            }

            case "test": {
                linenumber = 3;
                break;
            }
            case "login": {
                linenumber = 4;
                break;
            }
            case "42": {
                linenumber = 5;
                break;
            }
            case "network": {
                linenumber = 6;
                break;
            }
            case "DEFAULT": {
                bot.sendMessage("#epic_jdog", "Usage: !jbot botinfo <what you want>");

            }
        }

        String info = "nope";
        String path = "E:\\Root\\botinfo.txt";
        Scanner s = new Scanner(new FileReader(path));


        if (s.hasNext()) {
            for (int i = 0; i <= linenumber - 1; i++) {
                //bot.sendMessage("#epic_jdog", s.nextLine());

                if (!exact) {
                    info = "Line " + linenumber + ": " + s.nextLine();
                } else {
                    info = s.nextLine().toString();
                }
            }
        }

        s.close();

        return info;

    }

    public static String BotInfo2(String item, boolean exact) throws IOException {
        int linenumber = 1;
        switch (item) {

            case "test": {
                linenumber = 3;
                break;
            }
            case "login": {
                linenumber = 4;
                break;
            }
            case "42": {
                linenumber = 5;
                break;
            }
            case "network": {
                linenumber = 6;
                break;
            }
            case "DEFAULT": {
                bot.sendMessage("#epic_jdog", "Usage: !jbot botinfo <what you want>");

            }
        }

        String info = "nope";
        String path = "E:\\Root\\botinfo.txt";
        Scanner s = new Scanner(new FileReader(path));


        if (s.hasNext()) {
            for (int i = 0; i <= linenumber - 1; i++) {
                //bot.sendMessage("#epic_jdog", s.nextLine());

                if (!exact) {
                    info = "Line " + linenumber + ": " + s.nextLine();
                } else {
                    info = s.nextLine().toString();
                }
            }
        }

        s.close();

        return info;

    }


}
