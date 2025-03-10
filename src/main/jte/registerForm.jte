@import com.grochu.authserver.Model.RegisterUserDetails
@import java.util.Map
@param RegisterUserDetails userDetails
@param String passwordCheck = null
@param Map<String,String> errorMessages = null

<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf=8"/>
    <menta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
</head>
<body>
    <div>
        <form action="/register" method="post">
            @if(errorMessages != null && errorMessages.containsKey("email"))
                <div>
                    ${errorMessages.get("email")}
                </div>
            @endif
            <label for="email">*Email: </label> <input type="email" name="email" id="email" value="${userDetails.getEmail()}"/><br/>
            @if(errorMessages != null && errorMessages.containsKey("password"))
                <div>
                    ${errorMessages.get("password")}
                </div>
            @endif
            <label for="password">*Hasło: </label><input type="password" name="password" id="password" value="${userDetails.getPassword()}"/><br/>
            @if(passwordCheck != null)
                <div>
                    ${passwordCheck}
                </div>
            @endif
            <label for="confirmPassword">*Potwierdź hasło: </label><input type="password" name="confirmPassword" id="confirmPassword" value="${userDetails.getConfirmPassword()}"/><br/>
            @if(errorMessages != null && errorMessages.containsKey("name"))
                <div>
                    ${errorMessages.get("name")}
                </div>
            @endif
            <label for="name">*Imię: </label><input type="text" name="name" id="name" value="${userDetails.getName()}"/><br/>
            @if(errorMessages != null && errorMessages.containsKey("surname"))
                <div>
                    ${errorMessages.get("surname")}
                </div>
            @endif
            <label for="surname">*Nazwisko: </label><input type="text" name="surname" id="surname" value="${userDetails.getSurname()}"/><br/>
            <label for="phoneNumber">Numer telefonu: </label><input type="text" name="phoneNumber" id="phoneNumber" value="${userDetails.getPhoneNumber()}"/><br/>
            @if(errorMessages != null && errorMessages.containsKey("addressStreet"))
                <div>
                    ${errorMessages.get("addressStreet")}
                </div>
            @endif
            <label for="addressStreet">*Adres: </label><input type="text" name="addressStreet" id="addressStreet" value="${userDetails.getAddressStreet()}"/><br/>
            @if(errorMessages != null && errorMessages.containsKey("addressCity"))
                <div>
                    ${errorMessages.get("addressCity")}
                </div>
            @endif
            <label for="addressCity">*Miasto: </label><input type="text" name="addressCity" id="addressCity" value="${userDetails.getAddressCity()}"/><br/>
            @if(errorMessages != null && errorMessages.containsKey("addressState"))
                <div>
                    ${errorMessages.get("addressState")}
                </div>
            @endif
            <label for="addressState">*Województwo: </label>
            @template.stateSelectElement(userDetails = userDetails)
            @if(errorMessages != null && errorMessages.containsKey("addressZip"))
                <div>
                    ${errorMessages.get("addressZip")}
                </div>
            @endif
            <label for="addressZip">*Kod pocztowy: </label><input type="text" name="addressZip" id="addressZip" value="${userDetails.getAddressZip()}"/><br/>
            <button type="submit">stwórz konto</button>
        </form>
    </div>
</body>
</html>