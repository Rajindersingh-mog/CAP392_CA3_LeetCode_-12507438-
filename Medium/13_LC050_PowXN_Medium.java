class LC050_PowXN {
    public double myPow(double x, int n) {

        long exponent = n;

        if (exponent < 0) {

            x = 1.0 / x;

            exponent = -exponent;
        }

        double answer = 1.0;

        while (exponent > 0) {

            if ((exponent & 1) == 1) {
                answer = answer * x;
            }

            x = x * x;

            exponent = exponent >> 1;
        }

        return answer;
    }
}
