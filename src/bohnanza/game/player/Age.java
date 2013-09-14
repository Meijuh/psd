package bohnanza.game.player;

public class Age {

    private final String year;

    private final String month;

    private final String day;

    public Age(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getBirthday() {
        return Integer.valueOf(year + month + day);
    }

    public boolean isOlderThan(Age age) {
        return getBirthday() <= age.getBirthday();
    }
}
