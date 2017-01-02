package leetcode.algorithms.level.Medium;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * @author bkoteshwarreddy
 */
public class ExcelSheetColumnNumber {
    /*
      Given a column title as appear in an Excel sheet, return its corresponding column number.

      For example:

          A -> 1
          B -> 2
          C -> 3
          ...
          Z -> 26
          AA -> 27
          AB -> 28
     */

    /**
     * Go through the title
     * Map A ~ Z to 1 ~ 26
     * next result = current res * 26 + number of current letter
     */
    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - '@');
        }

        return res;
    }
}
