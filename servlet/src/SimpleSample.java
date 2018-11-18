//The “value” attribute is recommended for use when
// the URL pattern is the only attribute being set,
// otherwise the “urlPattern” attribute should be
// used.

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foo") // @WebServlet(value = “/foo”)
public class SimpleSample extends HttpServlet {
    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res) {
        // Code
    }
}