package player;

/**
 * プレイヤーの基底クラス
 */
public abstract class Player {
    /** プレイヤー名 */
    protected String name;
    /** プレイヤーのHP */
    protected int hp;
    /** プレイヤーのMP */
    protected int mp;
    /** プレイヤーの攻撃力 */
    protected int str;
    /** プレイヤーの防御力 */
    protected int def;
    /** プレイヤーの運 */
    protected int luck;
    /** プレイヤーの素早さ */
    protected int agi;

    // TODO コンストラクタの内容を記述（引数含む）
    /**
     * プレイヤーのコンストラクタ
     */
    public Player(){
        
    }

    /**
     * プレイヤー名を取得
     * @return プレイヤー名
     */
    public String getName(){
        return name;
    }

    /**
     * HPを取得
     * @return HPを返す
     */
    public int getHp(){
        return hp;
    }

    /**
     * MPを取得
     * @return MPを返す
     */
    public int getMp() {
        return mp;
    }

    /**
     * 攻撃力を取得
     * @return　攻撃力を返す
     */
    public int getStr() {
        return str;
    }

    /**
     * 防御力を取得
     * @return 防御力を返す
     */
    public int getDef() {
        return def;
    }

    /**
     * 運を取得
     * @return 運を返す
     */
    public int getLuck() {
        return luck;
    }

    /**
     * 素早さを取得
     * @return 素早さを返す
     */
    public int getAgi() {
        return agi;
    }

    /**
     * 対戦相手を攻撃
     * @param opponent 攻撃対象のプレイヤー
     */
    public abstract void attack(Player opponent);

    // TODO 必要なメソッドに応じてメソッドを追加
}
