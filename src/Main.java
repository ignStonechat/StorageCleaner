import java.io.File;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final File TEMP = new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp");
    public static final File DISCORD_CACHE = new File(System.getProperty("user.home") + "\\AppData\\Roaming\\discord\\Cache");
    public static final File GOOGLE_CACHE = new File(System.getProperty("user.home") + "\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cache");

    public static int files_total = 0;
    public static int files_done = 0;

//    public static float percentage = (int)(files_done / files_total) * 100;

    public static void main(String[] args) {
        System.out.println(ANSI_CYAN + "   _____ _                                _____ _                            \n" +
                "  / ____| |                              / ____| |                           \n" +
                " | (___ | |_ ___  _ __ __ _  __ _  ___  | |    | | ___  __ _ _ __   ___ _ __ \n" +
                "  \\___ \\| __/ _ \\| '__/ _` |/ _` |/ _ \\ | |    | |/ _ \\/ _` | '_ \\ / _ \\ '__|\n" +
                "  ____) | || (_) | | | (_| | (_| |  __/ | |____| |  __/ (_| | | | |  __/ |   \n" +
                " |_____/ \\__\\___/|_|  \\__,_|\\__, |\\___|  \\_____|_|\\___|\\__,_|_| |_|\\___|_|   \n" +
                "                             __/ |                                           \n" +
                "                            |___/                                            !");


//        System.out.println(ANSI_GREEN + "CLEARING" + ANSI_RESET + " 0%");



        if (TEMP.isDirectory()) {
            files_total += TEMP.listFiles().length;
            for ( File file : TEMP.listFiles()) {
                file.delete();
                files_done++;
                try {
                    if (!(files_total == files_done)) {
                        System.out.print(ANSI_GREEN + "CLEARING" + ANSI_RESET + " " + (files_done / Float.parseFloat(files_total + ".0f")) * 100 + "%\r");
                    } else {
                        System.out.print(ANSI_GREEN + "CLEARING" + ANSI_RESET + " Completed!");
                        deleteFromFolder(TEMP);
                    }
                } catch (Exception e) {}
                if (file.isDirectory()) {
                    deleteFromFolder(file);
                }
            }
        }

        if (DISCORD_CACHE.isDirectory()) {
            files_total += DISCORD_CACHE.listFiles().length;
            for ( File file : DISCORD_CACHE.listFiles()) {
                file.delete();
                files_done++;
                try {
                    if (!(files_total == files_done)) {
                        System.out.print(ANSI_GREEN + "CLEARING" + ANSI_RESET + " " + (files_done / Float.parseFloat(files_total + ".0f")) * 100 + "%\r");
                    } else {
                        System.out.print(ANSI_GREEN + "CLEARING" + ANSI_RESET + " Completed!");
                        deleteFromFolder(DISCORD_CACHE);
                    }
                } catch (Exception e) {}
                if (file.isDirectory()) {
                    deleteFromFolder(file);
                }
            }
        }

        if (GOOGLE_CACHE.isDirectory()) {
            files_total += GOOGLE_CACHE.listFiles().length;
            for ( File file : GOOGLE_CACHE.listFiles()) {
                file.delete();
                files_done++;
                try {
                    if (!(files_total == files_done)) {
                        System.out.print(ANSI_GREEN + "CLEARING" + ANSI_RESET + " " + (files_done / Float.parseFloat(files_total + ".0f")) * 100 + "%\r");
                    } else {
                        System.out.print(ANSI_GREEN + "CLEARING" + ANSI_RESET + " Completed!");
                        deleteFromFolder(GOOGLE_CACHE);
                    }
                } catch (Exception e) {}
                if (file.isDirectory()) {
                    deleteFromFolder(file);
                }
            }
        }

        System.out.println(ANSI_GREEN + "Deleted - " + ANSI_WHITE + "" + files_total + " Files");


    }

    public static void deleteFromFolder(File folder) {
        try {
            files_total += folder.listFiles().length;
            for (File file : folder.listFiles()) {
                file.delete();
                files_done++;
                try {
                    if (!(files_total == files_done)) {
                        System.out.print(ANSI_GREEN + "CLEARING" + ANSI_RESET + " " + (files_done / Float.parseFloat(files_total + ".0f")) * 100 + "%\r");
                    } else {
                        System.out.print(ANSI_GREEN + "CLEARING" + ANSI_RESET + " Completed!");
                    }
                } catch (Exception e) {
                }

                if (file.isDirectory()) {
                    deleteFromFolder(file);
                }

            }
        } catch (Exception e) {}

    }
}
