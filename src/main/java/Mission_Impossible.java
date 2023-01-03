/**
 * Mission_Impossible
 */
public class Mission_Impossible {

    public static int alpha(int[] keys) {
        Range largest = largestSubrange(keys, 0, keys.length - 1);
        if (shouldReverse(largest))
        {
            reverseSubrange(keys, largest);
        }
        return sumEven(keys);
    }

    // Check if the subrange should be reversed
    // If the subrange's value is greater than zero // (i.e. the alpha output is increased)
    public static boolean shouldReverse(Range range) {
        return range.value > 0;
    }

    // Revese a subrange of an array
    public static void reverseSubrange(int[] keys, Range range) {
        for (int i = range.lo; i < (range.lo + range.hi + 1) / 2; i++) {
            int temp = keys[i];
            keys[i] = keys[range.hi + range.lo - i];
            keys[range.hi + range.lo - i] = temp;
        }
    }

    // A variant of a largestSubrange algorithm 
    // instead of returning the max value as in the lecture
    // returns an object holding the max value 
    // and the lo and hi indices of range corresponding to the maximum value
    public static Range largestSubrange(int[] a, int lo, int hi) {
        if (lo == hi) {
            return new Range(lo, lo, 0);
        }
        int mid = (lo + hi) / 2;

        Range left = largestSubrange(a, lo, mid);
        Range right = largestSubrange(a, mid + 1, hi);
        Range maxCrossing = maximumCrossing(a, lo, hi, mid);

        if (left.value > right.value) {
            return left.value > maxCrossing.value ? left : maxCrossing;
        } else {
            return right.value > maxCrossing.value ? right : maxCrossing;
        }
    }

    // Calculate the output of alpha (the sum of values at even positions)
    public static int sumEven(int[] keys) {
        int sum = 0;
        for (int i = 0; i < keys.length; i += 2) {
            sum += keys[i];
        }
        return sum;
    }

    // Calculate the crossing value
    // This is the increase or decrease of alpha output
    // when the array subrange is reversed
    //
    // When the number of elements to be reversed is odd: return 0
    // since reversing odd number of keys will cause
    // odd position keys to be still at odd positions after reversing
    // 
    // When the number of items to be reversed is even:
    // if i is odd, keys[i] will be at an even position after reversing so increment sum by key[i]
    // if i is even, keys[i] will be at an odd position after reversing so decrement sum by key[i]
    public static int crossingValue(int[] keys, int lo, int hi) {
        if ((lo - hi) % 2 == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = lo; i <= hi; i ++) {
            sum += (i % 2 == 1 ? 1 : -1 ) * keys[i];
        }
        return sum;
    }

    // calculate the maximim crossing in a range
    // This is variant of the maximumCrossing function of the largest subrange alg. discussed in the lectures
    // Instead of returning the value return an object containing the indices and the value
    public static Range maximumCrossing(int[] keys, int lo, int hi, int mid) {
        if (lo == hi) {
            return new Range(lo, hi, 0);
        }

        int midLeft = (mid - lo) % 2 == 0 ? mid + 1 : mid;
        int midRight = (hi - mid) % 2 == 0 ? mid - 1 : mid;
        
        int valueLeft = crossingValue(keys, lo, midLeft);
        int valueRight = crossingValue(keys, midRight, hi);
        // We can't add the values of valueLeft and valueRight since they may overlap
        int value = crossingValue(keys, lo, hi);
        
        if (valueLeft > valueRight) {
            return valueLeft > value ? new Range(lo, midLeft, valueLeft) : new Range(lo, hi, value);
        } else {
            return valueRight > value ? new Range(midRight, hi, valueRight) : new Range(lo, hi, value);
        }
    }

    public static void main(String[] args) {
        // int[] keys = {1,7,3,4,7,6,2,9};
        int[] keys = {1,7,3,4,7,6,2,9};
        System.out.println(alpha(keys));
    }

}

class Range {
    int lo;
    int hi;
    int value;

    Range(int start, int end, int value) {
        this.lo = start;
        this.hi = end;
        this.value = value;
    }
}