package json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Analizer {
    private static final String fileName ="C:/Users/Ruslan_Omelchenko/IdeaProjects/JSonXML/src/main/resources/courses.txt";
    private static final Type REVIEW_TYPE = new TypeToken<List<Currency>>() {
    }.getType();

    public void getData() {
        URL url = null;
        try {
            url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        InputStream is = null;
        try {
            is = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        try (OutputStreamWriter fos = new OutputStreamWriter(new FileOutputStream(fileName), UTF_8)) {
            int i;
            while((i=rd.read())!=-1) {
                fos.write(i);
//                System.out.print((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readJSON() {

        JsonReader reader=null;
        Gson gson = new Gson();
        String output="";
        try {
            reader = new JsonReader(new FileReader(fileName));

        List <Currency> data = gson.fromJson(reader, REVIEW_TYPE);

        System.out.println("Курсы валют");
        System.out.println("---------------");
        for (Currency cur: data) {
            if ("840".equals(cur.getR030()) || "978".equals(cur.getR030()) || "643".equals(cur.getR030())){
                System.out.println(cur);
            }
            if ("840".equals(cur.getR030())){
                output = cur.getRate();
            }
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return output;
    }
}
