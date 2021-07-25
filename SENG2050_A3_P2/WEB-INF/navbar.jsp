<nav style="overflow: hidden;">
	<%if (request.isUserInRole("STAFF")) {%>
	<h1>IT Services - Staff</h1>
	<%} else {%>
	<h1>IT Services</h1>
	<%}%>
	<ul>
		<li><p><a href="Homepage">Home</a></p></li>
		<li><p><a href="ReportIssue">Report an Issue</a></p></li>
		<li><p><a href="ViewIssues">View Issues</a></p></li>
		<li><p><a href="ViewKnowledgeBase">View Knowledge Bases</a></p></li>
		<%if (request.isUserInRole("STAFF")) {%>
			<li><p><a href="ScheduleMaintenance">Schedule Maintenance</a></p></li>
		<%}%>
		<li style="float: right; padding-right: 1.5%;"><p><a href="Logout">Logout</a></p></li>
	</ul>
	<c:if test="${scheduledMaintenance[0] != null}"><p style="background-color: rgb(155, 16, 155); width: 100%; padding-top: 2em; padding-bottom: 2em;">Please note that there is scheduled maintenance from <c:out value="${scheduledMaintenance[0]}"/> to <c:out value="${scheduledMaintenance[1]}"/> for <c:out value="${scheduledMaintenance[2]}"/></p></c:if>
</nav>