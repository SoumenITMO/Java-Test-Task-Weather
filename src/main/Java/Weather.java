import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Weather extends HttpServlet {

    private BufferedReader readBuffer;
    private JsonObject jsonObject;
    private JsonObject jsonObj;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String line;
        String cityName;
        String cityCode = request.getParameter("citycode");

        if(!cityCode.isEmpty()) {
            jsonObj = new JsonObject();
            readBuffer = new BufferedReader(new FileReader(this.getClass().getClassLoader()
                    .getResource("data/weather.json").getPath()));

            while((line = readBuffer.readLine()) != null) {
                jsonObject =  new JsonParser().parse(line).getAsJsonObject();
                cityName = jsonObject.get("city").getAsJsonObject().get("name").toString().replace('"', ' ').trim();
                if(cityCode.equals(cityName)) {

                    jsonObj.addProperty("city_name", cityName);
                    jsonObj.addProperty("temp",  jsonObject.get("main").getAsJsonObject().get("temp").toString());
                    jsonObj.addProperty("min_tmp", jsonObject.get("main").getAsJsonObject().get("temp_min").toString());
                    jsonObj.addProperty("max_tmp", jsonObject.get("main").getAsJsonObject().get("temp_max").toString());
                    jsonObj.addProperty("humidity", jsonObject.get("main").getAsJsonObject().get("humidity").toString());
                    break;
                }
            }

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println(jsonObj.toString());
        } else {
            PrintWriter out = response.getWriter();
            out.println("Citycode is blank.");
        }

    }
}
