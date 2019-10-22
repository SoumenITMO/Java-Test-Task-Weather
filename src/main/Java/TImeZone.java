import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TImeZone extends HttpServlet {

    private InputStream inputStream;
    private BufferedReader readBuffer;
    private JsonObject jsonObject;
    private PrintWriter out;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String zipCode = request.getParameter("zipcode");

        try{
            if(!zipCode.isEmpty()) {
                String openSkyAPIUrl = "http://www.zipcodeapi.com/rest/Af4mkd4buexN2LzkFA2KFN9qYOsYVMR1S7horJ8DuBGHYeuZHLsHQznAa2yEXdod/info.json/"+zipCode+"/degrees";
                URL url = new URL(openSkyAPIUrl);

                out = response.getWriter();
                inputStream = url.openStream();
                readBuffer = new BufferedReader(new InputStreamReader(inputStream));
                jsonObject = new JsonParser().parse(readBuffer.readLine()).getAsJsonObject();

                response.setContentType("application/json");
                out.println(jsonObject.toString());
            } else {
                out.println("Blank Zip Code.");
            }
        } catch (FileNotFoundException zipCodeWrong) {
            out.println("Looks like it's a wrong zip code.");
        }

    }
}
