package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 153085T on 10/24/2016.
 */
@WebServlet(name = "BookCatalogServlet", urlPatterns = "bookcatalog")
public class BookCatalogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookDBAO db = new BookDBAO();
            List<BookDetails> list = db.getAllBook();
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<table>");
            for (int i = 0; i < list.size(); i++) {
                out.println("<tr>");
                out.println("<td>" + list.get(i).getTitle() + "</td>");
                out.println("<td>" + list.get(i).getDescription() + "</td>");
                out.println("<td>" + list.get(i).getTitle() + "</td>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}
