import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import source.CommandLineArgsReader;


public class CommandLineArgsReaderTest {
	@Test
    public void getMethodNameShouldGiveAllTheMethodNameAccordingToOptionProvidedToWc(){
    	String [] args = {"-l","sample.txt"};
    	CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
    	String [] methods = {"lineCount"};
    	assertArrayEquals(methods,commandLineArgs.getMethodName());
    }
}
