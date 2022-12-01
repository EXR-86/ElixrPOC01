import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Myfile implements FilenameFilter {
    String filename;

    Myfile(String filename) {
        this.filename = filename;
    }

    public boolean accept(File dir, String name) {
        return name.startsWith(filename);
    }
}
public class Main {
    public static void main(String[] args)throws Exception {
        Scanner user=new Scanner(System.in);
        String filepath= "C:\\Users\\ashutosh.palai\\Documents";
        String fileName="hello.txt";

        String concat=filepath+"\\"+fileName;
        int count=1,repetation=0,check=0;
        String temp="";
        File filedr = new File(filepath);
        Myfile filename = new Myfile(fileName);
        String[] s = filedr.list(filename);

        if (s != null) {
            System.out.println("Processing....");
            //Thread.sleep(1000);
            System.out.println("got the file.");
           // Thread.sleep(1000);
            File f = new File(concat);
            BufferedReader br = new BufferedReader(new FileReader(f));
            Scanner scn = new Scanner(System.in);
            System.out.println("enter the word");
            String word = scn.nextLine();
            char[]ch1=word.toCharArray();
            String st = br.readLine();
            char[] ch = st.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                temp=temp+ch[i];
                if(ch[i]==' ') {

                    String word1 = temp;
                    char[] ch2 = word1.toCharArray();
                    if (word.length() >= word1.length()) {

                        for (int j = 0; j < word1.length(); j++) {
                            if (ch2[j] == ch1[j]) {
                                check++;
                            } else {
                                check = 0;
                            }
                        }
                    } else if (word.length() <= word1.length()) {
                        for (int j = 0; j < word.length(); j++) {
                            if (ch2[j] == ch1[j]) {
                                check++;
                            } else {
                                check = 0;
                            }

                        }
                    }temp="";
                }
                    if(check==word.length()){
                        count++;
                        repetation++;
                        check=0;
                    }


            }
            if(count>1){
                System.out.println("got the word.The word '"+word+"' is present "+(count-1)+" times in the file and it is repetating for "+(repetation-1)+" times inside the file content");
            }else{
                System.out.println("word not found");
            }
        }else{
            System.out.println("The file is not found");
        }
    }}