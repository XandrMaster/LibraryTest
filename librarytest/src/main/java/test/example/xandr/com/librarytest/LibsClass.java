package test.example.xandr.com.librarytest;

/**
 * Created by Xandr on 20.07.2016.
 */
public class LibsClass {
	public String publicFunc (String name) {
		return hideFunc(name);
	}

	private String hideFunc (String name) {
		return name.concat(" Secret INFO");
	}
}
