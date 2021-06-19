package webapp;

import com.mstore.domain.shared.utils.PasswordUtil;

public class PasswordEncryptor {

	public static void main(String[] args) {
		String bcryptPassword = PasswordUtil.encryt("password");
		System.out.println(bcryptPassword);

	}

}
