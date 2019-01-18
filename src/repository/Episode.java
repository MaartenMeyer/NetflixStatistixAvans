package repository;

public class Episode {
    private int programmeId;
    private int episodeId;
    private String serie;
    private String title;
    private int minutes;

    public Episode(int programmeId, int episodeId, String serie, String title, int minutes) {
        this.programmeId = programmeId;
        this.episodeId = episodeId;
        this.serie = serie;
        this.title = title;
        this.minutes = minutes;
    }

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
