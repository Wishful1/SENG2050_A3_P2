<%@ include file="head.jsp"%>
		<body class="anzac_walk_background">
			<%@ include file="navbar.jsp"%>
			<main>
				<section style="overflow: scroll;">
					<h1>Report Issue</h1>
				<form action="ReportIssue" method="post">
					<table>
						<tr>
							<td>
								<label for="title">Issue Title: </label>
							</td>
							<td>
								<input type="text" id="title" name="title" value="${param.title}" required/>
							</td>
						<tr>
							<td>
								<label for="issueDtls">Issue Details: </label>
							</td>
							<td>
								<textarea id="issueDtls" name="issueDtls" value="${param.issueDtls}" class="big_box"required>My location (Building/Room): 

My internet browser is (eg Internet Explorer v9 / Mozilla Firefox v12): 

I am trying to connect to the following website: 

I am able to access internal websites (Y/N): 

I have tried using an alternate internet browser (Y/N): 

I have tried restarting my computer (Y/N): 

Problem description and error message: </textarea>
							</td>
						</tr>
						<tr>
							<td>
								<label for="category">Category: </label>
							</td>
							<td>
								<select name="category" id="category" value="${param.category}">
									<option value="Network - Cannot Connect">Network - Cannot Connect</option>
									<option value="Network - Speed">Network - Speed</option>
									<option value="Network - Constant Dropouts">Network - Constant Dropouts</option>
									<option value="Software - Slow to Load">Software - Slow to Load</option>
									<option value="Software - Won't Load at all">Software - Won't Load at all</option>
									<option value="Hardware - Computer will not turn on">Hardware - Computer will not turn on</option>
									<option value="Hardware - Blue Screens">Hardware - Blue Screens</option>
									<option value="Hardware - Disk drive">Hardware - Disk drive</option>
									<option value="Hardware - Peripherals">Hardware - Peripherals</option>
									<option value="Email - Cannot send">Email - Cannot send</option>
									<option value="Email - Cannot receive">Email - Cannot receive</option>
									<option value="Account - Spam and Phishing">Spam and Phishing - Account</option>
									<option value="Account - Password reset">Account - Password reset</option>
									<option value="Account - Wrong details">Account - Wrong details</option>
								</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="submit" value="Submit Issue"/>
							</td>
						</tr>
					</table>
				</form>
			</section>
		</main>
	</body>
</html>