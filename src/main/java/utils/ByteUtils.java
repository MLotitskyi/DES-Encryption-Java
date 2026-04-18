package utils;

public class ByteUtils {

    public static String bytesToHex(byte[] bytes) {
        if (bytes == null) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02X", bytes[i]));
            if (i < bytes.length - 1) {
                sb.append(" ");
            }
            if ((i + 1) % 8 == 0 && i < bytes.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static byte[] hexToBytes(String hex) {
        if (hex == null || hex.isEmpty()) {
            return new byte[0];
        }

        String clean = hex.replaceAll("\\s+", "");

        if (!clean.matches("[0-9A-Fa-f]+")) {
            throw new IllegalArgumentException("Invalid hex string: contains non-hex characters");
        }

        if (clean.length() % 2 != 0) {
            clean = "0" + clean;
        }

        int len = clean.length();
        byte[] data = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(clean.charAt(i), 16) << 4)
                    + Character.digit(clean.charAt(i + 1), 16));
        }

        return data;
    }
}