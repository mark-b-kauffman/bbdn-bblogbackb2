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
      blackboard.data.ExtendedData,
      blackboard.data.user.User"
%>
<%-- Deprecated. Don't use these.
<%@ taglib uri="/bbUI" prefix="bbUI"%>
<%@ taglib uri="/bbData" prefix="bbData"%> 
--%>
<%@ taglib uri="/bbNG" prefix="bbNG"%>

<!-- Deprecated. bbData:context id="ctx"  Use learningSystemPage ctxId="ctx" instead. -->
<bbNG:learningSystemPage ctxId="ctx" title="User & Item data!" hideCourseMenu="false">
    
<%

	String contentIdString = request.getParameter("content_id");
	String courseIdString = request.getParameter("course_id");

        // Inserted code here to get the assetId from the ExtendedData
        BbPersistenceManager bbPm = BbServiceManager.getPersistenceService().getDbPersistenceManager();
        Container bbContainer = bbPm.getContainer();

        Id contentId = new PkId( bbContainer, CourseDocument.DATA_TYPE, request.getParameter("content_id") );

        ContentDbLoader courseDocumentLoader = (ContentDbLoader) bbPm.getLoader( ContentDbLoader.TYPE );
        Content courseDoc = courseDocumentLoader.loadById( contentId );
        ExtendedData ed = courseDoc.getExtendedData();
        String assetIdString = ed.getValue("assetId");
        // End Insert

	System.out.println("in player content id " + contentIdString);
	System.out.println("in player course id " + courseIdString);

	Id thisContentId = Id.generateId(Content.DATA_TYPE,contentIdString);
	Id thisCourseId = Id.generateId(Course.DATA_TYPE,courseIdString);
	String courseContentURL = PlugInUtil.getEditableContentReturnURL(thisContentId, thisCourseId);

        User sessionUser = ctx.getUser();
        Id userId = sessionUser.getId();
        String userNameString = sessionUser.getUserName();

        blackboard.data.user.User.SystemRole systemRole = sessionUser.getSystemRole();
        String systemRoleIdentifier = systemRole.getIdentifier();
        String systemRoleDisplayName = systemRole.getDisplayName();
  
	System.out.println("cc url " + courseContentURL);

	String title;
	title = "The title string";
%>


    
    		<bbNG:pageHeader>
                    	<bbNG:breadcrumbBar environment="COURSE">
                            <bbNG:breadcrumb>Asset ID: <%= assetIdString %> </bbNG:breadcrumb>
                        </bbNG:breadcrumbBar>
			<bbNG:pageTitleBar>
				"bbNG:pageHeader.pageTitleBar"
			</bbNG:pageTitleBar>
		</bbNG:pageHeader>
<html>
<body>
<h3>Spring ExtLinkDemo - Learning Systems Page - Content Item!</h3>
Your systemRole is <%= systemRoleDisplayName %><br>
It's identifier is <%= systemRoleIdentifier %><br>
The assetId passed to this Content item via ExtendedData is <%= assetIdString %> <br>

</body>
</html>

</bbNG:learningSystemPage>
<!-- /bbData:context -->

