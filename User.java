import java.util.Random;
public class User extends Playlist {
	 protected static int userID;
	 private String userName;
	           
	 public User(){
		 super();
	     userName = "unknownguest";
	     userID = randomID();
	 }
	           
	 public User(String name, String playlistName) {
	     super(playlistName);
	     userName = name;
	     userID = randomID();
	 }
	          
	 public int getUserID() { return userID; }
	 public String getUserName() { return userName; }
	           
	 public int randomID() {
     String num = "";
	 Random id = new Random();
	 for(int i = 0; i < 8;i++){
	   num = id.nextInt(10) + ""; }
	   int newID= Integer.parseInt(num);
	   return newID; }
	}

