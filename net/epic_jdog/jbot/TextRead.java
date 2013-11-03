
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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TextRead {


    public int linenumber = -1;
    public boolean exact = true;
    public static String result = "No Content Found";
    private static PircBotX bot = Epic_Jbot.mecha_jdog;


    public static String WriteFile(String fileee, String item) {
        return "File written.";
    }

    public static String ReadLine(int line, String file, boolean exact) {
        String path = "E:\\Root\\" + file + ".txt";
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.err.println("NOW THAT FILE CAN'T BE FOUND MATE");
            e.printStackTrace();
            s.close();
            return "Error: File Not Found By Reader";
        }

        if (s.hasNext()) {
            for (int i = 0; i <= line - 1; i++) {
                //bot.sendMessage("#epic_jdog", s.nextLine());
                if (s.hasNextLine()) {
                    result = !exact ? "Line " + line + ": " + s.nextLine() : s.nextLine().toString();
                } else {
                    return ("File does not contain line " + line);
                }
            }
        }
        s.close();
        return result;

    }


    public static int getFileLength(String file) {
        String path = "E:\\Root\\" + file + ".txt";
        Scanner s = null;
        int lines = 0;
        try {
            s = new Scanner(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.err.println("NOW THAT FILE CAN'T BE FOUND MATE");
            e.printStackTrace();
            s.close();
            return 0;
        }

        for (; ; ) {
            if (s.hasNextLine()) {
                lines++;
                s.nextLine();
            } else {
                s.close();
                return lines;
            }


        }
    }


    public static String[] getWholeFile(String file) {
        String path = "E:\\Root\\" + file + ".txt";
        int integer = getFileLength(file);
        String[] contents = new String[integer];
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.err.println("NOW THAT FILE CAN'T BE FOUND MATE");
            e.printStackTrace();
            s.close();
            contents[0] = "No File found";
            return contents;
        }

        if (s.hasNext()) {
            for (int i = 0; i < integer; i++) {


                if (s.hasNextLine()) {
                    contents[i] = s.nextLine().toString();
                    s.nextLine();
                } else {
                    s.close();
                    return contents;
                }
            }

        }
        contents[0] = "File Empty";
        return contents;
    }

    public static boolean FileContains(String query, String file) {

        String path = "E:\\Root\\" + file + ".txt";
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.err.println("NOW THAT FILE CAN'T BE FOUND MATE");
            e.printStackTrace();
            s.close();
            return false;
        }

        s.reset();

        for (; ; ) {
            if (s.hasNext(query)) {
                s.close();
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