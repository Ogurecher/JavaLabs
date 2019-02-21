public class U0901Main {

    public static void main(String[] args) {
        Integer[] intArr = {10,20,15};
        Float[] floatArr = new Float[3];

        for (int i = 0; i < floatArr.length; ++i) {
            floatArr[i] = (float)i / (float)2;
        }

        U0901WorkArray insWorkArrayInt, insWorkArrayFloat;

        insWorkArrayInt = new U0901WorkArray(intArr);
        insWorkArrayFloat = new U0901WorkArray(floatArr);

        System.out.println(insWorkArrayInt.sum());
        System.out.println(insWorkArrayFloat.sum());
    }

}