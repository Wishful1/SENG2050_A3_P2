<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="ISO-8859-1">
    <title>IT Services - Login</title>
    <link rel="stylesheet" href="styles.css" />
</head>

<body class="newcastle_background">
    <nav>
	    <h1>IT Services</h1>
    </nav>
    <main>
        <section class="login">
            <form method="POST" action="j_security_check">
                <table>
                    <tr>
                        <td>
                            <label for="username">Username: </label>
                        </td>
                        <td>
                            <input type="text" id="username" name="j_username" />
                        </td>
                    <tr>
                        <td>
                            <label for="password">Password: </label>
                        </td>
                        <td>
                            <input type="password" id="password" name="j_password" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Login">
                        </td>
                    </tr>
                </table>
            </form>
            <p><a href="Register">Register as a member</a></p>
        </section>
    </main>
</body>

</html>