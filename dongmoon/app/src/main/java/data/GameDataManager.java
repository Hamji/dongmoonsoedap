package data;

public class GameDataManager {
    private static final GameDataManager settingInstance = new GameDataManager();

    private int people;
    private int round;
    private int currentRound;

    private String minor; // 주제가 다른 한 명
    private String major; // 나머지

    public static GameDataManager getInstance(){
        return settingInstance;
    }


    private GameDataManager(){
        people = 2;
        round = 1;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
