package tw.com.jerry.constant;

public class RoleConstant {

	public static final String ADMIN = "ROLE_ADMIN";
	public static final String USER = "ROLE_USER";

	public static String readDataBase(String role) {
		return "ROLE_" + role.toUpperCase();
	}

}
