/**
 * Mission_Impossible
 */
public class Mission_Impossible {

    public static int alpha(int[] keys) {
        IndexSubrange largest = LargestEvenSubrange(keys, 0, keys.length - 1);
        reverseSubrange(keys, largest);
        return SumRange(keys, 0, keys.length - 1, true);
    }

    public static void reverseSubrange(int[] keys, IndexSubrange range) {
        for (int i = range.start; i < (range.start + range.end + 1) / 2; i++) {
            int temp = keys[i];
            keys[i] = keys[range.end + range.start - i];
            keys[range.end + range.start - i] = temp;
        }
    }

    public static IndexSubrange LargestEvenSubrange(int[] a, int lo, int hi) {
        if (lo == hi) {
            return new IndexSubrange(lo, lo, a[lo]);
        }
        int mid = (lo + hi) / 2;
        IndexSubrange left = LargestEvenSubrange(a, lo, mid);
        IndexSubrange right = LargestEvenSubrange(a, mid + 1, hi);
        IndexSubrange maxCrossing = MaximumCrossing(a, lo, hi, mid);

        if (left.sum > right.sum) {
            return left.sum > maxCrossing.sum ? left : maxCrossing;
        } else {
            return right.sum > maxCrossing.sum ? right : maxCrossing;
        }
    }

    public static int SumRange(int[] a, int lo, int hi, boolean evenPositions) {
        if (lo % 2 == (evenPositions ? 1 : 0)) {
            lo++;
        }
        int sum = 0;
        for (int i = lo; i <= hi; i += 2) {
            sum += a[i];
        }
        return sum;
    }

    public static IndexSubrange MaximumCrossing(int[] a, int lo, int hi, int mid) {
        int sumLeft = SumRange(a, lo, mid, false);
        int sumRight = SumRange(a, mid + 1, hi, false);
        int sum = sumLeft + sumRight;

        if (sumLeft > sumRight) {
            return sumLeft > sum ? new IndexSubrange(lo, mid, sumLeft) : new IndexSubrange(lo, hi, sum);
        } else {
            return sumRight > sum ? new IndexSubrange(mid + 1, hi, sumRight) : new IndexSubrange(lo, hi, sum);
        }
    }

    // public static int max(int x, int y, int z) {
    // return z > (x > y ? x : y) ? z : ((x > y) ? x : y);
    // }

    public static void main(String[] args) {
        // int[] keys = {1,7,3,4,7,6,2,9};
        int[] keys = {3,1,2,1};
        System.out.println(alpha(keys));
    }

}

class IndexSubrange {
    int start;
    int end;
    int sum;

    IndexSubrange(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }
}