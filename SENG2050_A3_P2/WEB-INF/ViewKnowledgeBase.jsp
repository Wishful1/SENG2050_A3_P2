<%@ include file="head.jsp"%>
		<body class="anzac_walk_background">
			<%@ include file="navbar.jsp"%>
			<main>
				<section class="center_table">
					<h3>View Knowledge Base</h3>
					<table style="text-align: center;">
						<tr>
							<th>Title</th>
							<th>Category</th>
							<th>Resolution Details</th>
							<th>Date Resolved</th>
							<th>View</th>
						</tr>
						<c:forEach var="entry" items="${entries}">
							<tr>
								<td><p><c:out value="${entry.title()}"/></p></td>
								<td><p><c:out value="${entry.category()}"/></p></td>
								<td><p><c:out value="${entry.resolutionDtls()}"/></p></td>
								<td><p><c:out value="${entry.dateResolved()}"/></p></td>
								<td><a href="ViewSpecificIssue?issueID=${entry.issueID()}">View</a></td>
							</tr>
						</c:forEach>
					</table>
			</section>
		</main>
	</body>
</html>