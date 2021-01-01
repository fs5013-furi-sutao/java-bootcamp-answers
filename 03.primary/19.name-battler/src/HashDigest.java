import java.math.BigInteger;
import java.security.MessageDigest;

public class HashDigest {
    public static void main(String[] args) {

        HashDigest app = new HashDigest();
        String[] names = { 
            "最強の戦士の血を引くもの", 
            "伝説の勇者の友達", 
        };

        String[] digests = { 
            app.getHashDigest(names[0]), 
            app.getHashDigest(names[1]), };

        for (int i = 0; i < digests.length; i++) {
            System.out.printf(
                "「%s」のハッシュ値は「%s」%n", 
                names[i], digests[i]
            );
        }

        System.out.println(app.generateNumber(names[0], 0));
        System.out.println(app.generateNumber(names[0], 1));
        System.out.println(app.generateNumber(names[0], 2));
    }

    /**
     * ハッシュダイジェストから数値を取り出す
     * @param name 名前
     * @param index 何番目の数値を取り出すか
     * @return 数値(0 ～ 255)
     */
    public int generateNumber(String name, int index) {
        try {
            String digest = getHashDigest(name);

            String hex = digest.substring(
                index * 2, index * 2 + 2
            );
            
            return Integer.parseInt(hex, 16);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getHashDigest(String name) {
        try {
            // ハッシュ値を取得する
            byte[] result =
                MessageDigest.getInstance("SHA-1")
                .digest(name.getBytes());

            return String.format(
                "%040x",
                new BigInteger(1, result)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}