public class ThreeParams extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Your Information";
        out.println("<HTML>" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=CENTER>" + title + "</H1>\n" + "<UL>\n" +
                "  <LI><B>First Name in Response</B>: "
                + request.getParameter("param1") + "\n" +
                "  <LI><B>Last Name in Response</B>: "
                + request.getParameter("param2") + "\n" +
                "  <LI><B>NickName in Response</B>: "
                + request.getParameter("param3") + "\n" + "</UL>\n" +
                "</BODY></HTML>");
    }
}