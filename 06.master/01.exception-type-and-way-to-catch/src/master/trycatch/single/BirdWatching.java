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
        boolean isNeedToConvertToPigeon = false;

        BirdWatching app = new BirdWatching();
        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);
        System.out.println();

        isNeedToValidPigeon = false;
        isNeedToConvertToPigeon = true;
        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);
        System.out.println();

        isNeedToConvertToPigeon = false;
        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);
    }

    private void execute(
            boolean isNeedToValidPigeon,
            boolean isNeedToConvertToPigeon) {

        Bird eagle = new Eagle("オジロワシ");
        Bird pigeon = new Pigeon(null);

        try {
            eagle.fly();
            if (isNeedToValidPigeon) {
                pigeon.fly();
                pigeon.isEmptyName();
            }
            if (isNeedToConvertToPigeon) {
                Bird convertedPigeon = Bird.convertToPigeon(eagle);
                convertedPigeon.fly();
            }
        } catch (NullPointerException | ClassCastException e) {
            Logger.log(DEBUG, e);
        } finally {
            Logger.log(INFO, "finally ブロックです.");
        }
        Logger.log(INFO, "try-catch を抜けました.");
    }
}
