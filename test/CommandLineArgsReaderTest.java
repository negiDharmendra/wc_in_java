import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class CommandLineArgsReaderTest {
	@Test
    public void getMethodNameShouldGiveTheMethodNameAccordingToProvidedOption(){
    	String [] args = {"-l","sample.txt"};
    	CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
    	String  methods = "l";
    	assertEquals(methods,commandLineArgs.getOptions());
    }
    @Test
    public void getMethodNameShouldGiveEmptyArrayForNoOption(){
        String [] args = {};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String methods = "";
        assertEquals(methods,commandLineArgs.getOptions());
    }
    @Test
    public void getMethodNameShouldGiveEmptyArrayWhenThereIsNoOptionBeginsWithHyphen(){
        String [] args = {"l","w","m","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String methods = "";
        assertEquals(methods,commandLineArgs.getOptions());
    }
    @Test
    public void getMethodNameShouldGiveAllTheMethodNamesAccordingToProvidedOptions(){
    	String [] args = {"-l","-w","-m","sample.txt"};
    	CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
    	String methods = "lwm";
    	assertEquals(methods,commandLineArgs.getOptions());
    }
    @Test
    public void getMethodNameShouldNotRepeatTheMethodNames(){
        String [] args = {"-l","-w","-m","-l","-w","-m","-l","-w","-m","-l","-w","-m","-l","-w","-m","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String methods = "lwc";
        assertEquals(methods,commandLineArgs.getOptions());
    }
    @Test
    public void getMethodNameShouldSelectTheLastMethodAmongTheByteCountOrCharCount(){
        String [] args = {"-l","-w","-m","-c","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String methods = "lwc";
        assertEquals(methods,commandLineArgs.getOptions());

        String [] args1 = {"-l","-w","-c","-m","sample.txt"};
        commandLineArgs = new CommandLineArgsReader(args1);
        String methods1 = "lwm";
        assertEquals(methods1,commandLineArgs.getOptions());
    }
    @Test
    public void getMethodNameShouldThrowAnErrorForInvalidOptions(){
        String [] args = {"-l","-q","-m","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String errorMessage = "\n\twc: illegal option -- q\n\tusage: wc [-clmw] [file ...]";
        try {
            commandLineArgs.getOptions();
        } catch (IllegalArgumentException err) {
            assertEquals(err.getMessage(), errorMessage);
        }
    }
    @Test
    public void getMethodNameShouldReturnsEmptyArrayInTheAbsenceOfOptions(){
        String [] args = {"sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String methods = "";
        assertEquals(methods,commandLineArgs.getOptions());
    }
    @Test
    public void getMethodNameShouldGiveAllMethodNameEvenIfAllOptionsAreTogetherInAString(){
        String [] args = {"-lwc"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String methods = "lwc";
        assertEquals(methods,commandLineArgs.getOptions());
    }
    @Test
    public void getFilesShouldGiveTheAllTheProvidedFileName(){
        String [] args = {"-l","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] filesName = {"sample.txt"};
        assertArrayEquals(filesName,commandLineArgs.getFiles());
    }
    @Test
    public void getFilesShouldTreatAllThoseArgsStartWithoutHyphonAsFileName(){
        String [] args = {"-sample1.txt","w","l","sample.txt"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] filesName = {"w","l","sample.txt"};
        assertArrayEquals(filesName,commandLineArgs.getFiles());
    }
    @Test
    public void getFilesShouldTreatTheSingleHyphonAsFileName(){
        String [] args = {"-","-"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String [] filesName = {"-","-"};
        assertArrayEquals(filesName,commandLineArgs.getFiles());
    }
    @Test
    public void getFilesShouldThrowAnErrorInTheAbsenceOfFiles(){
        String [] args = {"-l"};
        CommandLineArgsReader commandLineArgs = new CommandLineArgsReader(args);
        String errorMessage = "\n\t File name is not provided";
        try {
            commandLineArgs.getOptions();
        } catch (IllegalArgumentException err) {
            assertEquals(err.getMessage(), errorMessage);
        }
    }
}
