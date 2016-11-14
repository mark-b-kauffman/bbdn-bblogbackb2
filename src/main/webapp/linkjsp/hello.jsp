<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="blackboard.persist.*,
        blackboard.platform.*,
        blackboard.platform.plugin.*,
	   blackboard.platform.context.*,
	   blackboard.persist.content.*,
	   blackboard.persist.course.*,
   	   blackboard.data.content.*,
	   blackboard.data.course.*"

	errorPage="/error.jsp"
%>
<%@page import="java.util.Hashtable,
      java.util.Vector,

      blackboard.base.BbList,
      blackboard.data.course.Course,
      blackboard.db.ConnectionManager,
      blackboard.db.DbUtil,
      blackboard.persist.BbPersistenceManager,
      blackboard.persist.Id,
      blackboard.persist.KeyNotFoundException,
      blackboard.persist.PkId,
      blackboard.platform.BbServiceManager,
      blackboard.platform.session.BbSession,
      blackboard.data.user.User"
%>
<%-- Deprecated. Don't use these.
<%@ taglib uri="/bbUI" prefix="bbUI"%>
<%@ taglib uri="/bbData" prefix="bbData"%> 
--%>
<%@ taglib uri="/bbNG" prefix="bbNG"%>

<!-- Deprecated. bbData:context id="ctx"  Use learningSystemPage ctxId="ctx" instead. -->

<%
	String contentIdString = request.getParameter("content_id");
	String courseIdString = request.getParameter("course_id");

	System.out.println("in player content id " + contentIdString);
	System.out.println("in player course id " + courseIdString);

	Id contentId = Id.generateId(Content.DATA_TYPE,contentIdString);
	Id courseId = Id.generateId(Course.DATA_TYPE,courseIdString);
	String courseContentURL = PlugInUtil.getEditableContentReturnURL(contentId, courseId);

	System.out.println("cc url " + courseContentURL);

	String title;
	title = "The title string";
%>

<bbNG:learningSystemPage ctxId="ctx" title="Just to Say Hello!" hideCourseMenu="false">
    
    		<bbNG:pageHeader>
			<bbNG:pageTitleBar>
				"bbNG:pageHeader.pageTitleBar"
			</bbNG:pageTitleBar>
		</bbNG:pageHeader>
<html>
<body>
<h3>Spring ExtLinkDemo - Learning Systems Page - Hello</h3>
<ul>
<li><a href="helloWorld">Hello World</a>
</ul>
There are no iframe tags in this .jsp page.
</body>
</html>

</bbNG:learningSystemPage>
<!-- /bbData:context -->

