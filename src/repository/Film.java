package repository;

import java.util.Date;

public class Film {
    private int filmId;
    private int programmeId;
    private String title;
    private String language;
    private int ageIndication;
    private int minutes;
    private String genre;

    public Film(int filmId, int programmeId, String title, String language, int ageIndication, int minutes, String genre) {
        this.filmId = filmId;
        this.programmeId = programmeId;
        this.title = title;
        this.language = language;
        this.ageIndication = ageIndication;
        this.minutes = minutes;
        this.genre = genre;
    }


    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAgeIndication() {
        return ageIndication;
    }

    public void setAgeIndication(int ageIndication) {
        this.ageIndication = ageIndication;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "FilmId: " + filmId +
                " ProgrammeId: " + programmeId +
                " Title: " + title +
                " Language: " + language +
                " Age: " + ageIndication +
                " Minutes: " + minutes +
                " Genre: " + genre;
    }
}
