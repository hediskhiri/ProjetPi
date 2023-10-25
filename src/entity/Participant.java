package entity;

public class Participant {
    private int id;
    private int id_event;
    private String user_Name;
    private String user_Email;

    public Participant(int id, int eventId, String userName, String userEmail) {
        this.id = id;
        this.id_event = id_event;
        this.user_Name = user_Name;
        this.user_Email = user_Email;
    }

    public Participant(int id_event, String userName, String userEmail) {
        this.id_event = id_event;
        this.user_Name = userName;
        this.user_Email = userEmail;
    }

    public Participant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return id_event;
    }

    public void setEventId(int id_event) {
        this.id_event = id_event;
    }

    public String getUserName() {
        return user_Name;
    }

    public void setUserName(String userName) {
        this.user_Name = user_Name;
    }

    public String getUserEmail() {
        return user_Email;
    }

    public void setUserEmail(String userEmail) {
        this.user_Email = user_Email;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", eventId=" + id_event +
                ", userName='" + user_Name + '\'' +
                ", userEmail='" + user_Email + '\'' +
                '}';
    }
}
