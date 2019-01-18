package repository;

public class Programme {

    private int programmeId;
    private String title;

    public Programme(int programmeId, String title) {
        this.programmeId = programmeId;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
    }

    @Override
    public String toString() {
        return "ProgrammeId" + programmeId + "Title" + title;
    }
}
