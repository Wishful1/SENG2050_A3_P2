<%@ include file="head.jsp"%>
		<body class="anzac_walk_background">
			<%@ include file="navbar.jsp"%>
			<main>
				<section class="center_table">
					<h3>View Issues</h3>
					<table style="text-align: center;">
						<tr>
							<th>Issue ID</th>
							<th>Reporter ID</th>
							<th>Issue Status</th>
							<th>Category</th>
							<th>Title</th>
							<th>Date Reported</th>
							<th>Resolution Details</th>
							<th>Date Resolved</th>
							<th>View</th>
						</tr>
						<c:forEach var="issue" items="${issues}">
							<tr>
								<td><p><c:out value="${issue.issueID()}"/></p></td>
								<td><p><c:out value="${issue.reporterID()}"/></p></td>
								<td><p><c:out value="${issue.issueStatus()}"/></p></td>
								<td><p><c:out value="${issue.category()}"/></p></td>
								<td><p><c:out value="${issue.title()}"/></p></td>
								<td><p><c:out value="${issue.dateReported()}"/></p></td>
								<td><p><c:out value="${issue.resolutionDtls()}"/></p></td>
								<td><p><c:out value="${issue.dateResolved()}"/></p></td>
								<td><a href="ViewSpecificIssue?issueID=${issue.issueID()}">View Issue</a></td>
							</tr>
						</c:forEach>
					</table>
			</section>
		</main>
	</body>
</html>