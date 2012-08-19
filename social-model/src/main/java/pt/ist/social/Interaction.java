package pt.ist.social;

import java.util.HashSet;
import java.util.Set;

import pt.ist.authentication.User;

public class Interaction extends Interaction_Base {

    public void init(User creator, boolean creatorIsParticipant) {
        addParticipant(ParticipationRole.CREATOR, creator);
        if(creatorIsParticipant) {
            addParticipant(ParticipationRole.PARTICIPANT, creator);	
        }
    }

    public void addParticipant(ParticipationRole participationRole, User participant) {
        ParticipationRolePlay participantRolePlay = new ParticipationRolePlay();
        participantRolePlay.init(participationRole, participant);
        addParticipationRolePlay(participantRolePlay);
    }

    public void removeParticipant(User participant) {
        for(ParticipationRolePlay participationRolePlay : getParticipationRolePlaySet()) {
            if(participationRolePlay.getParticipant().equals(participant)) {
                participationRolePlay.terminate();
                return;
            }
        }
    }

    public Set<User> getAllParticipantSet() {
        Set<User> participantSet = new HashSet<User>();
        for(ParticipationRolePlay participationRolePlay : getParticipationRolePlaySet()) {
            participantSet.add(participationRolePlay.getParticipant());
        }
        return participantSet;
    }

    public Set<User> getParticipantSet(ParticipationRole participationRole) {
        Set<User> participantSet = new HashSet<User>();
        for(ParticipationRolePlay participationRolePlay : getParticipationRolePlaySet()) {
            if(participationRolePlay.hasParticipationRole(participationRole)) {
                participantSet.add(participationRolePlay.getParticipant());
            }
        }
        return participantSet;
    }
    
    public ParticipationRole getParticipationRoleOftheUser(User user){
    	for(ParticipationRolePlay participantionRolePlay : getParticipationRolePlay()){
			if(participantionRolePlay.getParticipant().getOID() == user.getOID()){
				return participantionRolePlay.getRole();
			}
		}
		return null;
    }
    
	public void createDiscussion(User creator, String subject) {
		Discussion discussion =  new Discussion();
		discussion.init(subject, creator);
		addDiscussion(discussion);
	}

}
