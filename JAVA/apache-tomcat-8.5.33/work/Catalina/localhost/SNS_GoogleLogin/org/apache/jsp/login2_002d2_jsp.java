/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.33
 * Generated at: 2018-09-06 03:35:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login2_002d2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <script src=\"https://apis.google.com/js/api:client.js\"></script>\r\n");
      out.write("  <script>\r\n");
      out.write("  var googleUser = {};\r\n");
      out.write("  var startApp = function() {\r\n");
      out.write("    gapi.load('auth2', function(){\r\n");
      out.write("      // Retrieve the singleton for the GoogleAuth library and set up the client.\r\n");
      out.write("      auth2 = gapi.auth2.init({\r\n");
      out.write("        client_id: '448134969775-n2cpnokuosg0kjcvbk2m90cota6o5beq.apps.googleusercontent.com',\r\n");
      out.write("        cookiepolicy: 'single_host_origin',\r\n");
      out.write("        // Request scopes in addition to 'profile' and 'email'\r\n");
      out.write("        //scope: 'additional_scope'\r\n");
      out.write("      });\r\n");
      out.write("      attachSignin(document.getElementById('customBtn'));\r\n");
      out.write("    });\r\n");
      out.write("  };\r\n");
      out.write("\r\n");
      out.write("  function attachSignin(element) {\r\n");
      out.write("    console.log(element.id);\r\n");
      out.write("    auth2.attachClickHandler(element, {},\r\n");
      out.write("        function(googleUser) {\r\n");
      out.write("          document.getElementById('name').innerText = \"Signed in: \" +\r\n");
      out.write("              googleUser.getBasicProfile().getName();\r\n");
      out.write("        }, function(error) {\r\n");
      out.write("          alert(JSON.stringify(error, undefined, 2));\r\n");
      out.write("        });\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  /**\r\n");
      out.write("   * The Sign-In client object.\r\n");
      out.write("   */\r\n");
      out.write("  var auth2;\r\n");
      out.write("\r\n");
      out.write("  /**\r\n");
      out.write("   * Initializes the Sign-In client.\r\n");
      out.write("   */\r\n");
      out.write("  var initClient = function() {\r\n");
      out.write("      gapi.load('auth2', function(){\r\n");
      out.write("          /**\r\n");
      out.write("           * Retrieve the singleton for the GoogleAuth library and set up the\r\n");
      out.write("           * client.\r\n");
      out.write("           */\r\n");
      out.write("          auth2 = gapi.auth2.init({\r\n");
      out.write("              client_id: 'CLIENT_ID.apps.googleusercontent.com'\r\n");
      out.write("          });\r\n");
      out.write("\r\n");
      out.write("          // Attach the click handler to the sign-in button\r\n");
      out.write("          auth2.attachClickHandler('signin-button', {}, onSuccess, onFailure);\r\n");
      out.write("      });\r\n");
      out.write("  };\r\n");
      out.write("\r\n");
      out.write("  /**\r\n");
      out.write("   * Handle successful sign-ins.\r\n");
      out.write("   */\r\n");
      out.write("  var onSuccess = function(user) {\r\n");
      out.write("      console.log('Signed in as ' + user.getBasicProfile().getName());\r\n");
      out.write("   };\r\n");
      out.write("\r\n");
      out.write("  /**\r\n");
      out.write("   * Handle sign-in failures.\r\n");
      out.write("   */\r\n");
      out.write("  var onFailure = function(error) {\r\n");
      out.write("      console.log(error);\r\n");
      out.write("  };\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  </script>\r\n");
      out.write("  <style type=\"text/css\">\r\n");
      out.write("    #customBtn {\r\n");
      out.write("      display: inline-block;\r\n");
      out.write("      background: white;\r\n");
      out.write("      color: #444;\r\n");
      out.write("      width: 190px;\r\n");
      out.write("      border-radius: 5px;\r\n");
      out.write("      border: thin solid #888;\r\n");
      out.write("      box-shadow: 1px 1px 1px grey;\r\n");
      out.write("      white-space: nowrap;\r\n");
      out.write("    }\r\n");
      out.write("    #customBtn:hover {\r\n");
      out.write("      cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("    span.label {\r\n");
      out.write("      font-family: serif;\r\n");
      out.write("      font-weight: normal;\r\n");
      out.write("    }\r\n");
      out.write("    span.icon {\r\n");
      out.write("      background: url('/identity/sign-in/g-normal.png') transparent 5px 50% no-repeat;\r\n");
      out.write("      display: inline-block;\r\n");
      out.write("      vertical-align: middle;\r\n");
      out.write("      width: 42px;\r\n");
      out.write("      height: 42px;\r\n");
      out.write("    }\r\n");
      out.write("    span.buttonText {\r\n");
      out.write("      display: inline-block;\r\n");
      out.write("      vertical-align: middle;\r\n");
      out.write("      padding-left: 42px;\r\n");
      out.write("      padding-right: 42px;\r\n");
      out.write("      font-size: 14px;\r\n");
      out.write("      font-weight: bold;\r\n");
      out.write("      /* Use the Roboto font that is loaded in the <head> */\r\n");
      out.write("      font-family: 'Roboto', sans-serif;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("  <!-- In the callback, you would hide the gSignInWrapper element on a\r\n");
      out.write("  successful sign in -->\r\n");
      out.write("  <div id=\"gSignInWrapper\">\r\n");
      out.write("    <span class=\"label\">Sign in with:</span>\r\n");
      out.write("    <div id=\"customBtn\" class=\"customGPlusSignIn\">\r\n");
      out.write("      <span class=\"icon\"></span>\r\n");
      out.write("      <span class=\"buttonText\">Google</span>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div id=\"name\"></div>\r\n");
      out.write("  <script>startApp();</script>\r\n");
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