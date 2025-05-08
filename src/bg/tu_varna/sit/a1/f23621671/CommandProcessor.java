package bg.tu_varna.sit.a1.f23621671;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Commands.*;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;
import bg.tu_varna.sit.a1.f23621671.Users.User;

import java.util.*;

public class CommandProcessor {
    public static ArrayList<Book> books = new ArrayList<>();
    private static Set<Book> bookSet = new HashSet<>();
    private static User currentUser=new User(null,null, AccessLevel.USER);
    private static String currentFile="";
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
        commandMap.put(CommandEnums.BOOKS_INFO, new BooksInfoCommand());
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
    public static String booksToContent(){
        StringBuilder content=new StringBuilder();
        for (Book book: CommandProcessor.bookSet) {
            content.append(book.toWrite());
        }
        if (!CommandProcessor.bookSet.isEmpty()) {
            content.setLength(content.length() - 1);
        }
        return content.toString();
    }
    public static void run() {
        System.out.print("> ");
        Scanner commandLine= new Scanner(System.in);
        String input = commandLine.nextLine().trim().replaceAll("\\s+", " ").toLowerCase();
        String[] splitInput=input.trim().split("\\s+");

        String[] argumentsArr;
        CommandEnums commandType=CommandEnums.getCommandEnum(splitInput);

        if (commandType != null) {
            String cmdText=(CommandEnums.getCommandEnum(splitInput).getCommandText());
            String arguments=input.length() > cmdText.length()
                    ? input.substring(cmdText.length()).trim()
                    : "";
            Command command = commandMap.get(commandType);

            int argCount=arguments.trim().isEmpty() ? 0 : arguments.trim().split("\\s+").length;
            if(argCount!=commandType.getArgCount())
                System.out.println("Not right amount of arguments!\nCommand help: "+commandType.getDescText());
            if(commandType.isNeedsBooks()&&getBooks().isEmpty())
                System.out.println("No books loaded!");
            else if(commandType.hasAccess(currentUser.getAccessLevel())){
                argumentsArr = arguments.split("\\s+");
                command.runCommand(arguments);
            }
        } else {
            System.out.println("No such command!");
        }
        run();
    }
    public static User getCurrentUser() {
        return currentUser;
    }

    public static String getCurrentFile() {
        return currentFile;
    }

    public static void setCurrentUser(User currentUser) {
        CommandProcessor.currentUser = currentUser;
    }

    public static void setCurrentFile(String currentFile) {
        CommandProcessor.currentFile = currentFile;
    }

    public static Set<Book> getBooks() {
        return Collections.unmodifiableSet(bookSet);
    }
    public static void addBook(Book book){
        bookSet.add(book);
        if (!bookSet.add(book)) {
            System.out.println("Book with ISBN " + book.getIsbn() + " already exists!");
        }
    }
    public static void clearBooks() {
        bookSet.clear();
    }
}
