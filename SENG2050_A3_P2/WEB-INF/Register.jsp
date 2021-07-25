<%@ include file="head.jsp"%>
		<body class="anzac_walk_background">
		<nav>
		<ul>
		<li><h1>Register New User</h1></li>
		<li style="float: right; padding-right: 1.5%;"><p><a href="Homepage">Login</a></p></li>
		</ul>
		</nav>

		<main>
			<section>
				<h1>Register New User</h1>
				<form action="Register" method="POST">
					<table>
						<tr>
							<td>
								<label for="username">Username: </label>
							</td>
							<td>
								<input type="text" id="username" name="username" value="${param.username}" required/>
							</td>
						<tr>
							<td>
								<label for="fname">First Name: </label>
							</td>
							<td>
								<input type="text" id="fname" name="fname" value="${param.fname}" required/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="lname">Last Name: </label>
							</td>
							<td>
								<input type="text" id="lname" name="lname" value="${param.lname}" required/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="email">Email: </label>
							</td>
							<td>
								<input type="email" id="email" name="email" value="${param.email}" required/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="phnum">Phone Number: </label>
							</td>
							<td>
								<input style="display: inline;" value="${param.phnum}" type="tel" id="phnum" name="phnum" pattern="[+]*([0-9]+ *)+">
								<h5 style="display: inline;">* Digits No Spaces</h5>
							</td>
						</tr>
						<tr>
							<td>
								<label for="password">Password: </label>
							</td>
							<td>
								<input type="password" id="password" name="password" value="${param.password}" pattern=".{8,12}" required/>
								<h5 style="display: inline;">* 8 to 12 - Characters</h5>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="submit" value="Submit User"/>
							</td>
						</tr>
					</table>
				</form>
			</section>
		</main>
	</body>
</html>