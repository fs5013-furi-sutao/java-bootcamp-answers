package master.trycatch.single;

import static master.trycatch.single.util.Logger.LogType.DEBUG;
import static master.trycatch.single.util.Logger.LogType.INFO;

import master.trycatch.single.entity.Eagle;
import master.trycatch.single.entity.Pigeon;
import master.trycatch.single.entity.base.Bird;
import master.trycatch.single.util.Logger;

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

        } catch (NullPointerException | ClassCastException e) {
            Logger.log(DEBUG, "例外をキャッチしました.");
            e.printStackTrace();
        } finally {
            Logger.log(INFO, "finally ブロックです.");
        }
        Logger.log(INFO, "try-catch を抜けました.");
    }
}
