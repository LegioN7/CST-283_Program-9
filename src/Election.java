/*
    – voteList: LinkedList<Votes>
    + Election()
    + Election(String filename)
    + addVotes(String filename) : void
    + removeVotes(String filename) : void
    + removeDuplicates() : void
    + didVotePass() : String
    + toString() : String

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Election class represents an election with a list of votes.
 */
    public class Election {

    /**
     * A LinkedList of Vote objects representing the votes in the election.
     */
    private LinkedList<Vote> voteList;

    /**
     * Default constructor that initializes an empty list of votes.
     */
        public Election() {
            this.voteList = new LinkedList<>();
        }

    /**
     * Constructor that initializes the list of votes from a file.
     *
     * @param filename The name of the file containing the votes.
     */
        public Election(String filename) {
            this();
            addVotes(filename);
        }

    /**
     * Adds votes from a file to the list of votes.
     *
     * @param filename The name of the file containing the votes.
     */
        public void addVotes(String filename) {
            try {
                Scanner scanner = new Scanner(new File(filename));
                while (scanner.hasNextLine()) {
                    String[] line = scanner.nextLine().split(" ");
                    int voterID = Integer.parseInt(line[0]);
                    int vote = Integer.parseInt(line[1]);
                    this.voteList.add(new Vote(voterID, vote));
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    /**
     * Removes votes from the list of votes based on a file of voter IDs.
     *
     * @param filename The name of the file containing the voter IDs of the votes to be removed.
     */
        // Remove any votes that have a key value (voter ID) that matches one or more so that any one voter has no more than one vote.
    public void removeVotes(String filename) {
        try {
            // Read the voter IDs from the file and remove the corresponding votes from the list
            // badvotes.txt is a file containing the voter IDs of the votes to be removed.
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                // Parse the voter ID from the file
                int voterID = Integer.parseInt(scanner.nextLine());
                // Remove the vote with the corresponding voter ID from the list
                Vote voteToRemove = null;
                // Find the vote with the corresponding voter ID
                // Remove the vote from the list
                this.voteList.resetList();
                while (!this.voteList.atEnd()) {
                    Vote vote = this.voteList.getNextItem();
                    if (vote.getVoterID() == voterID) {
                        voteToRemove = vote;
                        break;
                    }
                }
                // Remove the vote from the list
                if (voteToRemove != null) {
                    this.voteList.remove(voteToRemove);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes duplicate votes from the list of votes.
     */
        public void removeDuplicates() {

            // Create a new list to store unique votes
            LinkedList<Vote> uniqueVotes = new LinkedList<>();

            // Counter for the number of duplicate votes
            int duplicateCount = 0;

            // Iterate through the list of votes and add unique votes to the new list
            this.voteList.resetList();
            while (!this.voteList.atEnd()) {
                Vote vote = this.voteList.getNextItem();

                // Check if the voter ID is already in the list of unique votes
                boolean isDuplicate = false;
                uniqueVotes.resetList();
                while (!uniqueVotes.atEnd()) {
                    Vote uniqueVote = uniqueVotes.getNextItem();

                    // If the voter ID is already in the list, mark the vote as a duplicate
                    if (uniqueVote.getVoterID() == vote.getVoterID()) {
                        isDuplicate = true;
                        break;
                    }
                }
                // If the vote is not a duplicate, add it to the list of unique votes
                if (!isDuplicate) {
                    uniqueVotes.add(vote);
                } else {
                    duplicateCount++;
                }
            }
            // Update the list of votes with the unique votes
            this.voteList = uniqueVotes;

            // Debug Statement
            // System.out.println("Number of duplicate votes removed: " + duplicateCount);
        }

    /**
     * Determines if the vote passed based on the votes in the list of votes.
     *
     * @return A string indicating whether the vote passed.
     */
    public String didVotePass() {

        // Counters for the number of votes for and against the initiative
        int forVotes = 0;
        int againstVotes = 0;



        // Count the number of votes for and against the initiative
        this.voteList.resetList();
        while (!this.voteList.atEnd()) {
            Vote vote = this.voteList.getNextItem();
            if (vote.getTheVote() == 1) {
                forVotes++;
            } else {
                againstVotes++;
            }
        }

        // Return a string indicating whether the vote passed
        return forVotes > againstVotes ? "Vote passed" : "Vote did not pass";
    }

    /**
     * Returns a string representation of the election results.
     *
     * @return A string representing the election results.
     */
        @Override
        public String toString() {

            // Counters for the number of votes for and against the initiative
            int forVotes = 0;
            int againstVotes = 0;

            // Count the number of votes for and against the initiative
            this.voteList.resetList();
            while (!this.voteList.atEnd()) {
                Vote vote = this.voteList.getNextItem();
                if (vote.getTheVote() == 1) {
                    forVotes++;
                } else {
                    againstVotes++;
                }
            }

            // Return a string representing the election results
            StringBuilder voteOutput = new StringBuilder();
            voteOutput.append("Votes for the initiative: ").append(forVotes).append("\n");
            voteOutput.append("Votes against the initiative: ").append(againstVotes).append("\n");
            voteOutput.append("Outcome: ").append(didVotePass());

            return voteOutput.toString();
        }
    }