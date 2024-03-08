// CST-283
// Aaron Pelto
// Winter 2024

/*
        Note that you will need to augment the linked list built in class for the removeDuplicates() method.
            Be sure to maintain the generic design for the class as you remove any votes that have a key value (voter ID) that matches one or more so that any one voter has no more than one vote.


    Your driver application should be very high level and abstract. It should be something like this:
        Primary program tasks
            Election policy101 = new Election("mainvotes.txt");
            policy101.addVotes("absentee.txt");
            policy101.removeVotes("badvotes.txt");
            policy101.removeDuplicates();
        Integrate the following action into an output message
            String outcome = policy101.didVotePass();

    Your ultimate output is a simple report to include:
        The counts for votes for and against the initiative
        A statement whether the vote passed or not.
        The output can be a simple dialog box or statement to the output console.
        No error checking is required for the program. Assume the data were validated prior to this processing.
 */

/**
 * The ElectionDriver class is the main driver program for the Election application.
 * It creates an Election object, adds votes, removes votes, removes duplicates, and prints the election results.
 */
public class ElectionDriver {

    /**
     * The filename of the file containing the main votes.
     */
    static final String MAIN_VOTES = "mainvotes.txt";

    /**
     * The filename of the file containing the votes to be added.
     */
    static final String ADD_VOTES = "absentee.txt";

    /**
     * The filename of the file containing the voter IDs of the votes to be removed.
     */
    static final String REMOVE_VOTES = "badvotes.txt";

    /**
     * The main method of the ElectionDriver class.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {

        // Create an Election object and add votes from mainvotes.txt
        Election policy101 = new Election(MAIN_VOTES);

        // Add votes from absentee.txt
        policy101.addVotes(ADD_VOTES);

        // Remove votes from badvotes.txt
        policy101.removeVotes(REMOVE_VOTES);

        // Remove duplicate votes
        policy101.removeDuplicates();

        // Print the election results
        System.out.println(policy101);
    }
}
