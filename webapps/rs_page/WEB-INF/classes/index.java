
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import javax.servlet.annotation.WebServlet;
import javax.naming.InitialContext;
import java.sql.*;

public class index extends HttpServlet {
    public index() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        ConnectDB db = new ConnectDB();
        ResultSet rs = db.send_sql("select * from member_table");
        while (rs.next()) {
            out.println(rs.getInt("member_id"));
        }
        out.append("Hello Servlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}