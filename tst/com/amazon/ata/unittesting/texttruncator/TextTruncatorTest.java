package com.amazon.ata.unittesting.texttruncator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test the <code>TextTruncator</code> behavior.
 */
public class TextTruncatorTest {
    @Test
    public void truncateTo_stringLongerThanNumChars_shortensToFirstNumChars() {
        // GIVEN
        String original = "One two three four five";
        TextTruncator truncator = new TextTruncator(original);

        // WHEN
        String truncatedString = truncator.truncateTo(7);

        // THEN
        Assertions.assertEquals("One two", truncatedString,
                                "Expected to truncate to the first 7 characters");

    }

    /* ADD YOUR TESTS HERE */
    @Test
    public void truncateTo_withNull_resultsInAnEmptyString() {
        // GIVEN
        TextTruncator truncator = new TextTruncator(null);

        // WHEN
        String truncatedString = truncator.truncateTo(10);

        // THEN
        Assertions.assertEquals("", truncatedString,
                "Expected to truncate null to an empty string.");

    }

    @Test
    public void truncateTo_withLongString_returnedLengthMatchesNumChars() {
        // GIVEN
        String longString = "This is a very long string that will be truncated.";
        int numChars = 10;
        TextTruncator truncator = new TextTruncator(longString);

        // WHEN
        String truncatedString = truncator.truncateTo(numChars);

        // THEN
        Assertions.assertEquals(numChars, truncatedString.length(),
                "The length of the truncated string should match numChars.");
    }

    @Test
    public void truncateTo_withShortString_returnedStringEqualsGivenString() {
        // GIVEN
        String shortString = "short";
        int numChars = 10;
        String suffix = "...";
        TextTruncator truncator = new TextTruncator(shortString);

        // WHEN
        String truncatedString = truncator.truncateTo(numChars, suffix);

        // THEN
        Assertions.assertEquals(shortString, truncatedString,
                "The returned string should match the original string when not truncated.");

    }
}
