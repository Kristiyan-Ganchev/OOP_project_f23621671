package bg.tu_varna.sit.a1.f23621671;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Commands.*;
import bg.tu_varna.sit.a1.f23621671.Users.User;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class CommandProcessor {
    public static ArrayList<Book> books = new ArrayList<>();
    public static User currentUser=null;
    public static String currentFile="";
    private static final Map<CommandEnums, Command> commandMap=new HashMap<>();
    static {
        commandMap.put(CommandEnums.EXIT,new ExitCommand());
        commandMap.put(CommandEnums.OPEN, new OpenCommand());
        commandMap.put(CommandEnums.CLOSE, new CloseCommand());
        commandMap.put(CommandEnums.SAVE, new SaveCommand());
        commandMap.put(CommandEnums.SAVE_AS, new SaveAsCommand());
        commandMap.put(CommandEnums.HELP, new HelpCommand());
        commandMap.put(CommandEnums.LOGIN, new LoginCommand());
        commandMap.put(CommandEnums.LOGOUT, new LogoutCommand());
        commandMap.put(CommandEnums.BOOKS_ALL, new BooksAllCommand());
        commandMap.put(CommandEnums.BOOKS_INFO, new BooksInfo());
        commandMap.put(CommandEnums.BOOKS_FIND, new BooksFindCommand());
        commandMap.put(CommandEnums.BOOKS_SORT, new BooksSortCommand());
        commandMap.put(CommandEnums.BOOKS_ADD, new BooksAddCommand());
        commandMap.put(CommandEnums.BOOKS_REMOVE, new BooksRemoveCommand());
        commandMap.put(CommandEnums.USERS_ADD, new UsersAddCommand());
        commandMap.put(CommandEnums.USERS_REMOVE, new UsersRemoveCommand());
    }
    public static String toContent(){
        StringBuilder content=new StringBuilder();
        for (Book book: CommandProcessor.books) {
            content.append(book.toWrite());
        }
        if (!CommandProcessor.books.isEmpty()) {
            content.setLength(content.length() - 1);
        }
        return content.toString();
    }
    public static void run() {
        System.out.print ("> ");
        Scanner command= new Scanner(System.in);
        String input = command.nextLine().trim().toLowerCase();
        String arguments = "";
        CommandEnums commandType = null;

        for (CommandEnums type : CommandEnums.values()) {
            String cmdText = type.getCommandText();
            if (input.startsWith(cmdText)) {
                commandType = type;
                arguments = input.length() > cmdText.length()
                        ? input.substring(cmdText.length()).trim()
                        : "";
                break;
            }
        }

        if (commandType != null) {
            Command cmd = commandMap.get(commandType);
            cmd.runCommand(arguments);
        } else {
            System.out.println("No such command!");
        }
        run();
    }
    public static Set<Map.Entry<CommandEnums, Command>> getCommandEntries() {
        return Collections.unmodifiableSet(commandMap.entrySet());
    }
}
