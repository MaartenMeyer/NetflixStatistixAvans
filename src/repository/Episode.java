package repository;

public class Episode {
    private int episodeId;
    private int programmeId;
    private String serie;
    private String title;
    private int minutes;

    public Episode(int episodeId, int programmeId, String serie, String title, int minutes) {
        this.episodeId = episodeId;
        this.programmeId = programmeId;
        this.serie = serie;
        this.title = title;
        this.minutes = minutes;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
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
