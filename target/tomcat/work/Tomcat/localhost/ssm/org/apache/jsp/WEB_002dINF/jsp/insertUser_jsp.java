/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-10-11 00:42:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insertUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/jsp/../commonJsp/common.jsp", Long.valueOf(1539167247041L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t#insertForm>div{\r\n");
      out.write("\t\tmargin-bottom: 10px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<link rel=\"stylesheet\"  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.min.css\"> \r\n");
      out.write("<link rel=\"stylesheet\"  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap-theme.css\">\r\n");
      out.write("<script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/bootstrap-notify.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/common.js\"></script>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#insertUser\">增加用户</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 模态框（Modal） -->\r\n");
      out.write("\t\t<div class=\"modal fade\" id=\"insertUser\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t    <div class=\"modal-dialog\">\r\n");
      out.write("\t\t        <div class=\"modal-content\">\r\n");
      out.write("\t\t            <div class=\"modal-header\">\r\n");
      out.write("\t\t                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\r\n");
      out.write("\t\t                <h4 class=\"modal-title\" id=\"myModalLabel\">添加用户</h4>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t            <div class=\"modal-body  contentBody\">\r\n");
      out.write("\t\t            \t\t<form action=\"\"  id=\"insertForm\">\r\n");
      out.write("\t\t            \t\t\t\t<div class=\"row\"><div class=\"col-md-2 col-md-offset-3\">用户名：</div><div class=\"col-md-5\"><input type=\"text\" id=\"userName\" name=\"userName\" /></div></div>\r\n");
      out.write("\t\t            \t\t\t\t<div class=\"row\"><div class=\"col-md-2 col-md-offset-3\" >密码：</div><div class=\"col-md-5\"><input type=\"password\" id=\"password\" name=\"password\"/></div></div>\r\n");
      out.write("\t\t            \t\t\t\t<div class=\"row\"><div class=\"col-md-2 col-md-offset-3\">年龄：</div><div class=\"col-md-5\"><input type=\"text\" id=\"age\" name=\"age\" /></div></div>\r\n");
      out.write("\t\t            \t\t</form>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t            <div class=\"modal-footer\">\r\n");
      out.write("\t\t                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\r\n");
      out.write("\t\t                <button type=\"button\" class=\"btn btn-primary\"  id=\"insert\">添加</button>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t        </div><!-- /.modal-content -->\r\n");
      out.write("\t\t    </div><!-- /.modal -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#insert\").click(function(){\r\n");
      out.write("\t\t\t\t$('#insertUser').modal('hide');\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\t\t\turl:'/ssm/user/insertUser',\r\n");
      out.write("\t\t\t\t\t\tdata:$(\"#insertForm\").serialize(),\r\n");
      out.write("\t\t\t\t\t\tdataType:'html',\r\n");
      out.write("\t\t\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(\"success\");\r\n");
      out.write("\t\t\t\t\t\t\tnotifyMsg(data);\r\n");
      out.write("\t\t                }\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
