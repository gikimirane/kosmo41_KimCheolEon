/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.33
 * Generated at: 2018-09-07 02:53:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class NewFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"utf-8\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"uft-8\" />\r\n");
      out.write("\t<title>summernote</title>\r\n");
      out.write("\t<link href=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js\"></script> \r\n");
      out.write("\t<script src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js\"></script> \r\n");
      out.write("\t\r\n");
      out.write("\t<link href=\"./dist/summernote.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script src=\"./dist/summernote.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("        /* summernote에서 이미지 업로드시 실행할 함수 */\r\n");
      out.write("\t \tfunction sendFile(file, editor) {\r\n");
      out.write("            // 파일 전송을 위한 폼생성\r\n");
      out.write("\t \t\tdata = new FormData();\r\n");
      out.write("\t \t    data.append(\"uploadFile\", file);\r\n");
      out.write("\t \t    $.ajax({ // ajax를 통해 파일 업로드 처리\r\n");
      out.write("\t \t        data : data,\r\n");
      out.write("\t \t        type : \"POST\",\r\n");
      out.write("\t \t        url : \"./summernote_imageUpload.jsp\",\r\n");
      out.write("\t \t        cache : false,\r\n");
      out.write("\t \t        contentType : false,\r\n");
      out.write("\t \t        processData : false,\r\n");
      out.write("\t \t        success : function(data) { // 처리가 성공할 경우\r\n");
      out.write("                    // 에디터에 이미지 출력\r\n");
      out.write("\t \t        \t$(editor).summernote('editor.insertImage', data.url);\r\n");
      out.write("\t \t        }\r\n");
      out.write("\t \t    });\r\n");
      out.write("\t \t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>summernote</h1>\r\n");
      out.write("\t<form name=\"writeForm\" action=\"./summernote_insert.jsp\" method=\"post\">\r\n");
      out.write("\t\t<textarea id=\"summernote\">Hello Summernote</textarea>\r\n");
      out.write("        <script>\r\n");
      out.write("            $(document).ready(function() {\r\n");
      out.write("                $('#summernote').summernote({ // summernote를 사용하기 위한 선언\r\n");
      out.write("                    height: 400,\r\n");
      out.write("\t\t\t\t\tcallbacks: { // 콜백을 사용\r\n");
      out.write("                        // 이미지를 업로드할 경우 이벤트를 발생\r\n");
      out.write("\t\t\t\t\t    onImageUpload: function(files, editor, welEditable) {\r\n");
      out.write("\t\t\t\t\t\t    sendFile(files[0], this);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t</script>\r\n");
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
