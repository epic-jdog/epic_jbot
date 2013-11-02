package net.epic_jdog.jbot;

import org.pircbotx.PircBotX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class TextRead {

    public static String itemname = "None Yet";
    public static String filename = "None Yet";
    public int linenumber = -1;
    public boolean exact = true;
    public static String result = "No Content Found";
    private static PircBotX bot = Epic_Jbot.mecha_jdog;


    public TextRead(String filename, boolean exact) {

        this.filename = filename;
        this.exact = exact;
    }


    public static String WriteFile(String fileee, String item) {

        return "File written.";

    }


    public static String BotInfo(String item, boolean exact) throws IOException {
        int linenumber = 1;
        switch (item) {

            case "password": { //Not making this work from irc, so I don't accidently have it blurt out my password in front of everyone :)
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

                if (exact == false) {
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

        return result;

    }

    public String ReadLine(int l) {

        if (l >= 1) {
            linenumber = l;
        }
        String path = "E:\\Root\\" + filename + ".txt";
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.err.println("NOW THAT FILE CAN'T BE FOUND MATE");
            e.printStackTrace();
            return "Error: File Not Found By Reader";
        }

        if (s.hasNext() && (!(linenumber == -1))) {
            for (int i = 0; i <= linenumber - 1; i++) {
                //bot.sendMessage("#epic_jdog", s.nextLine());

                if (exact == false) {
                    result = "Line " + linenumber + ": " + s.nextLine();
                } else {
                    result = s.nextLine().toString();
                }
            }
        }

        s.close();

        return result;

    }

    public static boolean FileContains(String query, String file) {

        String path = "E:\\Root\\" + file + ".txt";
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.err.println("NOW THAT FILE CAN'T BE FOUND MATE");
            e.printStackTrace();
            return false;
        }

        s.reset();

        for (; ; ) {
            if (s.hasNext(query)) {
                return true;

            } else {
                if (!s.hasNextLine()) {
                    return false;
                }
                s.nextLine();
            }


        }
    }


}