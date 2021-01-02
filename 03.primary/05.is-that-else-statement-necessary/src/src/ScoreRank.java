public class ScoreRank {
    public static void main(String[] args) {

        ScoreRank app = new ScoreRank();
        int score = 55;

        System.out.printf(
            "得点が %d 点のランクは %s です.",
            score, app.createScoreRank(score)
        );
        
    }

    public String createScoreRank(int score) {
        if (score >= 90) return "S";
        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 60) return "C";
        return "F";
    } 
}
