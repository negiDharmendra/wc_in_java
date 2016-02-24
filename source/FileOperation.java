package source;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileOperation {
	private String [] files;
	private int index = 0;
	public FileOperation (String [] files){
		this.files = files;
	}
	public String readNext() throws FileNotFoundException,IOException{
		if(files.length==index)return null;
		String fileName = files[index];
		index++;
		File file = new File(fileName);
		int length = (int)file.length();
		FileReader fr =new FileReader(file);
		char[] cbuf = new char [length];
		fr.read(cbuf,0,length);
		return new String(cbuf);
	}
}