package des;

public class Round {

    public static byte[] process(byte[] data, byte[] roundKey) {

        byte[] L = new byte[4];
        byte[] R = new byte[4];

        System.arraycopy(data, 0, L, 0, 4);
        System.arraycopy(data, 4, R, 0, 4);

        byte[] newR = f(R, roundKey);

        byte[] newL = xor(L, newR);

        byte[] result = new byte[8];
        System.arraycopy(R, 0, result, 0, 4);      // Стара R стає новою L
        System.arraycopy(newL, 0, result, 4, 4);   // newL стає новою R

        return result;
    }

    private static byte[] f(byte[] R, byte[] roundKey) {
        byte[] expandedR = Permutation.permute(R, Permutation.E, 48);

        byte[] xored = xor(expandedR, roundKey);

        byte[] sBoxOutput = SBox.substitute(xored);

        return Permutation.permute(sBoxOutput, Permutation.P, 32);
    }

    private static byte[] xor(byte[] a, byte[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays must have same length");
        }
        byte[] result = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = (byte) (a[i] ^ b[i]);
        }
        return result;
    }
}