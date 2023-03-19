package leetcode.trie;

import java.util.Map;
import java.util.HashMap;

/*
* 211. Design Add and Search Words Data Structure
* problem url: https://leetcode.com/problems/design-add-and-search-words-data-structure/
* leetcode profile url:  https://leetcode.com/jamsrandorj/
* solved by jama
*/
public class AddAndSearchWord {

	public static void main(String[] args) {
        // TODO Auto-generated method stub
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("apple");
        System.out.println(wordDictionary.search(".pple"));

	}

	class WordDictionary {
        class TrieNode {
            Boolean isWord;
            Map<Character, TrieNode> children;

            public TrieNode () {
                isWord = false;
                children = new HashMap();
            }
        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }
        
        public void addWord(String word) {
            TrieNode runner = root;
            for(char c : word.toCharArray()) {
                if(!runner.children.containsKey(c)) {
                    runner.children.put(c, new TrieNode());
                }
                runner = runner.children.get(c);
            }
            runner.isWord = true;
        }
        
        public boolean search(String word) {
            return searchFromNode(root, word, 0);
        }

        private boolean searchFromNode(TrieNode node, String word, int index) {
            if(index == word.length()) {
                return node.isWord;
            }

            char c = word.charAt(index);
            if(c == '.') {
                for(char k: node.children.keySet()) {
                    if(searchFromNode(node.children.get(k), word, index + 1)) {
                        return true;
                    }
                }

                return false;
            }

            if(!node.children.containsKey(c)) {
                return false;
            }

            return searchFromNode(node.children.get(c), word, index + 1);
        }
    }
}