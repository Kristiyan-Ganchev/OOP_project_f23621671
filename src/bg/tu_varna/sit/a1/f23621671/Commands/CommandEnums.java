package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Exceptions.AccessDeniedException;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;

import java.util.HashMap;
import java.util.Map;

public enum CommandEnums {
    EXIT("exit", 0, "exit                                                                             exists the program", AccessLevel.NONE, false),
    OPEN("open", 1, "open <file>                                                                      opens <file>", AccessLevel.NONE, false),
    CLOSE("close", 0, "close                                                                            closes currently opened file", AccessLevel.NONE, true),
    SAVE("save", 0, "save                                                                             saves the currently open file", AccessLevel.NONE, true),
    SAVE_AS("save as", 1, "save as <file>                                                                   saves the currently open file in <file>", AccessLevel.NONE, true),
    HELP("help", 0, "help                                                                             prints information about all commands", AccessLevel.NONE, false),
    LOGIN("login", 0, "login                                                                            asks user for their username and password and logs them in", AccessLevel.NONE, false),
    LOGOUT("logout", 0, "logout                                                                           logs current user or administrator out", AccessLevel.USER, false),
    BOOKS_ALL("books all", 0, "books all                                                                        prints short information for each book", AccessLevel.USER, true),
    BOOKS_INFO("books info", 1, "books info <isbn_value>                                                          prints detailed information about book with isbn: <isbn_value>", AccessLevel.USER, true),
    BOOKS_FIND("books find", 2, "books find <option> <option_string>                                              finds and prints books with <option> being either author,title or tag and <option_string being their value>", AccessLevel.USER, true),
    BOOKS_SORT("books sort", 1, "books sort <option> [asc|desc]                                                   prints books sorted by <option>, which is either title,author,year or rating with ascending order by default unless specified", AccessLevel.USER, true),
    BOOKS_ADD("books add", 8, "books add <author> <title> <genre> <isbn> <description> <year> <rating> <tags>   adds a new book with these values", AccessLevel.ADMINISTRATOR, false),
    BOOKS_REMOVE("books remove", 1, "books remove <isbn_value>                                                        removes book with isbn: <isbn_value>", AccessLevel.ADMINISTRATOR, true),
    USERS_ADD("users add", 2, "users add <user> <password>                                                      adds new user with name <user> and password <password>", AccessLevel.ADMINISTRATOR, false),
    USERS_REMOVE("users remove", 1, "users remove <user>                                                              removes user with name <user>", AccessLevel.ADMINISTRATOR, false);

    private final String commandText;
    private final int argCount;
    private final String descText;
    private final AccessLevel accessLevel;
    private final boolean needsBooks;

    CommandEnums(String commandText, int argCount, String descText, AccessLevel accessLevel, boolean needsBooks) {
        this.commandText = commandText;
        this.argCount = argCount;
        this.descText = descText;
        this.accessLevel = accessLevel;
        this.needsBooks = needsBooks;
    }

    public String getCommandText() {
        return commandText;
    }

    public int getArgCount() {
        return argCount;
    }

    public String getDescText() {
        return descText;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public boolean isNeedsBooks() {
        return needsBooks;
    }

    private static final Map<String, CommandEnums> commandLookup = new HashMap<>();

    static {
        for (CommandEnums command : values()) {
            commandLookup.put(command.commandText, command);
        }
    }

    public static CommandEnums getCommandEnum(String[] commandText) {
        if (commandText.length > 1 && commandLookup.containsKey(commandText[0] + " " + commandText[1]))
            return commandLookup.get(commandText[0] + " " + commandText[1]);
        else if (commandLookup.containsKey(commandText[0]))
            return commandLookup.get(commandText[0]);
        return null;
    }

    public boolean hasAccess(AccessLevel userAccessLevel) throws AccessDeniedException {
        if (userAccessLevel.equals(AccessLevel.ADMINISTRATOR) || this.getAccessLevel().equals(AccessLevel.NONE))
            return true;
        else if (userAccessLevel.equals(this.getAccessLevel())) {
            return true;
        }
        throw new AccessDeniedException("You need to be " + (this.getAccessLevel() == AccessLevel.NONE ? "logged out" : "a " + this.getAccessLevel()) + " to use command!");
    }
}
