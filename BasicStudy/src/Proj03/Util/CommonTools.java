package Proj03.Util;

import java.util.Arrays;

public class CommonTools {
    public static int isFull(Object[] arrays){
        for (int i = 0;i<arrays.length;i++){
            if (arrays[i] == null){
                return i;
            }
        }
        return -1;
    }
    public static int isExsist(Object[] arrays,Object o2){
        for (int i = 0;i<arrays.length;i++){
            if (arrays[i] == o2 ){
                return i;
            }
        }
        return -1;
    }
}
