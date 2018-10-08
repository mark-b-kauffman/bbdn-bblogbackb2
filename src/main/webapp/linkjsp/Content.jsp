<!--
 /*
   Blackboard Inc Test Content JSP
 */ -->

<%@page language="java" pageEncoding="ISO-8859-1" %>

<%@page import="blackboard.platform.plugin.PlugInUtil" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib uri="/bbNG" prefix="bbNG" %>
<!-- %@taglib uri="/bbData" prefix="bbData"% -->

<!-- bbData:context id="ctx" -->

<%

final String page_title = "Logback Content";
// Passed from Blackboard.
String course_id = request.getParameter("course_id");

Boolean courseHasBeenReset = false;
Boolean useOldLayout = false;
%>
    <bbNG:learningSystemPage ctxId="ctx" title="Content.jsp">

      <bbNG:pageHeader instructions="pageHeader instructions">
        <bbNG:breadcrumbBar environment="COURSE">
          <bbNG:breadcrumb title="Content.jsp"/>
        </bbNG:breadcrumbBar>

          <bbNG:pageTitleBar title="Content.jsp pageTitleBar" />  		
      </bbNG:pageHeader>

            <div >


                          Does the left Nav re-appear after we shrink/resize the browser window?

            </div>

    </bbNG:learningSystemPage>
<!-- /bbData:context -->
