public class HW06_4108056038_2 extends Dessert_Desert {
    public static void main(String[] args) {
        HW06_4108056038_2 test = new HW06_4108056038_2();
        int[][] a = {{1,1,1,2,2,2,3,3,3,4,2}};
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
                    int l,r,mid;
                    l=0;
                    r=count-1;
                    while(true) {
                        if(l+1==r) {
                            if(inputArr[i][j]>=max[l]) {
                                min[r]=inputArr[i][j];
                                max[r]=max[count-1];
                                count=r+1;
                                break;
                            }else if(inputArr[i][j]>=min[l]) {
                                count=r;
                                break;
                            }else {
                                min[l]=inputArr[i][j];
                                count=r;
                                break;
                            }
                            
                        }
                        if(l-r==0) {
                            min[r]=inputArr[i][j];
                            break;
                        }
                        mid=(l+r)/2;
                        if(inputArr[i][j]>=max[mid]) {
                            l=mid;
                            continue;
                        }else if(inputArr[i][j]>=min[mid]) {
                            max[mid]=max[count-1];
                            count=mid+1;
                            break;
                        }else {
                            r=mid;
                            continue;
                        }
                    }
                }
            }
            re[i]=count; 
        }
        return re;
    }
}
