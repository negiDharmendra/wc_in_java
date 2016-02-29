import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WcTest {
    @Test
    public void charCountShouldCountTheNumberOfCharacterInAString() {
        Wc wc = new Wc("Hello");
        wc.addScanner(new CharacterScanner());
        wc.count();
        assertEquals("5", wc.summery());
    }

    @Test
    public void charCountShouldReturnZeroWhenStringISEmpty() {
        Wc wc = new Wc("");
        wc.addScanner(new CharacterScanner());
        wc.count();
        assertEquals("0", wc.summery());
    }

    @Test
    public void charCountShouldCountTheNumberOfCharacterWhenThereISOnlySpaces() {
        Wc wc = new Wc("     ");
        wc.addScanner(new CharacterScanner());
        wc.count();
        assertEquals("5", wc.summery());
    }

    @Test
    public void charCountShouldCountTheNumberOfCharacterWhenThereISOnlyNewLineCharacters() {
        Wc wc = new Wc("\n\n\n");
        wc.addScanner(new CharacterScanner());
        wc.count();
        assertEquals("3", wc.summery());
    }

    @Test
    public void wordCountShouldCountTheNumberOfWordAsZeroForEmptyString() {
        Wc wc = new Wc("");
        wc.addScanner(new WordScanner());
        wc.count();
        assertEquals("0", wc.summery());
    }

    @Test
    public void wordCountShouldCountTheNumberOfWordAsZeroIfThereIsOnlyWhiteSpaces() {
        Wc wc = new Wc(" ");
        wc.addScanner(new WordScanner());
        wc.count();
        assertEquals("0", wc.summery());
    }

    @Test
    public void wordCountShouldCountASingleWord() {
        Wc wc = new Wc("hellod");
        wc.addScanner(new WordScanner());
        wc.count();
        assertEquals("1", wc.summery());
    }

    @Test
    public void wordCountShouldCountTheNumberOfWordInAStringUsingWhiteSpaceAsSeparator() {
        Wc wc = new Wc("h d");
        wc.addScanner(new WordScanner());
        wc.count();
        assertEquals("2", wc.summery());
    }

    @Test
    public void wordCountShouldCountTheNumberOfWordEvenIfAllOfThemAreInDifferentLines() {
        Wc wc = new Wc("hello\nworld");
        wc.addScanner(new WordScanner());
        wc.count();
        assertEquals("2", wc.summery());
    }

    @Test
    public void wordCountShouldCountTheNumberOfWordAsZeroIfThereIsMulipleEmptyLines() {
        Wc wc = new Wc("\n\n\n\n");
        wc.addScanner(new WordScanner());
        wc.count();
        assertEquals("0", wc.summery());
    }

    @Test
    public void wordCountShouldCountShouldAvoidTheMultipleSpacesBetweenWords() {
        Wc wc = new Wc("hello      world");
        wc.addScanner(new WordScanner());
        wc.count();
        assertEquals("2", wc.summery());
    }

    @Test
    public void lineCountShouldCountNumberOfStringSeparatedByNewLineCharacter() {
        Wc wc = new Wc("Hello\nThis\nA\ntest\nFor line Count");
        wc.addScanner(new LineScanner());
        wc.count();
        assertEquals("4", wc.summery());
    }

    @Test
    public void lineCountShouldReturnZeroWhenThereIsNoNewLineCharacter() {
        Wc wc = new Wc("This tets is to test line Count method of Wc class");
        wc.addScanner(new LineScanner());
        wc.count();
        assertEquals("0", wc.summery());
    }

    @Test
    public void lineCountShouldCountTheNumberOfNewLineCharacterWhenTheyAreOnlyOneWhoExistsInString() {
        Wc wc = new Wc("\n\n\n\n\n");
        wc.addScanner(new LineScanner());
        wc.count();
        assertEquals("5", wc.summery());
    }

    @Test
    public void byteCountShouldReturnByteSizeOfTheGivenString() {
        Wc wc = new Wc("This tets");
        wc.addScanner(new ByteScanner());
        wc.count();
        assertEquals("9", wc.summery());
    }

    @Test
    public void byteCountShouldReturnZeroWhenEmptyStringIsGiven() {
        Wc wc = new Wc("");
        wc.addScanner(new ByteScanner());
        wc.count();
        assertEquals("0", wc.summery());
    }

    @Test
    public void byteCountShouldReturnTheByteSizeEvenIfThereIsSpecialCharacter() {
        Wc wc = new Wc("∂");
        wc.addScanner(new ByteScanner());
        wc.count();
        assertEquals("3", wc.summery());
    }
}
