package leetcode.algorithms.level.Medium;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * <p>
 * Tags: Design, Trie
 * Similar Problems: (M) Add and Search Word - Data structure design
 */
public class ImplementTrie {

    class TrieNode {
        private final int R = 26;
        private TrieNode[] links;
        private boolean isEnd;

        // Initialize your data structure here.
        public TrieNode() {
            links = new TrieNode[26];
        }

        public boolean hasLink(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode getNode(char ch) {
            return links[ch -'a'];
        }
        public void putNode(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }

    public class Trie {
        private TrieNode root;
        private int size;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if (word == null) return;
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.hasLink(currentChar)) {
                    node.putNode(currentChar, new TrieNode());
                }
                node = node.getNode(currentChar);
            }
            node.setEnd();
            size++;
        }

        // search a prefix or whole key in trie and
        // returns the node where search ends
        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (node.hasLink(currentChar)) {
                    node = node.getNode(currentChar);
                } else {
                    return null;
                }
            }
            return node;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if (word == null) return false;
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if (prefix == null) return false;
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
}
