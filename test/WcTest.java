import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import source.Wc;

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
	@Test
	public void wordCountShouldCountTheNumberOfWordInAStringUsingWhiteSpaceAsSeparator (){
		Wc string = new Wc("word count");
		assertEquals(string.wordCount(),2);
	}
	@Test
	public void wordCountShouldCountTheNumberOfWordEvenIfAllOfThemAreInDifferentLines (){
		Wc string = new Wc("word\ncount");
		assertEquals(string.wordCount(),2);
	}
	@Test
	public void wordCountShouldCountTheNumberOfWordAsZeroIfThereIsMulipleEmptyLines (){
		Wc string = new Wc("\n\n\n\n");
		assertEquals(string.wordCount(),0);
	}
	@Test
	public void wordCountShouldCountShouldAvoidTheMultipleSpacesBetweenWords (){
		Wc string = new Wc("word       count");
		assertEquals(string.wordCount(),2);
	}
	@Test
	public void wordCountShouldCountTheNumberOfWordAsZeroIfThereIsOnlyWhiteSpaces (){
		Wc string = new Wc("   ");
		assertEquals(string.wordCount(),0);
	}
	@Test
	public void lineCountShouldCountNumberOfStringSeparatedByNewLineCharacter(){
		Wc string = new Wc("Hello\nThis\nA\ntest\nFor line Count");
		assertEquals(string.lineCount(),4);
	}
	@Test
	public void lineCountShouldReturnZeroWhenThereIsNoNewLineCharacter (){
		Wc string = new Wc("This tets is to test line Count method of Wc class");
		assertEquals(string.lineCount(),0);
	}
	@Test
	public void lineCountShouldCountTheNumberOfNewLineCharacterWhenTheyAreOnlyOneWhoExistsInString (){
		Wc string = new Wc("\n\n\n\n\n");
		assertEquals(string.lineCount(),5);
	}
	@Test
	public void byteCountShouldReturnByteSizeOfTheGivenString(){
		Wc string = new Wc("This tets");
		assertEquals(string.byteCount(),9);
	}
	@Test
	public void byteCountShouldReturnZeroWhenEmptyStringIsGiven(){
		Wc string = new Wc("");
		assertEquals(string.byteCount(),0);
	}
    @Test
	public void byteCountShouldReturnTheByteSizeEvenIfThereIsSpecialCharacter(){
		Wc string = new Wc("∂");
		assertEquals(string.byteCount(),3);
	}
}
