public enum OperatorType {
    PLUS{
        @Override
        public double operating(double num1, double num2) {
            return num1 + num2;
        }
    },
    MINUS{
        @Override
        public double operating(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY{
        @Override
        public double operating(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE{
        @Override
        public double operating(double num1, double num2) {
            return num1 / num2;
        }
    },
    POW{
        @Override
        public double operating(double num1, double num2) {
            return Math.pow(num1, num2);
        }
    },
    MOD{
        @Override
        public double operating(double num1, double num2) {
            return num1 % num2;
        }
    };

    public abstract double operating(double num1, double num2);
}
