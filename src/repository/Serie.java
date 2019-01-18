package repository;

public class Serie {
    private int programmeId;
    private String title;
    private int seasons;
    private int ageIndication;
    private String language;
    private String genre;
    private String looksLike;

    public Serie(int programmeId, String title, int seasons, int ageIndication, String language, String genre, String looksLike) {
        this.programmeId = programmeId;
        this.title = title;
        this.seasons = seasons;
        this.ageIndication = ageIndication;
        this.language = language;
        this.genre = genre;
        this.looksLike = looksLike;
    }

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getAgeIndication() {
        return ageIndication;
    }

    public void setAgeIndication(int ageIndication) {
        this.ageIndication = ageIndication;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLooksLike() {
        return looksLike;
    }

    public void setLooksLike(String looksLike) {
        this.looksLike = looksLike;
    }
}
