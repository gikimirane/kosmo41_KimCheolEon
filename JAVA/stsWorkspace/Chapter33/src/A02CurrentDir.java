import java.nio.file.Path;
import java.nio.file.Paths;

public class A02CurrentDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Path cur = Paths.get("");
		String cdir;

		if (cur.isAbsolute()) {
			System.out.println("Absolute");
			cdir = cur.toString();
		} else {
			System.out.println("toAbsolute");
			cdir = cur.toAbsolutePath().toString();
		}

		System.out.println("Current dir : " + cdir);

	}

}
