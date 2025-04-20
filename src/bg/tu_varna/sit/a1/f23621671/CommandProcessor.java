package bg.tu_varna.sit.a1.f23621671;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Commands.*;
import bg.tu_varna.sit.a1.f23621671.Users.User;

import java.io.IOException;
import java.util.*;

public class CommandProcessor {
    public static ArrayList<Book> books = new ArrayList<>();
    public static User currentUser=null;
    public static String currentFile="";
    public static StringBuilder content=new StringBuilder();
    private static final Map<String, Command> commandMap=new HashMap<>();
    static {
        commandMap.put("exit",new ExitCommand());
        commandMap.put("open",new OpenCommand());
        commandMap.put("close",new CloseCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("saveas", new SaveAsCommand());
        commandMap.put("help", new HelpCommand());
        commandMap.put("login",new LoginCommand());
        commandMap.put("logout",new LogoutCommand());
        commandMap.put("booksall",new BooksAllCommand());
        commandMap.put("booksinfo",new BooksInfo());
        commandMap.put("booksfind",new BooksFindCommand());
        commandMap.put("bookssort",new BooksSortCommand());
        commandMap.put("usersadd",new UsersAddCommand());
        commandMap.put("usersremove",new UsersRemoveCommand());
    }

    public static void run() {
        System.out.print ("> ");
        Scanner command= new Scanner(System.in);
        String[] commandTokens = command.nextLine().toLowerCase().split(" ",2);

        Command cmnd= commandMap.get(commandTokens[0]);
        if(cmnd!=null){
            cmnd.runCommand(commandTokens.length > 1 ? commandTokens[1] : "");
            run();
        }
        else{
            System.out.println("No such command!");
            run();
        }
    }
    public static Set<Map.Entry<String, Command>> getCommandEntries() {
        return Collections.unmodifiableSet(commandMap.entrySet());
    }
}
