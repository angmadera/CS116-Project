import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class Playlist implements PlayableInterface {
	private String n;
	private int numberOfRecordings = 0;
	private double durationInSeconds = 0.0;
	ArrayList <Recording> recordingList;
	protected int recordingsPlayedCounter = 0;
	
	Playlist(){
		this.n = "Unknown";
		this.recordingList = new ArrayList<Recording>(1);
	}
	
	Playlist(String name){
		this.recordingList =  new ArrayList<Recording>(1);
		if (name != null){
			this.n = name;
		} 
		else {
		this.n = "Unknown";
		} 
	}

	public void setName(String name){ if (name != null) this.n = name; }
	
	public int getNumberOfRecordings(){ return this.numberOfRecordings; }
	
	public String getName(){ return this.n; }
	
	public double getDuration(){ return this.durationInSeconds;}
	
	public void shuffle(int numberOfRecordingsToPlay){
		if (this.numberOfRecordings > 0 && numberOfRecordingsToPlay > 0) {
			int recordingsPlayedCounter = 0;
			Random randomNumberGenerator = new Random();
	while (recordingsPlayedCounter < numberOfRecordingsToPlay){
			recordingList.get(randomNumberGenerator.nextInt(this.numberOfRecordings));
			recordingsPlayedCounter++;
	}
		System.out.println();
	} else {
		System.out.println("ERROR: Empty playlist.");
	}
	}
	
	public void load(String fileName){
        if(fileName!=null){
            try{
                BufferedReader reader = new BufferedReader(new FileReader(fileName+".csv"));
                String r="", songName="", artistName="", line;
                double rate=0;
                int duration = 0;
                while((line = reader.readLine()) != null){
                    String[] str = line.split(",");
                    if(str.length==5){
                        r = str[0];
                        songName = str[1];
                        artistName = str[2];
                        duration = Integer.parseInt(str[3]);
                        rate = Double.parseDouble(str[4]);
                    }else{
                        r = str[0];
                        if(str[1].substring(0,1).equals("\"")){
                            int count= 0;
                            songName ="";
                            for(int i = str.length-1;i>2;i--){
                                String checkWord = str[i].substring(str[i].length()-1,str[i].length());
                                if(checkWord.equals("\"")){
                                    break;
                                }else{
                                    count++;
                                }
                            }

                            for(int i = 1; i < count;i++){
                                songName += str[i];
                            }

                        }
                        artistName = str[str.length-3];
                        duration = Integer.parseInt(str[str.length-2]);
                        rate = Double.parseDouble(str[str.length-1]);
                    }

                    if (str[0].equals("A")) {
                        AudioRecording newRecording = new AudioRecording(artistName, songName, duration, rate);
                        this.add(newRecording);
                    }
                    if (str[0].equals("V")) {
                        VideoRecording newRecording = new VideoRecording(artistName, songName, duration, rate);
                        this.add(newRecording);
                    }


                }
            }catch(IOException e){
                System.out.println("Error: Couldn't load file.");
            }
        }else{
            System.out.println("ERROR: No file name provided.");
        }
    }
		
	
	
	public boolean add(Recording newRecording){
	        if (newRecording != null){
	           this.recordingList.set(numberOfRecordings, newRecording);
	           recordingList.add(newRecording);
	           this.numberOfRecordings++;
	           this.durationInSeconds = this.durationInSeconds + newRecording.getDuration();
	           return true;
	        } else {
	           return false;
	        } 
	}
	        
		public boolean remove(int index) {
			if(index >= recordingList.size()) {
				return false;
			}
			else {
				recordingList.remove(index);
				return true;
			}
		}
		
		public boolean remove(String songName) {
			boolean exists = false;
			int remIndex = 0;
			for(int i = 0; i < recordingList.size(); i++) {
				if (songName.equals(recordingList.get(i).getName())){
					exists = true;
					remIndex = i;
				}
			}
			
			if(exists) {
				recordingList.remove(remIndex);
				return exists;
			}
			else {
				return exists;
			}
		}
		
		//play methods
		public void play(String songName) {
			for(int i=0; i < recordingList.size(); i++) {
				if(recordingList.get(i).getName().equals(songName)) {
		                recordingList.get(i);
		            }
		            System.out.println();
					recordingList.get(i).incrementPlays();
				}
			}
		
	public void play(int songPosition) {
	recordingList.get(songPosition).play();
	recordingList.get(songPosition).incrementPlays();
	}
		
	public void play() {
	if (this.numberOfRecordings > 0) {
	for (int index = 0; index < this.numberOfRecordings; index++) {
		recordingList.get(index);
	}
		System.out.println();
	} else {
		System.out.println("ERROR: Empty playlist.");
	}
	}
		
	protected void save(User currentUser){
      File file = new File("Insert File (Database): ");
      if(!file.exists()){
         System.out.println("\"Database\" was not found, creating directory...");
         file.mkdir();
      }
      try
            {
               SimpleDateFormat formatter = new SimpleDateFormat("MM_DD_YYYY_HH_MM_SS");
               Date date = new Date(System.currentTimeMillis());
               String format = formatter.format(date);
               
               File readFile = new File("Database"+currentUser.getUserName()+"_"+currentUser.getName()+"_"+format+".csv");
               BufferedWriter writer = new BufferedWriter(new FileWriter(readFile));
               writer.write(currentUser.toString());
               writer.close();
               
        System.out.println("Data is saved!");
    }catch (IOException e) {
               System.out.println("Error could not save the data provided!");
    }
 }

	protected void statistics() {
		for(Recording x: recordingList){
		int t = x.getNumberOfPlays();
		System.out.print(x);
	    System.out.print("number of plays: " + t);
	}
	}
	
	public String toString(){
	String returnString = "Playlist: " + this.n + " [" + ((int) Math.floor(this.durationInSeconds/60)) + "m" + (this.durationInSeconds % 60) + "s]:\n";
	while (this.numberOfRecordings > 0) {
	for (int i = 0; i < this.numberOfRecordings; i++){
	returnString = returnString + recordingList.get(i).toString() + "\n";
		}
	} 
		return returnString;
	}
}