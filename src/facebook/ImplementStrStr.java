package facebook;

/* 	
	Implement strStr().

	Returns a pointer to the first occurrence of pattern in text, or null if pattern is not part of text.
	
	Link: http://www.programcreek.com/2012/12/leetcode-implement-strstr-java/
	      http://algs4.cs.princeton.edu/53substring/KMP.java.html
	      http://www.fmi.uni-sofia.bg/fmi/logic/vboutchkova/sources/KMPMatch_java.html
	      https://github.com/junminstorage/code4fun/blob/master/src/org/blueocean/KMPStringMatch.java
*/	
public class ImplementStrStr {
	public String strStrSearch(String text, String pattern) {
		if(pattern == null || text==null) {
			return null;
		}
		int patternLen = pattern.length();
		int textLen = text.length();
	 
		if (patternLen == textLen && patternLen == 0)
			return "";
	 
		if (patternLen == 0)
			return text;
	 
		for (int i = 0; i < textLen; i++) {
			// make sure in boundary of needle
			if (textLen - i + 1 < patternLen)
				return null;
	 
			int k = i;
			int j = 0;
	 
			while (j < patternLen && k < textLen && pattern.charAt(j) == text.charAt(k)) {
				j++;
				k++;
				if (j == patternLen)
					return text.substring(i);
			}
	 
		}
	 
		return null;
	}
}
