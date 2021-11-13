
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import javax.servlet.annotation.WebServlet;
import javax.naming.InitialContext;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class ConnectDB extends HttpServlet {

    InitialContext ic = null;
    DataSource ds = null;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement st = null;
    // String tablelist[] = { "member_table", "work_table", "chara_table",
    // "project_table", "art_table" };

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String mode = request.getParameter("mode");// ex:memberRead
        String member_id = null, art_name = null, art_content = null;
        String sqldata = null;

        try {
            ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/shakeburi_database");
            con = ds.getConnection();

            switch (mode) {
            case "memberRead":
                member_id = request.getParameter("member_id");
                sqldata = String.format("select * from member_table where member_id=%s", member_id);
                st = con.prepareStatement(sqldata);
                rs = st.executeQuery();
                while (rs.next()) {
                    out.println(rs.getString("member_id"));
                    out.println(rs.getString("name"));
                    out.println(rs.getString("address"));
                    out.println(rs.getString("mail_address"));
                    out.println(rs.getString("birth"));
                    out.println(rs.getString("chara_id"));
                    out.println(rs.getString("project_id"));
                    out.println(rs.getString("work_id"));
                }
                break;
            case "memberUpdate":
                member_id = request.getParameter("member_id");
                //
                break;
            case "memberReadList":
                sqldata = String.format("select * from member_table");
                st = con.prepareStatement(sqldata);
                rs = st.executeQuery();
                while (rs.next()) {
                    out.println(rs.getString("member_id"));
                    out.println(rs.getString("name"));
                    out.println(rs.getString("address"));
                    out.println(rs.getString("mail_address"));
                    out.println(rs.getString("birth"));
                    out.println(rs.getString("chara_id"));
                    out.println(rs.getString("project_id"));
                    out.println(rs.getString("work_id"));
                }
                break;
            case "memberDelete":
                break;
            case "artCreate":
                art_name = request.getParameter("art_name");
                art_content = request.getParameter("art_content");
                member_id = request.getParameter("member_id");
                sqldata = String.format("insert into art_table(art_name,art_content,member_id)values(%s,%s,%s)",
                        art_name, art_content, member_id);
                st = con.prepareStatement(sqldata);
                rs = st.executeQuery();
                break;
            case "artRead":
                member_id = request.getParameter("member_id");
                sqldata = String.format("select * from art_table where member_id=%s", member_id);
                st = con.prepareStatement(sqldata);
                rs = st.executeQuery();
                while (rs.next()) {
                    out.println(rs.getString("art_id"));
                    out.println(rs.getString("art_name"));
                    out.println(rs.getString("art_content"));
                }
                break;

            // memberDelete,artReadList,artUpdate,artDelete etc...
            default:
                out.println("{'status_code':300}");
                break;
            }
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}