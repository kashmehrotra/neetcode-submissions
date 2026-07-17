class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append(',');
        }
        sb.append('#');
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if (str.equals("0,#")) {
            res.add("");
            return res;
        }
        List<Integer> sizes = new ArrayList<>();
        int start = 0, j = 0;
        System.out.println(str + " laksdjlasdkj");
        while(str.charAt(j) != '#') {
            while(str.charAt(j) != ',') {
                j++;
            }
            sizes.add(Integer.parseInt(str.substring(start, j)));
            start = j+1;
            j = start;
        }
        System.out.println(str + " laksdjlasdkj " + j);
        start=0;
        j+=1;
        System.out.println(j);
        System.out.println(sizes);
        while(j<str.length()) {
            int size = sizes.get(start++);
            res.add(str.substring(j, j+size));
            j+=size;
        }
        return res;
    }
}


















