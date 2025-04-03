import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @since 4/3/2025 8:39 PM
 * @author Sulphuris
 */
public class Generator {
	public static void main(String[] args) throws IOException {
		File template = new File("template/Span2D.jt");
		String[] primitives = new String[]{
				"byte",
				"boolean",
				"short",
				"char",
				"int",
				"float",
				"long",
				"double",
		};
		
		for (String primitive : primitives) {
			char[] chars = primitive.toCharArray();
			chars[0] = Character.toUpperCase(chars[0]);
			String name = String.valueOf(chars);
			
			Path result = Paths.get("src/main/java/com/ydo4ki/simplespan/Span2D"+name+".java");
			InputStream in = Files.newInputStream(template.toPath());
			PrintStream out = new PrintStream(Files.newOutputStream(result));
			Scanner scanner = new Scanner(in);
			while (scanner.hasNext()) {
				out.println(scanner.nextLine().replace("#T#", name).replace("#t#", primitive));
			}
			out.close();
			in.close();
			scanner.close();
		}
		
	}
	
}
