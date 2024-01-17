# Unit Testing Prework: TextTruncator

**GitHub repo:** [ebd-unit-testing-text-truncator](https://github.com/LambdaSchool/ebd-unit-testing-text-truncator)

## Introduction
Your team owns the Goodreads website and is working on displaying a list of
reviews for a given book. In order to
keep the list easily viewable, you want to truncate the review text to a
given number of characters so that it
displays reasonably well.

Your colleague has started a class, `TextTruncator`, that accepts a `String` in
its constructor, then allows for calling `truncateTo()` to shorten the text to
an arbitrary length. Unfortunately, they're going out of town, but you've
volunteered to finish it off. They've created the class and a "happy case" unit
test, and it's up to you to write some of the remaining tests.

Inside this same directory (`src/com/amazon/ata/unittesting/texttruncator`) is
`TextTruncator.java`, the file containing the `TextTruncator` class. The test
class for `TextTruncator` lives in a very similar directory under tst (rather
than src): `tst/com/amazon/ata/unittesting/texttruncator`. This test class is
`TextTruncatorTest` and is declared in the same Java package as `TextTruncator`
(`com.amazon.ata.unittesting.texttruncator`) This represents two common conventions
at Amazon:
1. We put the source code that'll run in production under 'src' and the code
that tests it under 'tst' at the top of the package.\*
1. We put the test classes in the *same* Java package as the classes that they're testing.

You should follow these conventions as well.

\* There's a slight variation on this for packages that use something called
"Gradle" for handling build tasks, but it's similar enough that you'll have no
trouble adapting. Also, don't worry about Gradle right now, we just wanted to
prepare you in case you see `src/main/com/amazon/...` and
`src/test/com/amazon/...` in a package you're exploring instead of `src` and
`tst`. It's the same idea.

## Run the existing test
1. First, run the existing unit test by clicking the green arrow next to
`truncateTo_stringLongerThanNumChars_shortensToFirstNumChars()` and clicking
"Run 'truncateTo_handles...()'".
Verify that the existing test passes.
1. Now run all the tests in the test class (yes, there's still only one!), by
clicking on the green arrows next
to `TextTruncatorTest` and clicking "Run 'TextTruncatorTest'".
Alternately, type `./gradlew -q clean :test` in the terminal.
This will run the one unit test that's written so far, but when you add more,
this is how you can run them all at once.

## Test 1: Make sure `truncateTo()` doesn't fail on a `null` `String`
Write a test that creates a `TextTruncator` instance, passing in `null` to the
constructor, and make sure
that calling `truncator.truncateTo(10)` returns an empty `String` (`""`).
1. Remember to follow our test naming convention of
`methodUnderTest_descriptiveTestCondition_expectedBehavior()`.
1. Remember your `GIVEN`/`WHEN`/`THEN` structure within the test.
1. Follow another best practice by providing a `message` as the last argument
to the `assert...()` method you call in your `THEN` section (do these in each
of the tests that you write).

(Hint: Your `WHEN` section should probably be one line long and include a call
to the method that you're testing). This test should pass without needing to
change `TextTruncator`.

(Hint: If you're not seeing the green arrow for the new test you've created,
did you remember to annotate your method with `@Test`?)

(Hint: Make sure everything is working together by running all tests, either
with the green triangle on the class declaration, or in the terminal with
`./gradlew -q clean :test`.)

## Test2: Test that `truncateTo()` returns a truncated string of the desired length.
Write a test that creates a `TextTruncator` instance with a `String` that's
long enough to force truncation, given the `numChars` you'll pass in to
`truncateTo()`. Make sure that the length of returned `String` matches the value of `int numChars` you
pass in. This test should pass without needing to change `TextTruncator`.

## Test 3: Make sure that `truncateTo()` doesn't append `suffix` if the original `String` is short enough
(Ok, we'll tell you in advance that this test you're writing shouldn't pass!
It's an 'edge case' that your colleague didn't get a chance to handle yet
before they left.)

Write a test that constructs a `TextTruncator` with a `String` that's shorter
than the `numChars` you pass into `truncateTo()`. Call the two-argument version
of `truncateTo()` that accepts the suffix string to append to the truncated
`String`... but only if the text is actually truncated. Verify that the `String`
returned by `truncateTo()` equals the original `String`. (Hint: use
`Assertions.assertEquals()` to test the original `String` we expect against
the result of `truncateTo()`).

This test should fail when you run it. Now go fix `TextTruncator` so that all
the tests (including this one) pass!

Run `./gradlew -q clean :test` and verify that all the tests pass.
Commit and push your changes and use your git repository URL to
answer the Canvas question.
