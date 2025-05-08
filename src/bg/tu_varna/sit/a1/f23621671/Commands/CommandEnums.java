package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;

import java.util.HashMap;
import java.util.Map;

public enum CommandEnums {
    EXIT("exit", 0, "exit\t\t\t  exists the program",AccessLevel.NONE),
    OPEN("open", 1,"open <file>\t\t  opens <file>" ,AccessLevel.NONE),
    CLOSE("close", 0, "close\t\t\t  closes currently opened file",AccessLevel.NONE),
    SAVE("save", 0, "save\t\t\t  saves the currently open file",AccessLevel.NONE),
    SAVE_AS("save as", 1, "save as <file>\t  saves the currently open file in <file>",AccessLevel.NONE),
    HELP("help", 0, "help\t\t\t  prints this information",AccessLevel.NONE),
    LOGIN("login", 0, "login",AccessLevel.NONE),
    LOGOUT("logout", 0, "logout",AccessLevel.USER),
    BOOKS_ALL("books all", 0, "books all",AccessLevel.USER),
    BOOKS_INFO("books info", 1, "books info",AccessLevel.USER),
    BOOKS_FIND("books find", 2, "books find",AccessLevel.USER),
    BOOKS_SORT("books sort", 2, "books sort",AccessLevel.USER),
    BOOKS_ADD("books add", 0, "books add",AccessLevel.ADMINISTRATOR),
    BOOKS_REMOVE("books remove", 1, "books remove",AccessLevel.ADMINISTRATOR),
    USERS_ADD("users add", 2, "users add",AccessLevel.ADMINISTRATOR),
    USERS_REMOVE("users remove", 1, "users remove",AccessLevel.ADMINISTRATOR);

    private final String commandText;
    private final int argCount;
    private final String descText;
    private final AccessLevel accessLevel;

    CommandEnums(String commandText, int argCount, String descText, AccessLevel accessLevel) {
        this.commandText = commandText;
        this.argCount = argCount;
        this.descText = descText;
        this.accessLevel = accessLevel;
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
    public boolean hasAccess(AccessLevel userAccessLevel){
        if(userAccessLevel.equals(AccessLevel.ADMINISTRATOR))
            return true;
        else if(userAccessLevel.equals(this.getAccessLevel())){
            return true;
        }
        System.out.println("You need to be "+(this.getAccessLevel() == AccessLevel.NONE ? "logged out" : "a "+this.getAccessLevel()) +" to use command!");
        return false;
    }
}
