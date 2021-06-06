import java.util.UUID;

/**
 * @author Mai Thành Duy An
 */

public class GenerateUUID {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(UUID.randomUUID().toString());
		}
	}

}
