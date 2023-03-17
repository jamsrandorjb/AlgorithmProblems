package leetcode.trie;

import java.util.Map;
import java.util.HashMap;

/*
* 208. Implement Trie (Prefix Tree)
* problem url: https://leetcode.com/problems/implement-trie-prefix-tree/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class ImplementTrie {

	public static void main(String[] args) {
        // TODO Auto-generated method stub
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));

	}

	class Trie {
        TrieNode root;

        class TrieNode {
            Boolean isWord = false;
            Map<Character, TrieNode> children = new HashMap<>();
        }

        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode runner = root;
            for(char c: word.toCharArray()) {
                if(!runner.children.containsKey(c)) {
                    runner.children.put(c, new TrieNode());    
                }

                runner = runner.children.get(c);
            }
            runner.isWord = true;
        }
        
        public boolean search(String word) {
            TrieNode runner = root;
            for(char c: word.toCharArray()) {
                if(!runner.children.containsKey(c)) {
                    return false;
                }

                runner = runner.children.get(c);
            }

            return runner.isWord;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode runner = root;
            for(char c: prefix.toCharArray()) {
                if(!runner.children.containsKey(c)) {
                    return false;
                }
                
                runner = runner.children.get(c);
            }

            return runner != null;
        }
    }
}