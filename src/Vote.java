/*
    - voterID : int
    – theVote : boolean or int
    + Vote()
    + Vote(boolean)
    + { set and get methods }
    + toString() : String
 */

/**
 * The Vote class represents a vote in an election.
 */
public class Vote {

    /**
     * The unique identifier for the voter.
     */
    private int voterID;

    /**
     * The vote cast by the voter. True represents a vote in favor, false represents a vote against.
     */
    private boolean vote;

    /**
     * Constructor that initializes a Vote object with a specific voterID and vote value.
     *
     * @param voterID The unique identifier for the voter.
     * @param vote The vote cast by the voter.
     */
    public Vote(int voterID, boolean vote) {
        this.voterID = voterID;
        this.vote = vote;
    }

    /**
     * Constructor that initializes a Vote object with a specific vote value, but without a specific voterID.
     *
     * @param vote The vote cast by the voter.
     */
    public Vote(boolean vote) {
        this.vote = vote;
    }

    /**
     * Returns the voterID of the Vote object.
     *
     * @return The voterID of the Vote object.
     */
    public int getVoterID() {
        return voterID;
    }

    /**
     * Sets the voterID of the Vote object.
     *
     * @param voterID The new voterID for the Vote object.
     */
    public void setVoterID(int voterID) {
        this.voterID = voterID;
    }

    /**
     * Returns the vote value of the Vote object.
     *
     * @return The vote value of the Vote object.
     */
    public boolean getTheVote() {
        return vote;
    }

    /**
     * Sets the vote value of the Vote object.
     *
     * @param theVote The new vote value for the Vote object.
     */
    public void setTheVote(boolean theVote) {
        this.vote = theVote;
    }

    /**
     * Returns a string representation of the Vote object.
     *
     * @return A string representing the voterID and vote value of the Vote object.
     */
    public String toString() {
        return "Voter ID: " + voterID + " voted: " + vote;
    }
}
