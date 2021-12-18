// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// Intuition :- To make the string valid with minimum removals, we need to get rid of all parentheses that do not have a matching pair.


// Stack me sirf invalid '(' rahega, without pair
/*
	  Approach:-
	  --------
	  1) Push char index into the stack when we see '('
	  2) Pop from the stack when we see ')'
	  3) If the stack is empty, then we have ')' without the pair => invalid bracket => replace

	  In the end, the stack will contain indexes of '(' without the pair, if any. 
	  We need to remove all of them too.
*/

class Solution {
    
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>(); // Stack will contain all invalid '(' idx  
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i); // Add in stack, so that when ')' comes, it can pop out '(' and balance
            }
            else if(c == ')') {
                if(!stack.isEmpty()) stack.pop(); // If there exists something, you know that it is always '('
                else sb.setCharAt(i, '*'); // If you do not have anything in stack and ')' comes then it is invalid
            }
        }
        
        // Stack will contain all '(' invalid idx
        // NOTE: All invalid ')' is already replaced by '*'
        
        // Now replace all invalid '(' with '*'
        while(!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        
        // Replace all invalid '(' and ')' which was marked as '*' from the string
        return sb.toString().replaceAll("\\*", "");
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX// Same as above bs yaha stack me sara invalid brackets rahega i.e '(' + ')'

// Same as above bs yaha stack me sara invalid brackets rahega i.e '(' + ')' jiske pairs nai mile

/*
	  Approach:-
	  --------
	  1) Push char index into the stack when we see '(' 
	  2) Pop from the stack when we see ')' and stack top is '(' 
	  		else If the stack is empty, push ')' without the pair => invalid bracket 

	  In the end, the stack will contain indexes of '(' and ')' without the pair, 
	  If any we need to remove all of them.
*/

class Solution {
    
    public static class Pair {
        char c;
        int idx;
        
        public Pair(char c, int idx) {
            this.c = c;
            this.idx = idx;
        }
    }
    
    public String minRemoveToMakeValid(String s) {
        
        // Created Pair class, because we have to store both bracket and their idx position
        Stack<Pair> stack = new Stack<>();  
        char[] ch = s.toCharArray();
        
        for(int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if(c == '(') {
                stack.push(new Pair('(', i));
            }
            else if(c == ')') {
                if(!stack.isEmpty() && stack.peek().c == '(') stack.pop();
                else stack.push(new Pair(')', i));
            }
        }
        
        // Stack contains all the invalid brackets Pair
        
        // Replace all invalid idx with '*'
        StringBuilder sb = new StringBuilder(s);
        for(Pair pair : stack) {
            sb.setCharAt(pair.idx, '*');
        }
        
        // Replace all invalid '(' and ')' which was marked as '*' from the string
        return sb.toString().replaceAll("\\*", "");
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// Mine, With Extra Space of Set 
// Faltu
// * mark kar dene wala scene nai soch paayi

class Solution {
    
    public static class Pair {
        char c;
        int idx;
        
        public Pair(char c, int idx) {
            this.c = c;
            this.idx = idx;
        }
    }
    
    public String minRemoveToMakeValid(String s) {
        
        // Created Pair class, because we have to store both bracket and their idx position
        Stack<Pair> stack = new Stack<>();  
        char[] ch = s.toCharArray();
        
        for(int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if(c == '(') {
                stack.push(new Pair('(', i));
            }
            else if(c == ')') {
                if(!stack.isEmpty() && stack.peek().c == '(') stack.pop();
                else stack.push(new Pair(')', i));
            }
        }
        
        // Stack contains all the invalid brackets Pair
        
        // Adding all invalid bracket idx in HashSet to get it in O(1)
        Set<Integer> invalidIdx = new HashSet<>(); 
        for(Pair pair : stack) {
            invalidIdx.add(pair.idx);
        }
        
        // Now escape all the idx which is present in HashSet 
        // and form answer from the original given string in question
        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < ch.length; idx++) {
            if(!invalidIdx.contains(idx)) {
                sb.append(ch[idx]);        
            }
        }
        
        return sb.toString();
    }
}
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
