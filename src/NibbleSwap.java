public class NibbleSwap {
    public static byte swapNibbles(byte b) {
        byte un = (byte) ((b&0xF0) >>> 4);
        byte ln = (byte) (b&0x0F);
        byte sn = (byte) (ln << 4 | un);
        return sn;
    }

    public static void main(String[] args) {
        byte byteValue = (byte) 0xAB;  // 1010 1011 in binary
        byte swappedByte = swapNibbles(byteValue);

        System.out.println("Original byte: " + Integer.toBinaryString(byteValue & 0xFF));
        System.out.println("Swapped byte: " + Integer.toBinaryString(swappedByte & 0xFF));
    }
}