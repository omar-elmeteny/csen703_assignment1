
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    TestValues[] testValues = {
            // new TestValues(new int[] { 1, 2 }, true, 0, 1, 2),
            // new TestValues(new int[] { 2, 1 }, false, 0, 1, 2),
            // new TestValues(new int[] { 1, 2, 3 }, true, 0, 1, 5),
            // new TestValues(new int[] { 1, 3, 2 }, true, 0, 1, 5),
            // new TestValues(new int[] { 3, 1, 2 }, false, 0, 1, 5),
            // new TestValues(new int[] { 3, 2, 1 }, true, 1, 2, 5),
            // new TestValues(new int[] { 1, 2, 3, 4 }, true, 0, 3, 6),
            // new TestValues(new int[] { 1, 2, 4, 3 }, true, 0, 1, 6),
            // new TestValues(new int[] { 1, 3, 2, 4 }, true, 0, 3, 7),
            // new TestValues(new int[] { 1, 3, 4, 2 }, true, 0, 1, 7),
            new TestValues(new int[] { 3 }, false, 0, 0, 3),
            new TestValues(new int[] { 3, 1, 2, 1 }, false, 0, 3, 5),
            new TestValues(new int[] { 1, 7, 3, 4, 7, 6, 2, 9 }, false, 0, 3, 26),
            new TestValues(new int[] { 2, 1, 5, 7, 1, 1 }, true, 3, 4, 14),
            new TestValues(new int[] { 2, 4, 1, 7, 1, 1 }, true, 1, 4, 13),
            new TestValues(new int[] { 5, 6, 6, 5, 5, 6 }, true, 0, 1, 17),
            new TestValues(new int[] { 1, 2, 3, 4, 8, 7, 5, 6 }, true, 0, 7, 19),
            new TestValues(new int[] { 1, 2, 3, 4, 8, 7, 6, 5 }, true, 0, 3, 20),
            new TestValues(new int[] { 1, 2, 3, 4, 5, 6, 8, 7 }, true, 6, 7, 20),
            new TestValues(new int[] { 1, 2, 3, 4, 5, 7, 8, 6 }, true, 0, 5, 21),


    };

    @Test
    public void shouldSucceedTest0() {
        runTest(0);
    }

    @Test
    public void shouldSucceedTest1() {
        runTest(1);
    }

    @Test
    public void shouldSucceedTest2() {
        runTest(2);
    }

    @Test
    public void shouldSucceedTest3() {
        runTest(3);
    }

    @Test
    public void shouldSucceedTest4() {
        runTest(4);
    }

    @Test
    public void shouldSucceedTest5() {
        runTest(5);
    }

    @Test
    public void shouldSucceedTest6() {
        runTest(6);
    }

    @Test
    public void shouldSucceedTest7() {
        runTest(7);
    }

    @Test
    public void shouldSucceedTest8() {
        runTest(8);
    }

    @Test
    public void shouldSucceedTest9() {
        runTest(9);
    }

    private void runTest(int i) {
        TestValues testValue = testValues[i];
        // Range range = Mission_Impossible.largestSubrange(testValue.testArray, 0,
        //         testValue.testArray.length - 1);
        // boolean shouldReverse = Mission_Impossible.shouldReverse(range);
        // assertEquals(String.format("test %d failed: shouldReverse ", i), testValue.shouldReverse, shouldReverse);
        // if (shouldReverse) {
        //     assertEquals(String.format("test %d failed: range lo", i), testValue.lo, range.lo);
        //     assertEquals(String.format("test %d failed: range hi", i), testValue.hi, range.hi);
        // }
        int output = Mission_Impossible.alpha(testValue.testArray);
        assertEquals(String.format("failed %d failed: alpha output", i), testValue.output, output);
    }

    @Test
    public void shouldReverseOddArrayCorrectly() {
        int[] oddArray = { 1, 2, 3, 4, 5};

        Mission_Impossible.reverseSubrange(oddArray, new Range(0, 4, 0));
        assertEquals(5, oddArray[0]);
        assertEquals(4, oddArray[1]);
        assertEquals(3, oddArray[2]);
        assertEquals(2, oddArray[3]);
        assertEquals(1, oddArray[4]);
    }

    @Test
    public void shouldReverseEvenArrayCorrectly() {
        int[] oddArray = { 1, 2, 3, 4 };

        Mission_Impossible.reverseSubrange(oddArray, new Range(0, 3, 0));
        assertEquals(4, oddArray[0]);
        assertEquals(3, oddArray[1]);
        assertEquals(2, oddArray[2]);
        assertEquals(1, oddArray[3]);
    }

    @Test
    public void shouldReverseEvenArrayOddSubRangeCorrectly() {
        int[] oddArray = { 1, 2, 3, 4, 5, 6 };

        Mission_Impossible.reverseSubrange(oddArray, new Range(1, 3, 0));
        assertEquals(1, oddArray[0]);
        assertEquals(4, oddArray[1]);
        assertEquals(3, oddArray[2]);
        assertEquals(2, oddArray[3]);
        assertEquals(5, oddArray[4]);
        assertEquals(6, oddArray[5]);
        
    }

    @Test
    public void shouldReverseEvenArrayEvenSubRangeCorrectly() {
        int[] oddArray = { 1, 2, 3, 4, 5, 6 };

        Mission_Impossible.reverseSubrange(oddArray, new Range(1, 4, 0));
        assertEquals(1, oddArray[0]);
        assertEquals(5, oddArray[1]);
        assertEquals(4, oddArray[2]);
        assertEquals(3, oddArray[3]);
        assertEquals(2, oddArray[4]);
        assertEquals(6, oddArray[5]);
        
    }

    @Test
    public void shouldCalculateRangeCorrectly() {
        int[] a = new int[] { 1, 10, 100, 1000, 10000, 100000 };
        assertEquals(0, Mission_Impossible.crossingValue(a, 0, 0));
        assertEquals(9, Mission_Impossible.crossingValue(a, 0, 1));
        assertEquals(a[1] + a[3] + a[5] - a[0] - a[2] - a[4], Mission_Impossible.crossingValue(a, 0, 5));
        assertEquals(a[3] - a[2], Mission_Impossible.crossingValue(a, 2, 3));
    }
}

class TestValues {
    int[] testArray;
    boolean shouldReverse;
    int lo;
    int hi;
    int output;

    public TestValues(int[] testArray, boolean shouldReverse, int lo, int hi, int output) {
        this.testArray = testArray;
        this.shouldReverse = shouldReverse;
        this.lo = lo;
        this.hi = hi;
        this.output = output;
    }
}
