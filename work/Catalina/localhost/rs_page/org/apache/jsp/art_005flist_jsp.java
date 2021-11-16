/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2021-11-16 14:42:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class art_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String member_id = "";
Cookie[] cks = request.getCookies();
if(cks != null){
    for(int ck=0; ck<cks.length; ck++){
            if(cks[ck].getName().equals("member_id")){
                    member_id = cks[ck].getValue();
            }
    }
}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ja\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <script src=\"./js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./css/rs_keijiban.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./css/rs_keijiban_art_list.css\">\r\n");
      out.write("    \r\n");
      out.write("    <script>\r\n");
      out.write("        var res_data,lines,jsondata;\r\n");
      out.write("        $(function(){\r\n");
      out.write("            $('.menu-btn').on('click', function(){\r\n");
      out.write("                $('.menu').toggleClass('is-active');\r\n");
      out.write("            });\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                    type: \"POST\",\r\n");
      out.write("                    url: \"http://localhost:8080/rs_page/connect\",\r\n");
      out.write("                    scriptCharset: 'utf-8',\r\n");
      out.write("                    data: {mode:\"artReadList\"}\r\n");
      out.write("                }).done(function(data){\r\n");
      out.write("                    // alert(data); レスポンスデータのデバッグ\r\n");
      out.write("\r\n");
      out.write("                    lines = data.split(';');\r\n");
      out.write("                    var art_count = 0;\r\n");
      out.write("                    //jsonデータの整形とhtmlタグの生成\r\n");
      out.write("                    for(var i in lines){\r\n");
      out.write("                        \r\n");
      out.write("                        // 文字列チェック\r\n");
      out.write("                        if(lines[i].match(/art/)){\r\n");
      out.write("                            jsondata = JSON.parse(lines[i]);\r\n");
      out.write("                        }else{\r\n");
      out.write("                            continue;\r\n");
      out.write("                        }\r\n");
      out.write("                        var paragraph = $('<h2></h2>');\r\n");
      out.write("                        var contents = $('<p></p>');\r\n");
      out.write("                        var art_cont = $('<div class=\"\" id=\"art_'+art_count+'\"></div>');\r\n");
      out.write("                        paragraph.html(jsondata.art_name);\r\n");
      out.write("                        contents.html(jsondata.art_content);\r\n");
      out.write("                        $('#art_list').append(art_cont);\r\n");
      out.write("                        $('#art_'+art_count).append(paragraph);\r\n");
      out.write("                        $('#art_'+art_count).append(contents);\r\n");
      out.write("                        art_count++;\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("        });\r\n");
      out.write(" \r\n");
      out.write("    </script>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\r\n");
      out.write("    <title>記事一覧 / RS合同研究室</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <header class=\"jumbotron\" style=\"background: url('image/member/5/1.jpg');background-size: cover;\"></header>\r\n");
      out.write("    <!-- <div class=\"border row text-center \">\r\n");
      out.write("        <a href=\"\" class=\"col-sm-4 head_list p-4\"><div >投稿記事</div></a>\r\n");
      out.write("        <a href=\"\" class=\"col-sm-4 head_list p-4\"><div >制作物</div></a>\r\n");
      out.write("        <a href=\"\" class=\"col-sm-4 head_list p-4\"><div >マイページ</div></a>\r\n");
      out.write("    </div> -->\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"m-0 mt-4\" style=\"text-align:right;\">\r\n");
      out.write("            <button class=\"btn btn-outline-secondary pt-2 pb-2 menu-btn\" type=\"button\" >\r\n");
      out.write("                <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"30\" height=\"30\" fill=\"currentColor\" class=\"bi bi-justify\" viewBox=\"0 0 16 16\">\r\n");
      out.write("                    <path fill-rule=\"evenodd\" d=\"M2 12.5a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5zm0-3a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5zm0-3a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5zm0-3a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5z\"/>\r\n");
      out.write("                </svg>\r\n");
      out.write("            </button>\r\n");
      out.write("              <div class=\"menu\">\r\n");
      out.write("                <div class=\"menu__item\">TOP</div>\r\n");
      out.write("                <div class=\"menu__item\">ABOUT</div>\r\n");
      out.write("                <div class=\"menu__item\">BLOG</div>\r\n");
      out.write("                <div class=\"menu__item\">CONTACT</div>\r\n");
      out.write("              </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <main class=\"main\">\r\n");
      out.write("        <div class=\"header\">\r\n");
      out.write("            <h2 class=\"header h1\">記事一覧</h2>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"art_list\" id=\"art_list\"></div>\r\n");
      out.write("    </main>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
