public class HW06_4108056038_1 extends Dessert_Desert {
    public static void main(String[] args) {
        HW06_4108056038_1 test = new HW06_4108056038_1();
        int[][] a = {{23,44,60,49,48,71,59,73,87,89,85,93,89,114,106,117,125,104,117,133,141,164,142,141,138,135,141,128,140,164,167,168,147,152,144,155,159,149,141,162,187,179,204},{208,199,190,175,181,200,226,249,266,271,295,282,285,269,267,244,237,242,259,244,255,254,269,261,270,264,275,284,272,258,284,289,306,289,310,319,309,315,296,295,288,265,262,279,295,320,339,331,339,347,332,326,345,329,333,316,317}};
        for(int i=0;i<a.length;i++) {
            System.out.println(test.maxBlocks(a)[i]);
        }
    }
    public int[] maxBlocks(int[][] inputArr) {
        int len = inputArr.length;
        int[] re = new int[len];
        for(int i=0;i<len;i++) {
            int jlen = inputArr[i].length;
            int[] max = new int[jlen];
            int[] min = new int[jlen];
            int count=1;
            max[0]=min[0]=inputArr[i][0];
            for(int j=1;j<jlen;j++) {
                if(inputArr[i][j]>=max[count-1]) {
                    count++;
                    max[count-1]=min[count-1]=inputArr[i][j];
                }else if (inputArr[i][j]<min[count-1]) {
                    min[count-1]=inputArr[i][j];
                    for (int check=count-2;check>=0;check--) {
                        if (inputArr[i][j]>=max[check]) break;
                        else if (inputArr[i][j]>=min[check]) {
                            count--;
                            max[check]=max[check+1];
                            break;
                        }else {
                            count--;
                            min[check]=inputArr[i][j];
                            max[check]=max[check+1];
                        }
                    }
                }
            }
            re[i]=count; 
        }
        return re;
    }
}
