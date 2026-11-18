class LC151_ReverseWordsInString {
    public String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");

        StringBuilder answer = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {

            if (words[i].isEmpty()) {
                continue;
            }

            if (answer.length() > 0) {
                answer.append(" ");
            }

            answer.append(words[i]);
        }

        return answer.toString();
    }
}
