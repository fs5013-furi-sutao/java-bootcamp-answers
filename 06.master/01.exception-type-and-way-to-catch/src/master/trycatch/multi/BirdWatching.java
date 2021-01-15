package master.trycatch.multi;

import static master.trycatch.multi.util.Logger.LogType.DEBUG;
import static master.trycatch.multi.util.Logger.LogType.INFO;

import master.trycatch.multi.entity.base.Bird;
import master.trycatch.multi.entity.Eagle;
import master.trycatch.multi.entity.Pigeon;
import master.trycatch.multi.util.Logger;

public class BirdWatching {

    public static void main(String[] args) {

        boolean isNeedToValidPigeon = true;

        BirdWatching app = new BirdWatching();
        app.execute(isNeedToValidPigeon);
        System.out.println();

        isNeedToValidPigeon = false;
        app.execute(isNeedToValidPigeon);
    }

    private void execute(boolean isNeedToValidPigeon) {

        Bird eagle = new Eagle("オジロワシ");
        Bird pigeon = new Pigeon(null);

        try {
            eagle.fly();

            if (isNeedToValidPigeon) {
                pigeon.isEmptyName();
            }

            Bird convertedPigeon = Bird.convertToPigeon(eagle);
            convertedPigeon.fly();

        } catch (NullPointerException e) {
            Logger.log(DEBUG, "[ヌルポ] 例外をキャッチしました.");
            e.printStackTrace();
        } catch (ClassCastException e) {
            Logger.log(DEBUG, "[キャスト例外] 例外をキャッチしました.");
            e.printStackTrace();
        } finally {
            Logger.log(INFO, "finally ブロックです.");
        }
        Logger.log(INFO, "try-catch を抜けました.");
    }
}
