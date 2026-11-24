package software.ulpgc.kata4.domain;

public class Game {
    private final String id;
    private final String title;
    private final Platform platform;
    private final int year;
    private final Genre genre;

    public Game(String id, String title, Platform platform, int year, Genre genre) {
        this.id = id;
        this.title = title;
        this.platform = platform;
        this.year = year;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public int getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }
}
