import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import src.Wc;

public class WcTest {
	@Test
	public void charCountShouldCountTheNumberOfCharacterInAString (){
		Wc string = new Wc("Hello");
		assertEquals(string.charCount(),5);
	}
	@Test
	public void charCountShouldReturnZeroWhenStringISEmpty (){
		Wc string = new Wc("");
		assertEquals(string.charCount(),0);
	}
	@Test
	public void charCountShouldCountTheNumberOfCharacterWhenThereISOnlySpaces (){
		Wc string = new Wc("     ");
		assertEquals(string.charCount(),5);
	}
	@Test
	public void charCountShouldCountTheNumberOfCharacterWhenThereISOnlyNewLineCharacters (){
		Wc string = new Wc("\n\n\n");
		assertEquals(string.charCount(),3);
	}
    
}
