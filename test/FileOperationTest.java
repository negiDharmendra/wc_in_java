import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Arrays;

import source.FileOperation;

public class FileOperationTest {
	@Test
	public void readNextShouldReadTheCurrentFile(){
		String [] filesName = {"./data/sampleText_1.txt"};
		FileOperation files = new FileOperation(filesName);
		String expected = "This collection of text is just for testing of my library codes.";
		try{
			assertEquals(expected,files.readNext());
		}catch(FileNotFoundException err){
			System.out.println(err.getMessage());
		}catch(IOException err){
			System.out.println(err.getMessage());
		}
	}
	@Test
	public void readNextShouldThrowErrorIfThereIsNoSuchFile(){
		String [] filesName = {"./data/hello.txt"};
		FileOperation files = new FileOperation(filesName);
		try{
			files.readNext();
		}catch(FileNotFoundException err){
			System.out.println(err.getMessage());
		}catch(IOException err){
			System.out.println(err.getMessage());
		}
	}
	@Test
	public void readNextShouldBeAbleToReadMultipleFiles(){
		String [] filesName = {"./data/sampleText_1.txt","./data/sampleText_2.txt","./data/sampleText_4.txt"};
		FileOperation files = new FileOperation(filesName);
		String expected = "This collection of text is just for testing of my library codes.";
		String expected1 = "Many developers,	including me sorry to say, treat unit test code as a";
		String expected2 = "";
		try{
			assertEquals(expected,files.readNext());
			assertEquals(expected1,files.readNext());
			assertEquals(expected2,files.readNext());
		}catch(FileNotFoundException err){
			System.out.println(err.getMessage());
		}catch(IOException err){
			System.out.println(err.getMessage());
		}
	}
	@Test
	public void readNextShouldGiveNullWhenThereIsNoFile(){
		String [] filesName = {};
		FileOperation files = new FileOperation(filesName);
		try{
			assertEquals(null,files.readNext());
		}catch(FileNotFoundException err){
			System.out.println(err.getMessage());
		}catch(IOException err){
			System.out.println(err.getMessage());
		}
	}
}
