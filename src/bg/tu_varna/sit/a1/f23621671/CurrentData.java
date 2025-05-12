package bg.tu_varna.sit.a1.f23621671;

import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;
import bg.tu_varna.sit.a1.f23621671.Users.User;

public class CurrentData {
    private static CurrentData instance=null;
    private static User currentUser;
    private static String currentFile;
    private CurrentData() {
        currentUser=new User(null,null, AccessLevel.NONE);
        currentFile="";
    }
    public static CurrentData getInstance(){
        if(instance==null){
            instance=new CurrentData();
        }
        return instance;
    }
    public  User getCurrentUser() {
        return currentUser;
    }

    public  String getCurrentFile() {
        return currentFile;
    }

    public  void setCurrentUser(User currentUser) {
        CurrentData.currentUser = currentUser;
    }

    public  void setCurrentFile(String currentFile) {
        CurrentData.currentFile = currentFile;
    }
}
