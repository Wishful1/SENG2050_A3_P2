<%@ include file="head.jsp"%>
		<body class="anzac_walk_background">
		<%@ include file="navbar.jsp"%>
		<main>
			<section>
                <h3>Viewing Specific Issue Details</h3>
                <p>Issue ID: <c:out value="${issue.issueID()}"/></p>
                <p>Reporter: <c:out value="${issue.reporterID()}"/></p>
                <p>Current Status: <c:out value="${issue.issueStatus()}"/></p>
                <p>Category: <c:out value="${issue.category()}"/></p>
                <p>Title: <c:out value="${issue.title()}"/></p>
                <p>Description: <c:out value="${issue.issueDtls()}"/></p>
                <p>Date Reported: <c:out value="${issue.dateReported()}"/></p>
                <p>Resolution Details: <c:out value="${issue.resolutionDtls()}"/></p>
                <p>Date Resolved: <c:out value="${issue.dateResolved()}"/></p>
			</section>
            <section>
                <%if (request.isUserInRole("STAFF")) {%>
                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'NEW' || issue.issueStatus() == 'WAITING FOR THIRD PARTY' }">
                        <input type="hidden" name="mark" value="IN PROGRESS"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Mark In Progress"/>
                    </c:if>
                </form>
                    
                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'IN PROGRESS'}">
                        <input type="hidden" name="mark" value="COMPLETE"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Mark Complete"/>
                    </c:if>
                </form>

                    
                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'IN PROGRESS'}">
                        <input type="hidden" name="mark" value="WAITING FOR THIRD PARTY"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Mark Waiting for Third Party"/>
                    </c:if>
                </form>
                    
                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'IN PROGRESS'}">
                        <input type="hidden" name="mark" value="WAITING FOR REPORTER"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Mark Waiting for Reporter"/>
                    </c:if>
                </form>
                
                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'WAITING FOR REPORTER'}">
                        <input type="hidden" name="mark" value="IN PROGRESS"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Mark in Progress"/>
                    </c:if>
                </form>
                
                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'COMPLETE'}">
                        <input type="hidden" name="mark" value="COMPLETE - KB"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Make Knowledgebase"/>
                    </c:if>
                </form>
                
                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'RESOLVED'}">
                        <input type="hidden" name="mark" value="RESOLVED - KB"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Make Knowledgebase"/>
                    </c:if>
                </form>
                <%}%>

                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'COMPLETE' || issue.issueStatus() == 'COMPLETE - KB'}">
                        <input type="hidden" name="mark" value="IN PROGRESS"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Reject Completion"/>
                    </c:if>
                </form>
                
                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'COMPLETE'}">
                        <input type="hidden" name="mark" value="RESOLVED"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Accept Completion"/>
                    </c:if>
                </form>
                
                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'COMPLETE - KB'}">
                        <input type="hidden" name="mark" value="RESOLVED - KB"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Accept Completion"/>
                    </c:if>
                </form>

                <form action="ReportIssue" method="POST">
                    <c:if test="${issue.issueStatus() == 'WAITING FOR REPORTER'}">
                        <input type="hidden" name="mark" value="IN PROGRESS"/>
                        <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                        <input type="submit" class="large_button" value="Accept Completion"/>
                    </c:if>
                </form>

                <h3>Comments</h3>
                <p><c:out value="${issue.comments()}"/></p>
                <br/>
                <form action="ReportIssue" method="POST">
                    <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                    <table>
                        <tr>
                            <td><textarea name="comment" class="big_box" required></textarea></td>
                        </tr>
                        <tr>    
                            <td><input type="submit" value="Add Comment"/></td>
                        </tr>
                    </table>
                </form>
				<%if (request.isUserInRole("STAFF")) {%>
				<h3>Resolution Details (Updating will delete current)</h3>
                <form action="ReportIssue" method="POST">
                    <input type="hidden" name="current_issue_id" value="${issue.issueID()}"/>
                    <table>
                        <tr>
                            <td><textarea name="resdtls" class="big_box" required></textarea></td>
                        </tr>
                        <tr>    
                            <td><input type="submit" value="Update Resolution Details"/></td>
                        </tr>
                    </table>
                </form>
				<%}%>
            </section>
		</main>
	</body>
</html>