package repository;

import java.util.Date;

public class Profile {
    private int subscriptionId;
    private String profileName;
    private Date birthdate;

    public Profile(int subscriptionId, String profileName, Date birthdate) {
        this.subscriptionId = subscriptionId;
        this.profileName = profileName;
        this.birthdate = birthdate;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
