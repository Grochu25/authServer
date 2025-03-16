@import java.util.Map
@import com.grochu.authserver.Model.UserLoginDTO
@param Map<String,String> errorMessages = null
@param String passwordCheck = null
@param UserLoginDTO userDetails

<!--@import com.grochu.authserver.Model.RegisterUserDetails
@param RegisterUserDetails userDetails
-->

<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf=8"/>
    <menta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
</head>
<body>
<div>
    <h1>Zaloguj się</h1>
    <form action="/login" method="post">
        @if(errorMessages != null && errorMessages.containsKey("login"))
            <div>
                ${errorMessages.get("login")}
            </div>
        @endif
        <label for="login">*Email/Login: </label> <input type="text" name="username" id="login" value="${userDetails.login()}"/><br/>
        @if(errorMessages != null && errorMessages.containsKey("password"))
            <div>
                ${errorMessages.get("password")}
            </div>
        @endif
        <label for="password">*Hasło: </label><input type="password" name="password" id="password" value="${userDetails.password()}"/><br/>
        <button type="submit">Zaloguj</button>
    </form>
    <a href="/register">zarejestruj</a> jeżeli jeszczen nie masz konta
</div>
</body>
</html>