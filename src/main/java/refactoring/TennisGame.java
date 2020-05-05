package refactoring;

public class TennisGame {
    public static final String LOVE     = "Love";
    public static final String FIFTEEN  = "Fifteen";
    public static final String THIRTYTY = "Thirty";
    public static final String FORTY    = "Forty";
    public static final String DRAW     = "Draw";

    public static final String ADVANTAGE_PLAYER1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER2 = "Advantage player2";
    public static final String WIN_PLAYER1       = "Win for player1";
    public static final String WIN_PLAYER2       = "Win for player2";
    
    public int player1Score = 0;
    public int player2Score = 0;

    public String status    = "";

    public boolean isPlay   = false;

    /**
     * @return the player1Score
     */
    public String getPlayer1Score() {
        switch (player1Score) {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTYTY;
            case 3:
                return FORTY;
        }
        return "";
    }
    /**
     * @param player1Score the player1Score to set
     */
    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
        checkWin();
    }

    /**
     * @return the player2Score
     */
    public String getPlayer2Score() {
        switch (player2Score) {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTYTY;
            case 3:
                return FORTY;
        }
        return "";
    }

    /**
     * @param player2Score the player2Score to set
     */
    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
        checkWin();
    }

    public void checkWin() {
        boolean equalScore = player1Score == player2Score;
        if(equalScore && player1Score == 3){
            status = DRAW;
        }else if (player1Score >= 4 || player2Score >= 4){
            int minusResult = player1Score - player2Score;
            if (minusResult == 1){
                status = ADVANTAGE_PLAYER1;
            }
            else if (minusResult == -1){
                status = ADVANTAGE_PLAYER2;
            }
            else if (minusResult >= 2){
                status = WIN_PLAYER1;
                isPlay = false;
            }
            else {
                status = WIN_PLAYER2;
                isPlay = false;
            }
        }
    }

    public String getStatus() {
        return status;
    }
}
