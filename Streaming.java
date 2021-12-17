import java.util.*;

public class Streaming {
	private static ArrayList <User> AllUsers = new ArrayList<User>();
	Scanner scan = new Scanner(System.in);
	private static Scanner in;
	private static Scanner in2;
	
	public void run() {
		menu1();
	}
	
	public static void add(String username, String playlist) {
		User temp = new User(username, playlist);
		AllUsers.add(temp);
	}
	
	public static void remove(int ID) {
		boolean user = false;
		int remove = 0;
		for (int i = 0; i < AllUsers.size(); i++) {
			if(AllUsers.get(i).getUserID() == ID){
				user = true;
				remove = i;
			}
		}
		if(user){
			AllUsers.remove(remove);
		}
		else {
			System.out.println("ID does not exist.");
		}
	}
	
	public static void removeUser(String specificUserName) {
		boolean userExists = false;
		int remIndex = 0;
		for (int i = 0; i < AllUsers.size(); i++) {
			if(AllUsers.get(i).getUserName().equals(specificUserName)){
				userExists = true;
				remIndex = i;
			}
		}
		if(userExists) {
			AllUsers.remove(remIndex);
		}
		else {
			System.out.println("That username does not belong to any user.");
		}
	}

      public static void menu1() {
    	   in = new Scanner(System.in);
	       String s = "s"; {
	       boolean isRunning = true;
	       while(isRunning){
	       while (s != "5") {
	       System.out.println("Enter a number: 1) Log in 2) Add User 3) Remove User 4) All Users 5) Quit");
	       s = in.next();
        
      if(s.equals("1")){
    	  boolean userAlreadyExists = false;
          System.out.println("ID:");
          int r = in.nextInt();
          for (int i = 0; i < AllUsers.size(); i++) {
    	  if(AllUsers.get(i).getUserID() == r){
    	  userAlreadyExists = true;
    			}
          if(userAlreadyExists) {
        	  menu2();
          }}}
     
       if(s.equals("2")){
       System.out.println("username and playlist: ");
       String name = in.next();
       String playlist = in.next();
       add(name, playlist);
       }
                  
       if(s.equals("3")){
       System.out.println("Enter ID to remove:");
       int remove = in.nextInt();
       remove(remove);
       }
                  
      if(s.equals("4")){
      System.out.println("List of all users: ");
      for(User user: AllUsers){
    	    System.out.println(user);
    	}
      }
      }
	       }
	       }
	       } 
       
       public static void menu2() { 
       String s = "s"; {
       boolean isRunning = true;
       while(isRunning){
    	   
       while (s != "12") {
         in2 = new Scanner(System.in);
         System.out.println("Enter a number: 1) Add a recording 2) Add a playlist from a file 3) Add a playlist of another user 4) Remove a recording with an index 5) Remove a recording by name 6) Play the recording based on index 7) Play recording based on name 8) Play the entire playlist 9) Shuffle the playlist 10) Save the playlist 11) Statistics 12) Quit"); 
         s = in2.next();
   
         if(s.equals("1")){
         System.out.println("Provide the recording information: (Audio/Video, Recording Name, Artist Name, Bitrate, Duration in Seconds ");
         String type = in2.next();
         String recording = in2.next();
         String artist = in2.next();
         double rate = in2.nextDouble();
         int seconds = in2.nextInt();
          
      if (type.equals("A")){
       AudioRecording newRecording = new AudioRecording(type, artist, recording, seconds, rate);
       User music = new User();
       music.add(newRecording);
      }
      
	   if (type.equals("V")){
	   VideoRecording newRecording = new VideoRecording(type, artist, recording, seconds, rate);
	   User music = new User();
       music.add(newRecording);}
       }
   
       if(s.equals("2")){
       System.out.println("Enter the file name to add playlist:");
       String r = in2.next();
       User music = new User();
       music.load(r);
       }
   
       if(s.equals("3")){
       System.out.println("Enter ID:");
       int r = in2.nextInt();
       remove(r);
       }
   
       if(s.equals("4")){
       System.out.println("Enter index of recording to remove: ");
       int r = in2.nextInt();
       User music = new User();
       music.remove(r);
       }
   
       if(s.equals("5")){
       System.out.println("Enter name of recording to remove:");
       String r = in2.next();
       User music = new User();
       music.remove(r);
       }
   
       if(s.equals("6")){
       System.out.println("Enter index to play recording:");
       int r = in2.nextInt();
       User music = new User();
       music.play(r);
       }
                  
       if(s.equals("7")){
       System.out.println("Enter recording name: ");
       String r = in2.next();
       User music = new User();
       music.play(r);
              }
       
       if(s.equals("8")){
       System.out.println("Playing All Playlist...");
       User music = new User();
       music.play();
       }
       
                  if(s.equals("9")){
       System.out.println("Enter number of songs shuffled: ");
       int r = in2.nextInt();
       User music = new User();
       music.shuffle(r);
       }
                  
       if(s.equals("10")){
       System.out.println("Playlist has been saved!");
       User music = new User();
       music.save(music);
       }
                  
       if(s.equals("11")){
       System.out.println("Display playlist statistics: ");
       User music = new User();
       music.statistics();
                  }
                  
       if(s.equals("12")){
          System.exit(1);
                      }
}
}
}
}
}
