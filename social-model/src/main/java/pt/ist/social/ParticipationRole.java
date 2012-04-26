package pt.ist.social;

public class ParticipationRole {

    public final static ParticipationRole CREATOR = new ParticipationRole("CREATOR");
    public final static ParticipationRole PARTICIPANT = new ParticipationRole("PARTICIPANT");

    private String participationRole;

    public ParticipationRole(String participationRole) {
        this.participationRole = participationRole;
    }

    public String getParticipationRole() {
        return participationRole;
    }

    @Override
    public String toString() {
        return participationRole;
    }
}
