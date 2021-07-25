<%@ include file="head.jsp"%>
<body class="council_building_background">
    <%@ include file="navbar.jsp"%>
    <main>
        <section>
			<h1>Schedule Maintenance</h1>
				<table>
					<form action="ScheduleMaintenance" method="post">
						<tr>
							<td>
								<label for="mainTitle">Title: </label>
							</td>
							<td>
								<input type="text" name="mainTitle" value="${param.mainTitle}" required/>
							</td>
						<tr>
							<td>
								<label for="dateStart">Starting Date: </label>
							</td>
							<td>
								<input name="dateStart" type="datetime-local" value="${param.dateStart}" required/>
							</td>
						<tr>
							<td>
								<label for="dateEnd">Ending Date: </label>
							</td>
							<td>
								<input name="dateEnd" type="datetime-local" value="${param.dateEnd}" required/>
							</td>
						</tr>
						<tr>
						<tr>
							<td></td>
							<td>
								<input type="hidden" name="schedule" value="true"/>
								<input type="submit" value="Schedule Maintenance"/>
							</td>
						</tr>
				</form>
				<form action="ScheduleMaintenance" method="post">
					<tr>
						<td></td>
						<td><input type="submit" value="Remove Current"/></td>
					</tr>
				</form>
				</table>
			</section>
		</main>
	</body>
</html>