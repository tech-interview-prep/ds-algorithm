package facebook;

/**
 * Climb stairs. You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * https://leetcode.com/problems/climbing-stairs
 * https://gist.github.com/zac-xin/4349080
 * http://n00tc0d3r.blogspot.com/2013/01/climbing-stairs.html
 */
public class _070ClimbingStairs {
    public static void main(String[] args) {

    }
}

class ClimbStairs {
    public int climbStairs(int n) {
        if ( n == 0 || n == 1 || n == 2)
            return n;

        int array[] = new int[n + 1];

        array[0] = 0;
        array[1] = 1;
        array[2] = 2;

        if ( n == 0 || n == 1 || n == 2)
            return array[n];

        for (int i = 3; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }
}
