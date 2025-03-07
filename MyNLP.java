import java.util.ArrayList;
import java.util.Scanner;

public class MyNLP {

  // Created 4 meaningful ArrayList 
private ArrayList<String> name;      // The list of names to choose from
  private ArrayList<String> job;       // The list of jobs to choose from
   private ArrayList<String> songTitles;    // The list of songs to analyze
   private String lyrics;                   // The file containing the lyrics

  // assigned initial values for your instance variables
  public MyNLP(String namesFile, String jobsFile, String songsFile) {
   this.name = FileReader.toStringList(namesFile);
    this.job = FileReader.toStringList(jobsFile);
  this.songTitles = FileReader.toStringList(songsFile);
  }
  

  /**
   * @param none
   * @return void
   * Starts the app and gets user input
   */
  public void prompt() {
    Scanner input = new Scanner(System.in);
 String choice = "yes";
    
     while (choice.equals("yes") || choice.equals("y")) {
      String currentName = getOption(name);
      String currentIntro = getCurrentIntro(currentName);
      System.out.println(currentIntro);
      
      System.out.print("Would you like to see " + currentName + "'s" + " occupation? ");
      choice = input.next();
      
      if (choice.equals("yes") || choice.equals("y")) {
        System.out.println("\n"+ createPerson(currentName) + "\n");
      }

           System.out.print("Would you like to see " + currentName + "'s" + " favorite song? ");
      choice = input.next();

         if (choice.equals("yes") || choice.equals("y")) {
           String songFile = getSongFile();
        System.out.println("\nSong Title: " + songFile.split(":")[0]); 
        System.out.println("Song Lyrics: " + getSongLyrics(songFile) + "\n");
      }
    }

    // End the loop when the user says no

    input.close();
        System.out.println("Goodbye!");
  }

  /**
   * @param name a String representing the name of the person to introduce
   * @return a String containing the introduction about the current friend, including the name
   * Returns a String containing an introduction about the current friend
   */
  public String getCurrentIntro(String name) {
    String currentJob = getOption(job);
  
    String currentIntro = "There is someone named " + name + ".";
    return currentIntro;
  }

  /**
   * @param currentName a String representing the name of the person whose occupation is displayed
   * @return a String containing the occupation of the person
   * Returns a String containing the new friend that is generated for
   * the current friend with their favorite thing to do together
   */
  public String createPerson(String currentName) {
    String currentJob = getOption(job);
  
    String text = currentName + "'s" +  " occupation is " + currentJob;
  
    return text;
  }

   /**
   * @param options an ArrayList of Strings representing a list of options to choose from
   * @return a String representing a randomly selected item from the options list
   * Returns a random option from the specified list of options
   */
  public String getOption(ArrayList<String> options) {
    int randomIndex = (int)(Math.random() * options.size());
    return options.get(randomIndex);
  }

   /**
   * @param none
   * @return a String containing the song title and filename in the format SongTitle:filename
   * Gets the filename for the chosen song
   */
  public String getSongFile() {
    String randomSongTitle = getOption(songTitles);
     String songFile = "";

      for (int index = 0; index < songTitles.size(); index++) {
      String currentLine = songTitles.get(index);
      int colon = currentLine.indexOf(":");
      String currentTitle = currentLine.substring(0, colon);

      if (currentTitle.equals(randomSongTitle)) {
        songFile = currentLine.substring(colon + 1); 
 }
      }
     return randomSongTitle + ":" + songFile;
  }

   /**
   * This is a student developed method
   * @param songFile a String representing the filename of the song whose lyrics are to be retrieved
   * @return an ArrayList<String> containing the lyrics of the song
   * Gets the filename for the chosen song
   */
   public ArrayList<String> getSongLyrics(String songFile) {
    ArrayList<String> songLyrics = new ArrayList<>();
       String filename = songFile.split(":")[1];
  
        ArrayList<String> lyricsList = FileReader.toStringList(filename);
     
  songLyrics.addAll(lyricsList);
      return songLyrics;
   }
  
}