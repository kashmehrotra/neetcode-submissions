class Solution {
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1;i>=0;i--) {
            sb.append(s.charAt(i));
        }
        int len = sb.length();
        for (int i=0;i<32-len;i++) {
            sb.append(0);
        }
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}
