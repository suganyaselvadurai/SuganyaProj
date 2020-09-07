import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;


public class GsonTester {
    public static Logger logger = Logger.getLogger(GsonTester.class);
    public static void main(String args[]) {

        GsonTester tester = new GsonTester();
        try {

            WeathMain weathMain = tester.readJSON();
            List<Location> locations=weathMain.getList().stream().filter(p ->{
                if(p.getName().startsWith("T")){
                    logger.info("name start with T::"+p.getName());
                    return true;
                }return false;
            }).collect(Collectors.<Location>toList());
            logger.info("count of name start with T:: "+locations.size());


        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private WeathMain readJSON() throws IOException {
        String sampleURL="https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22";

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        InputStream is = new URL(sampleURL).openStream();
        String jsonText=null;

        try {

            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
             jsonText = readAll(rd);
                logger.info("openweathermap response==>"+jsonText);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            is.close();

        }

        WeathMain weathMain = gson.fromJson(jsonText, WeathMain.class);
        return weathMain;
    }
}

