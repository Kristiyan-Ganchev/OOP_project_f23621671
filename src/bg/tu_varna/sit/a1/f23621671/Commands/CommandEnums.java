package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Exceptions.AccessDeniedException;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;

import java.util.HashMap;
import java.util.Map;

public enum CommandEnums {
    EXIT("exit", 0, "exit\t\t\t  exists the program",AccessLevel.NONE, false),
    OPEN("open", 1,"open <file>\t\t  opens <file>" ,AccessLevel.NONE, false),
    CLOSE("close", 0, "close\t\t\t  closes currently opened file",AccessLevel.NONE, true),
    SAVE("save", 0, "save\t\t\t  saves the currently open file",AccessLevel.NONE, true),
    SAVE_AS("save as", 1, "save as <file>\t  saves the currently open file in <file>",AccessLevel.NONE, true),
    HELP("help", 0, "help\t\t\t  prints this information",AccessLevel.NONE, false),
    LOGIN("login", 0, "login",AccessLevel.NONE, false),
    LOGOUT("logout", 0, "logout",AccessLevel.USER, false),
    BOOKS_ALL("books all", 0, "books all",AccessLevel.USER, true),
    BOOKS_INFO("books info", 1, "books info",AccessLevel.USER, true),
    BOOKS_FIND("books find", 2, "books find",AccessLevel.USER, true),
    BOOKS_SORT("books sort", 1, "books sort",AccessLevel.USER, true),
    BOOKS_ADD("books add", 0, "books add",AccessLevel.ADMINISTRATOR, false),
    BOOKS_REMOVE("books remove", 1, "books remove",AccessLevel.ADMINISTRATOR, true),
    USERS_ADD("users add", 2, "users add",AccessLevel.ADMINISTRATOR, false),
    USERS_REMOVE("users remove", 1, "users remove",AccessLevel.ADMINISTRATOR, false);

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
    public static CommandEnums getCommandEnum(String[] commandText){
        if (commandText.length>1&&commandLookup.containsKey(commandText[0]+" "+commandText[1]))
            return commandLookup.get(commandText[0]+" "+commandText[1]);
        else if(commandLookup.containsKey(commandText[0]))
            return commandLookup.get(commandText[0]);
        return null;
    }
    public boolean hasAccess(AccessLevel userAccessLevel) throws AccessDeniedException {
        if(userAccessLevel.equals(AccessLevel.ADMINISTRATOR)||this.getAccessLevel().equals(AccessLevel.NONE))
            return true;
        else if(userAccessLevel.equals(this.getAccessLevel())){
            return true;
        }
        throw new AccessDeniedException("You need to be "+(this.getAccessLevel() == AccessLevel.NONE ? "logged out" : "a "+this.getAccessLevel()) +" to use command!");
    }
}
