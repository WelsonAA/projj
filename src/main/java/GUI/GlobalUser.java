package GUI;

public class GlobalUser {
    private static String userID;
    private static String userPASS;
    public static void setUserPASS(String userPASS) {
        GlobalUser.userPASS = userPASS;
    }

    public static String getUserPASS() {
        return userPASS;
    }


    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        GlobalUser.userID = userID;
    }
}
