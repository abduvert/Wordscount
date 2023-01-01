import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class FirstThread extends Thread {
    @Override
    public void run() {
        Instant start = Instant.now();

        ArrayList<String> list = new ArrayList();
        int counter=0;
        int total=0;
        String[] words={};
        int freq=0;

        String b="";
        int c=0;
        String temp="";
        int tem2=0;

        HashMap<String, Integer> frequency = new HashMap<>();
        HashMap<String, Integer> frequency2 = new HashMap<>();
        ArrayList<HashMap<String, Integer>> sort = new ArrayList<>();
        File fcount = new File("src\\count.txt");
        Scanner check = new Scanner(System.in);
        System.out.println("Enter a word to check its existence and frequency in the files(thread nmbr:) "+ ++Main2.rand+ "\n");
        String checker = check.nextLine();




        //file
        File folder = new File("src\\dataset");

        File[] listOfFiles = folder.listFiles();



        //main execution
        try {
            for (int i = 0; i < listOfFiles.length; i++) {


                Path path = Paths.get(listOfFiles[i].toURI());

                Charset charset = Charset.forName("ISO-8859-1");

                BufferedReader bufferedReader = Files.newBufferedReader(path,charset);

                String curLine;
                while ((curLine = bufferedReader.readLine()) != null) {

                    words = curLine.split("\\s");

                    for(String a: words)
                    {
                        //code to determine every single word freq in total files
//                        if(!frequency.containsKey(a))
//                        {
//                            frequency.put(a,1);
//                            tem2= tem2+ 1;
//                            sort.add(frequency);
//                        }
//                        else{
//                            frequency.put(a,++freq);
//                            tem2= (++freq)+tem2;
//                            sort.add(frequency);
//
//                        }

                        if(i!=5)
                        {

                            if(checker.equalsIgnoreCase(a))
                            {
                                ++c;

                            }
                        }
                        else
                        {
                            System.out.println("Determining total words in all files...");
                            break;
                        }

                    }


                    counter = counter + words.length;
                }




                //System.out.println("File" + ":" + (i + 1) + ":" + counter);

                if (i == listOfFiles.length - 1) {
                    total=total+counter;
                    System.out.println("");
                    System.out.println("Total Words In All Files:" + total);
                }


            }
            System.out.println("TOTAL NUMBER OF TIMES THE WORD APPEARS IN TOP 5: ["+ checker + "]: " + c);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Instant end = Instant.now();
        System.out.println("TIME for thread "+Main2.rand+" (in milli seconds): " + Duration.between(start, end).toMillis());


    }
}
