<!-- File: insertCourseLink.jsp -->
<!-- Purpose: Insert a CourseLink that links to hello.jsp. The same functionality as insertExternalLink.jsp -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isThreadSafe="true"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="blackboard.base.*,
			blackboard.cms.filesystem.*,
			blackboard.data.*,
			blackboard.data.content.*,
			blackboard.data.course.*,
			blackboard.data.registry.*,
			blackboard.data.role.PortalRole,
			blackboard.data.user.*,
			blackboard.persist.role.*,
			blackboard.persist.*,
			blackboard.persist.user.*,
			blackboard.persist.course.*,
			blackboard.persist.content.*,
			blackboard.persist.registry.*,
			blackboard.platform.*,
			blackboard.platform.context.*,
			blackboard.platform.persistence.*,
			blackboard.platform.BbServiceManager,
			blackboard.platform.servlet.*,
			blackboard.platform.intl.BundleManager,
			blackboard.platform.intl.BbResourceBundle,
			blackboard.platform.filesystem.*,
			blackboard.platform.plugin.*,
			blackboard.platform.plugin.PlugInUtil,
			blackboard.util.*"

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

<!-- Deprecated. Don't use these %@ taglib uri="/bbUI" prefix="bbUI"% -->
<!-- Deprecated. %@ taglib uri="/bbData" prefix="bbData"% -->
<%@ taglib uri="/bbNG" prefix="bbNG"%>

<%
	String courseIdString = request.getParameter("course_id");
	String contentIdString = request.getParameter("content_id");

        String redirectUrl = "https://www.blackboard.com";
	String title = "";

	Id courseIdValue = Id.generateId(Course.DATA_TYPE,courseIdString);

	BbSession bbSession = BbServiceManager.getSessionManagerService().getSession(request);
	String userID = bbSession.getUserName();
	Id userIdValue = bbSession.getUserId();

	try {
		BbPersistenceManager bbPm = BbServiceManager.getPersistenceService().getDbPersistenceManager();
		Id courseId = bbPm.generateId(Course.DATA_TYPE,courseIdString);
		Id contentId = bbPm.generateId(Content.DATA_TYPE,contentIdString);

		if (contentIdString != null) {
                                title = "2015.03.18.15.18 Item that links to itemdata.jsp!";
                                String assetId = "OU812";
	
                                String description = "Item that points to a .jsp page in this B2 that shows you the assetId and your user data.";

				String URL;

				String bbUid = ContextManagerFactory.getInstance().getContext().getVirtualInstallation().getBbUid();
                             
                                URL = "../../bb-SpringExtLinkDemo-" + bbUid + "/linkjsp/hello.jsp?course_id=" + courseIdString + "&content_id=" + contentIdString;
 
				// add the link
                                Content item = new Content();
                                item.setTitle( title );
                                item.setBody( new FormattedText( description, FormattedText.Type.HTML ) );
                                item.setParentId( contentId );
                                item.setCourseId( courseId );
                                item.setContentHandler( "resource/x-insertitem" );
                                item.setIsAvailable(true);
                                // item.setRenderType(Content.RenderType.LINK); // Not necessary with <cpview value="linkjsp/itemdata.jsp"/>
                                ExtendedData extendedData = new ExtendedData();
                                extendedData.setValue( "assetId", assetId );
                                item.setExtendedData( extendedData );
		
				ContentDbPersister contentPersister = (ContentDbPersister) bbPm.getPersister( ContentDbPersister.TYPE );
				contentPersister.persist( item );

	
		} else {
			response.sendRedirect(redirectUrl);
		}
	} catch (Exception ex) {
		%>Error:&nbsp;<%=ex.getMessage()%><%
	}

	String backAnchor = "<a href=\"javascript:window.history.back();\"><img src=\"../images/BackArrow50.jpeg\" alt=\"back\"></a>";
	String message = "Inserted \"" + title;
%>

<bbNG:learningSystemPage ctxId="ctx" title="Inserted External Link &reg;">
	<bbNG:pageHeader>
			<bbNG:breadcrumbBar environment="COURSE">
                            <bbNG:breadcrumb>Inserted Links</bbNG:breadcrumb>
                        </bbNG:breadcrumbBar>
			<bbNG:pageTitleBar iconUrl="../images/sm_logo.gif">
			<%=message%>
		</bbNG:pageTitleBar>
	</bbNG:pageHeader>
<div align="right">
	<%=backAnchor%>
</div>

Your link has been inserted! Press the "Back" button to view your link.


</bbNG:learningSystemPage>

