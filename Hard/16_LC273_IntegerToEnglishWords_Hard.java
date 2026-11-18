class LC273_IntegerToEnglishWords {

    private static final String[] BELOW_20 = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen",
        "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] THOUSANDS = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();

        int group = 0;

        while (num > 0) {

            int part = num % 1000;

            if (part != 0) {

                String words = threeDigitsToWords(part);

                String suffix = THOUSANDS[group];

                result.insert(0,
                    words +
                    (suffix.isEmpty() ? "" : " " + suffix) + " ");
            }

            num = num / 1000;

            group++;
        }

        return result.toString().trim().replaceAll("\\s+", " ");
    }

    private String threeDigitsToWords(int num) {

        StringBuilder words = new StringBuilder();

        if (num >= 100) {

            words.append(BELOW_20[num / 100]);
            words.append(" Hundred");

            num = num % 100;

            if (num > 0) {
                words.append(" ");
            }
        }

        if (num >= 20) {

            words.append(TENS[num / 10]);

            num = num % 10;

            if (num > 0) {
                words.append(" ");
                words.append(BELOW_20[num]);
            }

        } else if (num > 0) {

            words.append(BELOW_20[num]);
        }

        return words.toString();
    }
}
