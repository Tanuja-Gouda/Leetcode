class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];
        int[] lastOccur = new int[26];

        // Record last occurrence index of each char
        for (int i = 0; i < s.length(); i++) {
            lastOccur[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If character already in result, skip
            if (seen[c - 'a']) continue;

            // Remove characters from stack if:
            // - current char is smaller than top of stack
            // - top of stack appears later again
            while (!stack.isEmpty() && c < stack.peek() && i < lastOccur[stack.peek() - 'a']) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[c - 'a'] = true;
        }

        // Build final string
        StringBuilder result = new StringBuilder();
        for (char ch : stack) result.append(ch);

        return result.toString();
    }
}