import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class indexservlet extends HttpServlet {
    // Handles GET requests
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String candidate = req.getParameter("candidate");

        // Print to the response (for confirmation)
        out.println("<html><body>");
        out.println("Thank you for voting.");
        out.println("</body></html>");

        // Write to the file
        try (FileWriter writer = new FileWriter("C:\\Users\\Admin\\OneDrive\\Desktop\\backend.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write("Username: " + username + ", Password: " + password + ", Voted to: " + candidate);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handles POST requests
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res); // Forwarding POST to GET handler for simplicity
    }
}
