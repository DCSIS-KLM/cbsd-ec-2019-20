import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/foo", "bar"},
        name = "MyServlet",
        asyncSupported = true)
public class SimpleServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res) {
        // code
    }
}