package gg.jte.generated.ondemand;
import java.util.Map;
import com.grochu.authserver.Model.UserLoginDTO;
public final class JteloginGenerated {
	public static final String JTE_NAME = "login.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,6,6,21,21,23,23,23,25,25,26,26,26,26,26,26,26,26,26,27,27,29,29,29,31,31,32,32,32,32,32,32,32,32,32,38,38,38,2,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String,String> errorMessages, String passwordCheck, UserLoginDTO userDetails) {
		jteOutput.writeContent("\r\n");
		jteOutput.writeContent("\r\n\r\n<!doctype html>\r\n<html lang=\"pl\">\r\n<head>\r\n    <meta charset=\"utf=8\"/>\r\n    <menta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\r\n    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"/>\r\n</head>\r\n<body>\r\n<div>\r\n    <h1>Zaloguj się</h1>\r\n    <form action=\"/login\" method=\"post\">\r\n        ");
		if (errorMessages != null && errorMessages.containsKey("login")) {
			jteOutput.writeContent("\r\n            <div>\r\n                ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(errorMessages.get("login"));
			jteOutput.writeContent("\r\n            </div>\r\n        ");
		}
		jteOutput.writeContent("\r\n        <label for=\"login\">*Email/Login: </label> <input type=\"text\" name=\"username\" id=\"login\"");
		var __jte_html_attribute_0 = userDetails.login();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/><br/>\r\n        ");
		if (errorMessages != null && errorMessages.containsKey("password")) {
			jteOutput.writeContent("\r\n            <div>\r\n                ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(errorMessages.get("password"));
			jteOutput.writeContent("\r\n            </div>\r\n        ");
		}
		jteOutput.writeContent("\r\n        <label for=\"password\">*Hasło: </label><input type=\"password\" name=\"password\" id=\"password\"");
		var __jte_html_attribute_1 = userDetails.password();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/><br/>\r\n        <button type=\"submit\">Zaloguj</button>\r\n    </form>\r\n    <a href=\"/register\">zarejestruj</a> jeżeli jeszczen nie masz konta\r\n</div>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String,String> errorMessages = (Map<String,String>)params.getOrDefault("errorMessages", null);
		String passwordCheck = (String)params.getOrDefault("passwordCheck", null);
		UserLoginDTO userDetails = (UserLoginDTO)params.get("userDetails");
		render(jteOutput, jteHtmlInterceptor, errorMessages, passwordCheck, userDetails);
	}
}
