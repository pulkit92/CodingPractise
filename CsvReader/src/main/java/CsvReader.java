

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CsvReader {
    public static void main(String[] args) throws Exception {
        CsvReader csvReader = new CsvReader();
        Set<String> set = csvReader.split("C:\\Users\\\\pulkit.bajpai\\Desktop\\New Data.csv");
        csvReader.write(set);

    }


    private Set<String> split(String fileName) {

        String line = "";
        String splitBy = ",";
        Set<String> set = new HashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] data = line.split(splitBy);
                set.add(data[0]);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }

    private void write(Set<String> set) throws Exception {
        FileWriter csvWriter = new FileWriter("C:\\Users\\pulkit.bajpai\\Desktop\\output.csv");
        for (String s : set) {
            csvWriter.append(s);
            csvWriter.append("\n");

        }

        csvWriter.flush();
        csvWriter.close();
    }

}

