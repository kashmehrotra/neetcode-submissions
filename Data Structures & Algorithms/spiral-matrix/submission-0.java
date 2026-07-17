class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int x = matrix[0].length;
        int y = matrix.length;
        int initx = 0, endx = x-1, inity = 0, endy = y-1;
        while(initx <= endx && inity <= endy) {
            for (int i=initx;i<=endx;i++) {
                result.add(matrix[inity][i]);
            }
            for (int i=inity+1;i<=endy;i++) {
                result.add(matrix[i][endx]);
            }
            if (inity < endy) {
                for (int i=endx-1;i>=initx;i--) {
                    result.add(matrix[endy][i]);
                }
            }
            if (initx < endx) {
                for (int i=endy-1;i>inity;i--) {
                    result.add(matrix[i][initx]);
                }
            }
            initx++;
            endx--;
            inity++;
            endy--;
        }
        return result;
    }
}
