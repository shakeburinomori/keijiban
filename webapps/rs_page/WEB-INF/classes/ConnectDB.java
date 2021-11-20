
/*
    プログラム名：ConnectDB
    プログラム概要：データベースへの接続を行い、postされた内容に応じたsqlの実行を行う
    作成者：浅野龍太郎
    作成日：2021/11/12

*/
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String mode = request.getParameter("mode");// ex:memberRead
        String member_id = null, art_name = null, art_content = null;
        String sqldata = null, result_data = null;

        try {
            // context.xmlの情報を使ってデータベースに接続 ※rs_page/META-INF/context.xml
            ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/shakeburi_database");
            con = ds.getConnection();

            // 選択したモードによって実行するクエリを変更する
            switch (mode) {

            // ログインユーザー自身のメンバー情報を取得
            case "memberRead":
                member_id = request.getParameter("member_id");
                sqldata = String.format("select * from member_table where member_id=%s", member_id);
                st = con.prepareStatement(sqldata);
                rs = st.executeQuery();
                while (rs.next()) {
                    result_data = String.format(
                            "{\"member_id\":%s,\"name\":\"%s\",\"address\":\"%s\",\"mail_address\":\"%s\",\"birth\":\"%s\",\"chara_id\":%\"s\",\"project_id\":\"%s\",\"work_id\":\"%s\"}",
                            rs.getString("member_id"), rs.getString("name"), rs.getString("address"),
                            rs.getString("mail_address"), rs.getString("birth"), rs.getString("chara_id"),
                            rs.getString("project_id"), rs.getString("work_id"));
                    out.println(result_data);
                }
                break;

            case "memberUpdate":
                member_id = request.getParameter("member_id");
                //
                break;

            // すべてのメンバー情報を一覧で取得
            case "memberReadList":
                sqldata = String.format("select * from member_table");
                st = con.prepareStatement(sqldata);
                rs = st.executeQuery();
                while (rs.next()) {
                    result_data = String.format(
                            "{\"member_id\":%s,\"name\":\"%s\",\"address\":\"%s\",\"mail_address\":\"%s\",\"birth\":\"%s\",\"chara_id\":%\"s\",\"project_id\":\"%s\",\"work_id\":\"%s\"}",
                            rs.getString("member_id"), rs.getString("name"), rs.getString("address"),
                            rs.getString("mail_address"), rs.getString("birth"), rs.getString("chara_id"),
                            rs.getString("project_id"), rs.getString("work_id"));
                    out.println(result_data);
                }
                break;
            case "memberDelete":
                break;

            // 記事投稿の際に使用,データベースに記事情報を格納
            case "artCreate":
                art_name = request.getParameter("art_name");
                art_content = request.getParameter("art_content");
                member_id = request.getParameter("member_id");
                System.out.println("\n\n" + art_name + "\n\n");
                System.out.println("\n\n" + art_content + "\n\n");
                System.out.println("\n\n" + member_id + "\n\n");

                // member_idが整数かどうか判定
                for (int i = 0; i < member_id.length(); i++) {
                    if (!Character.isDigit(member_id.charAt(i))) {
                        out.println("No number");
                        break;
                    }
                }
                sqldata = String.format("insert into art_table(art_name,art_content,member_id)values(\"%s\",\"%s\",%s)",
                        art_name, art_content, member_id);
                System.out.println("\n\n" + sqldata + "\n\n");
                st = con.prepareStatement(sqldata);
                st.executeUpdate();
                break;

            // ログインユーザーが投稿した記事を取得
            case "artRead":
                member_id = request.getParameter("member_id");
                sqldata = String.format("select * from art_table where member_id=%s", member_id);
                st = con.prepareStatement(sqldata);
                rs = st.executeQuery();
                while (rs.next()) {
                    result_data = String.format("{\"art_id\":%s,\"art_name\":\"%s\",\"art_content\":\"%s\"}",
                            rs.getString("art_id"), rs.getString("art_name"), rs.getString("art_content"));
                    out.println(result_data);
                }
                break;

            // 記事情報を一覧で取得する
            case "artReadList":
                sqldata = String.format("select * from art_table");
                st = con.prepareStatement(sqldata);
                rs = st.executeQuery();
                while (rs.next()) {
                    result_data = String.format("{\"art_id\":%s,\"art_name\":\"%s\",\"art_content\":\"%s\"}",
                            rs.getString("art_id"), rs.getString("art_name"), rs.getString("art_content"));
                    out.println(result_data + ";");
                }
                break;

            // artReadList,artUpdate,artDelete etc...
            default:
                out.println("{\"status_code\":300}");
                break;
            }
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}