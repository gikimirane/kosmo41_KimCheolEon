/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.33
 * Generated at: 2018-09-07 09:28:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.study.jsp.google.*;

public final class A01Main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("com.study.jsp.google");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>KOSMO Project02-Main</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"https://apis.google.com/js/platform.js\" async defer></script>\r\n");
      out.write("<meta name=\"google-signin-client_id\"\r\n");
      out.write("\tcontent=\"448134969775-n2cpnokuosg0kjcvbk2m90cota6o5beq.apps.googleusercontent.com\">\r\n");
      out.write("<style>\r\n");
      out.write("/* Remove the navbar's default margin-bottom and rounded borders */\r\n");
      out.write(".navbar {\r\n");
      out.write("\tmargin-bottom: 0;\r\n");
      out.write("\tborder-radius: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Add a gray background color and some padding to the footer */\r\n");
      out.write("footer {\r\n");
      out.write("\tbackground-color: #f2f2f2;\r\n");
      out.write("\tpadding: 25px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tvar ggID;\r\n");
      out.write("\tvar ggName;\r\n");
      out.write("\tvar ggImageURL;\r\n");
      out.write("\tvar ggEmail;\r\n");
      out.write("\tvar queryStringIN = \"\";\r\n");
      out.write("\tvar queryStringOUT = \"\";\r\n");
      out.write("\t");

		if(session.getAttribute("ggID") == null) {
	
      out.write("\r\n");
      out.write("\tfunction onSignIn(googleUser) {\r\n");
      out.write("\t\tvar profile = googleUser.getBasicProfile();\r\n");
      out.write("\t\tconsole.log('ID: ' + profile.getId());\r\n");
      out.write("\t\tconsole.log('Name: ' + profile.getName());\r\n");
      out.write("\t\tconsole.log('Image URL: ' + profile.getImageUrl());\r\n");
      out.write("\t\tconsole.log('Email: ' + profile.getEmail());\r\n");
      out.write("\r\n");
      out.write("\t\tggID = profile.getId();\r\n");
      out.write("\t\tggName = profile.getName();\r\n");
      out.write("\t\tggImageURL = profile.getImageUrl()\r\n");
      out.write("\t\tggEmail = profile.getEmail();\r\n");
      out.write("\t\tqueryStringIN = \"ggID=\" + ggID + \"&ggName=\" + ggName + \"&ggImageURL=\"\r\n");
      out.write("\t\t\t\t+ ggImageURL + \"&ggEmail=\" + ggEmail;\r\n");
      out.write("\r\n");
      out.write("\t\t/* alert(queryString); */\r\n");
      out.write("\r\n");
      out.write("\t\t$('#my-signin2').css('display', 'none');\r\n");
      out.write("\t\t$('#logout').css('display', 'block');\r\n");
      out.write("\t\t$('#upic').attr('src', profile.getImageUrl());\r\n");
      out.write("\t\t$('#uname').html('[ ' + profile.getName() + ' ]');\r\n");
      out.write("\r\n");
      out.write("\t\t/* localStorage.setItem(\"loginID\",profile.getId()); */\r\n");
      out.write("\t\t/* \t\tsessionStorage.setItem(\"loginID\", profile.getId());\r\n");
      out.write("\t\t alert(sessionStorage.getItem('loginID')); */\r\n");
      out.write("\t\t/* alert(ggID);\r\n");
      out.write("\t\talert(ggName);\r\n");
      out.write("\t\talert(ggImageURL);\r\n");
      out.write("\t\talert(ggEmail); */\r\n");
      out.write("\t\tlogin_submit_ajax();\r\n");
      out.write("\t}\r\n");
      out.write("\t");

		}
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\tfunction onFailure(error) {\r\n");
      out.write("\t\talert(\"접속 중 에러가 발생하였습니다.\");\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction signOut() {\r\n");
      out.write("\t\tvar auth2 = gapi.auth2.getAuthInstance();\r\n");
      out.write("\t\tauth2.signOut().then(function() {\r\n");
      out.write("\t\t\tconsole.log('User signed out.');\r\n");
      out.write("\r\n");
      out.write("\t\t\t$('#my-signin2').css('display', 'block');\r\n");
      out.write("\t\t\t$('#logout').css('display', 'none');\r\n");
      out.write("\t\t\t$('#upic').attr('src', '');\r\n");
      out.write("\t\t\t$('#uname').html('');\r\n");
      out.write("\r\n");
      out.write("\t\t\t/* localStorage.removeItem(\"loginID\"); */\r\n");
      out.write("\t\t\t/* sessionStorage.removeItem(\"loginID\"); */\r\n");
      out.write("\t\t\tlogout_submit_ajax();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t/* alert(\"로딩완료\"); */\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\tvar auth2; // The Sign-In object.\r\n");
      out.write("\tvar googleUser; // The current user.\r\n");
      out.write("\r\n");
      out.write("\t/**\r\n");
      out.write("\t * Calls startAuth after Sign in V2 finishes setting up.\r\n");
      out.write("\t */\r\n");
      out.write("\tvar appStart = function() {\r\n");
      out.write("\t  gapi.load('auth2', initSigninV2);\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\t/**\r\n");
      out.write("\t * Initializes Signin v2 and sets up listeners.\r\n");
      out.write("\t */\r\n");
      out.write("\tvar initSigninV2 = function() {\r\n");
      out.write("\t  auth2 = gapi.auth2.init({\r\n");
      out.write("\t      client_id: 'CLIENT_ID.apps.googleusercontent.com',\r\n");
      out.write("\t      scope: 'profile'\r\n");
      out.write("\t  });\r\n");
      out.write("\r\n");
      out.write("\t  // Listen for sign-in state changes.\r\n");
      out.write("\t  auth2.isSignedIn.listen(signinChanged);\r\n");
      out.write("\r\n");
      out.write("\t  // Listen for changes to current user.\r\n");
      out.write("\t  auth2.currentUser.listen(userChanged);\r\n");
      out.write("\r\n");
      out.write("\t  // Sign in the user if they are currently signed in.\r\n");
      out.write("\t  if (auth2.isSignedIn.get() == true) {\r\n");
      out.write("\t    auth2.signIn();\r\n");
      out.write("\t  }\r\n");
      out.write("\r\n");
      out.write("\t  // Start with the current live values.\r\n");
      out.write("\t  refreshValues();\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\t/**\r\n");
      out.write("\t * Listener method for sign-out live value.\r\n");
      out.write("\t *\r\n");
      out.write("\t * @param {boolean} val the updated signed out state.\r\n");
      out.write("\t */\r\n");
      out.write("\tvar signinChanged = function (val) {\r\n");
      out.write("\t  console.log('Signin state changed to ', val);\r\n");
      out.write("\t  document.getElementById('signed-in-cell').innerText = val;\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\t/**\r\n");
      out.write("\t * Listener method for when the user changes.\r\n");
      out.write("\t *\r\n");
      out.write("\t * @param {GoogleUser} user the updated user.\r\n");
      out.write("\t */\r\n");
      out.write("\tvar userChanged = function (user) {\r\n");
      out.write("\t  console.log('User now: ', user);\r\n");
      out.write("\t  googleUser = user;\r\n");
      out.write("\t  updateGoogleUser();\r\n");
      out.write("\t  document.getElementById('curr-user-cell').innerText =\r\n");
      out.write("\t    JSON.stringify(user, undefined, 2);\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\t/**\r\n");
      out.write("\t * Updates the properties in the Google User table using the current user.\r\n");
      out.write("\t */\r\n");
      out.write("\tvar updateGoogleUser = function () {\r\n");
      out.write("\t  if (googleUser) {\r\n");
      out.write("\t    document.getElementById('user-id').innerText = googleUser.getId();\r\n");
      out.write("\t    document.getElementById('user-scopes').innerText =\r\n");
      out.write("\t      googleUser.getGrantedScopes();\r\n");
      out.write("\t    document.getElementById('auth-response').innerText =\r\n");
      out.write("\t      JSON.stringify(googleUser.getAuthResponse(), undefined, 2);\r\n");
      out.write("\t  } else {\r\n");
      out.write("\t    document.getElementById('user-id').innerText = '--';\r\n");
      out.write("\t    document.getElementById('user-scopes').innerText = '--';\r\n");
      out.write("\t    document.getElementById('auth-response').innerText = '--';\r\n");
      out.write("\t  }\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\t/**\r\n");
      out.write("\t * Retrieves the current user and signed in states from the GoogleAuth\r\n");
      out.write("\t * object.\r\n");
      out.write("\t */\r\n");
      out.write("\tvar refreshValues = function() {\r\n");
      out.write("\t  if (auth2){\r\n");
      out.write("\t    console.log('Refreshing values...');\r\n");
      out.write("\r\n");
      out.write("\t    googleUser = auth2.currentUser.get();\r\n");
      out.write("\r\n");
      out.write("\t    document.getElementById('curr-user-cell').innerText =\r\n");
      out.write("\t      JSON.stringify(googleUser, undefined, 2);\r\n");
      out.write("\t    document.getElementById('signed-in-cell').innerText =\r\n");
      out.write("\t      auth2.isSignedIn.get();\r\n");
      out.write("\r\n");
      out.write("\t    updateGoogleUser();\r\n");
      out.write("\t  }\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*************************************************************/\r\n");
      out.write("\r\n");
      out.write("\tfunction login_submit_ajax() {\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : 'acclogin.do',\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tdata : queryStringIN,\r\n");
      out.write("\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\tsuccess : function(json) {\r\n");
      out.write("\t\t\t\tvar result = eval(json);\r\n");
      out.write("\t\t\t\tif (result[0].result == \"ok\") {\r\n");
      out.write("\t\t\t\t\t/* alert(\"setOK\"); */\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\talert(result[0].desc);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction logout_submit_ajax() {\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : 'acclogout.do',\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tdata : queryStringOUT,\r\n");
      out.write("\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\tsuccess : function(json) {\r\n");
      out.write("\t\t\t\tvar result = eval(json);\r\n");
      out.write("\t\t\t\tif (result[0].result == \"ok\") {\r\n");
      out.write("\t\t\t\t\talert(\"delOK\");\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\talert(result[0].desc);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container-fluid bg-primary\">\r\n");
      out.write("\t\t<h3>Cheol-Eon Kim's Record</h3>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\"\r\n");
      out.write("\t\t\t\t\tdata-target=\"#myNavbar\">\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"#\">Portfolio</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t<li class=\"active\"><a href=\"A01Main.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">About</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"list.do\">WebBoard</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href='#'\r\n");
      out.write("\t\t\t\t\t\tonclick='javascript:window.open(\"http://www.naver.com\",\"name99\", \"width=500px,height=650px,left=100px,top=100px\");'>testNaver</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t<div id=\"login\" class=\"g-signin2\" data-onsuccess=\"onSignIn\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div id=\"logout\" style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" onclick=\"signOut();\" value=\"로그아웃\" /><br>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<img id=\"upic\" src=\"\"><br> <span id=\"uname\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<div class=\"jumbotron\">\r\n");
      out.write("\t\t<div class=\"container bg-3 text-center\">\r\n");
      out.write("\t\t\t<h1>My Portfolio</h1>\r\n");
      out.write("\t\t\t<p>Some text that represents \"Me\"...</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"container-fluid bg-3 text-center\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t<p>Some text..</p>\r\n");
      out.write("\t\t\t\t<img src=\"https://placehold.it/150x80?text=IMAGE\"\r\n");
      out.write("\t\t\t\t\tclass=\"img-responsive\" style=\"width: 100%\" alt=\"Image\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t<p>Some text..</p>\r\n");
      out.write("\t\t\t\t<img src=\"https://placehold.it/150x80?text=IMAGE\"\r\n");
      out.write("\t\t\t\t\tclass=\"img-responsive\" style=\"width: 100%\" alt=\"Image\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t<p>Some text..</p>\r\n");
      out.write("\t\t\t\t<img src=\"https://placehold.it/150x80?text=IMAGE\"\r\n");
      out.write("\t\t\t\t\tclass=\"img-responsive\" style=\"width: 100%\" alt=\"Image\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t<p>Some text..</p>\r\n");
      out.write("\t\t\t\t<img src=\"https://placehold.it/150x80?text=IMAGE\"\r\n");
      out.write("\t\t\t\t\tclass=\"img-responsive\" style=\"width: 100%\" alt=\"Image\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container-fluid bg-3 text-center\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t<p>Some text..</p>\r\n");
      out.write("\t\t\t\t<img src=\"https://placehold.it/150x80?text=IMAGE\"\r\n");
      out.write("\t\t\t\t\tclass=\"img-responsive\" style=\"width: 100%\" alt=\"Image\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t<p>Some text..</p>\r\n");
      out.write("\t\t\t\t<img src=\"https://placehold.it/150x80?text=IMAGE\"\r\n");
      out.write("\t\t\t\t\tclass=\"img-responsive\" style=\"width: 100%\" alt=\"Image\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t<p>Some text..</p>\r\n");
      out.write("\t\t\t\t<img src=\"https://placehold.it/150x80?text=IMAGE\"\r\n");
      out.write("\t\t\t\t\tclass=\"img-responsive\" style=\"width: 100%\" alt=\"Image\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t<p>Some text..</p>\r\n");
      out.write("\t\t\t\t<img src=\"https://placehold.it/150x80?text=IMAGE\"\r\n");
      out.write("\t\t\t\t\tclass=\"img-responsive\" style=\"width: 100%\" alt=\"Image\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\r\n");
      out.write("\t<footer class=\"container-fluid text-center\">\r\n");
      out.write("\t\t<p>Footer Text</p>\r\n");
      out.write("\t</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
