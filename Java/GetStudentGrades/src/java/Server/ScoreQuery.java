package Server;

import java.util.ArrayList;

public interface ScoreQuery {
    public void getScoreByNmae(String name);
    public void getScoreByShcool(String school);
    public void getScoreByScore(int minScore, int maxScore);
    public void getScoreByClass(String className, ArrayList<String> classList);
}
