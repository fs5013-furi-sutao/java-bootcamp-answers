public class VariousArrays {
    public static void main(String[] args) {

        final int INDEX_TO_WATCH = 2;

        int[] intEmptyArray = new int[3];
        
        System.out.printf("intEmptyArray の %d 番目の要素 = %d %n"
            , INDEX_TO_WATCH, intEmptyArray[INDEX_TO_WATCH]);

        String[] strEmptyArray = new String[5];

        System.out.printf("strEmptyArray の %d 番目の要素 = %s %n"
            , INDEX_TO_WATCH, strEmptyArray[INDEX_TO_WATCH]);

        int [] idArray = new int [3];
        idArray[0] = 100;
        idArray[1] = 101;
        idArray[2] = 102;

        System.out.printf("idArray の %d 番目の要素 = %d %n"
            , INDEX_TO_WATCH, idArray[INDEX_TO_WATCH]);

        String [] namesArray = {
            "一堂零",
            "山本一郎",
            "すきやばし次郎",
            "南島三郎",
            "伊藤四郎",
            "野田五郎",
        };
    
        System.out.printf("namesArray の %d 番目の要素 = %s %n"
            , INDEX_TO_WATCH, namesArray[INDEX_TO_WATCH]);
    }
}
