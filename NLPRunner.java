public class NLPRunner {
  public static void main(String[] args) {

    // Get the files that were used in MyNLP class
     String namesFile = "names.txt";
    String jobsFile = "jobs.txt";
    String songsFile = "songtitles.txt";

    
  // Instantiate a MyNLP object ("student-developed class")
    MyNLP nlp = new MyNLP(namesFile, jobsFile, songsFile);

    nlp.prompt();



    
    
    
    
  }
}