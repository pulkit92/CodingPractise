import java.io.*;
import java.util.*;
import java.util.regex.*;


public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = "C:\\Users\\pulkit.bajpai\\Desktop\\pulkit.txt";
        OutputStream os = null;
        String data = readFile(filename);
        String resultFileName = "gifs_"+filename;

        try {

            // below true flag tells OutputStream to append

            os = new FileOutputStream(new File(resultFileName), true);

            os.write(data.getBytes(), 0, data.length());

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                os.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }
    static  String readFile(String fileName) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        try {

            StringBuilder sb = new StringBuilder();

            String line = br.readLine();
            while (line != null) {
                String[] temp = line.split(" ");
                String tempRes = temp[6];
                String lastWord = tempRes.substring(tempRes.lastIndexOf("/") + 1);

                if((lastWord.contains(".gif") ||lastWord.contains(".GIF"))&& temp[5].contains("GET")&& temp[8].contains("200")){
                    sb.append(lastWord);
                    sb.append("\n");
                }




                line = br.readLine();

            }
            System.out.println(sb.toString());
            return sb.toString();

        } finally {

            br.close();

        }

    }
}