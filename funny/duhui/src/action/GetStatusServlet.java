package action;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetStatus
 */
@WebServlet("/GetStatus")
public class GetStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStatusServlet() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // response.getWriter().append("Served at: ")
        // .append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("getStatus222");
        File tem = new File("../db/status.txt");
        if (!tem.exists()) {
            tem.getParentFile().mkdirs();
            tem.createNewFile();
        }
        FileReader fr = new FileReader(tem);
        char[] a = new char[50];
        fr.read(a);
        String result = new String(a);
        System.out.println(result);
        response.getWriter().append(result.trim());
        fr.close();
        doGet(request, response);
    }

}
