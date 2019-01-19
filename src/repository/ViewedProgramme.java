package repository;

public class ViewedProgramme {
    private String filmId;
    private int numberofUsersseen;

    public ViewedProgramme(String filmId, int numberofUsersseen) {
        this.filmId = filmId;
        this.numberofUsersseen = numberofUsersseen;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public int getNumberofUsersseen() {
        return numberofUsersseen;
    }

    public void setNumberofUsersseen(int numberofUsersseen) {
        this.numberofUsersseen = numberofUsersseen;
    }
}
