class Solution {
    public int reverseBits(int n) {
        System.out.println(n);
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1;i>=0;i--) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
        int len = sb.length();
        for (int i=0;i<32-len;i++) {
            sb.append(0);
        }
        System.out.println(sb.toString());
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}
