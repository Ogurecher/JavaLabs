class Main {
    public static void main (String[] args) {
        System.out.println("Excersize 1\nStarting project\n\nExcersize 2");

        boolean vBoolean = true;
        System.out.println("Boolean: " + vBoolean);
        byte vByte = 120;
        System.out.println("Byte: " + vByte);
        short vShort = 129;
        System.out.println("Short: " + vShort);
        char vChar = 'a';
        System.out.println("Char: " + vChar);
        int vInt = 65999;
        System.out.println("Int: " + vInt);
        long vLong = 429496729;
        System.out.println("Long: " + vLong);
        float vFloat = 0.33333334f;
        System.out.println("Float: " + vFloat);
        double vDouble = 0.3333333333333333;
        System.out.println("Double: " + vDouble);

        System.out.println("\nExcersize 3");
        for (char letter = 'a'; letter <= 'z'; ++letter) {
            System.out.print(letter + " ");
        }

        long begin = new java.util.Date().getTime();
        for (long i = 0; i <= 100000000; ++i) { }
        long end = new java.util.Date().getTime();
        System.out.println("\n" + (end - begin));

        System.out.println("\nExcersize 5");
        int [] array = {12,43,12,-65,778,123,32,76};
        System.out.print("Finding max in: {");
        int max = array[0];

        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("}\nMax: " + max + "\n");

        int [][] matrix = new int[3][3];

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                matrix [i][j] = (int)Math.round(Math.random() * 10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}