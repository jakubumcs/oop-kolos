package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElectionTurn {
    private List<Candidate> candidates = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public ElectionTurn(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public void populate(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linia;
            br.readLine();
            while ((linia = br.readLine()) != null) {
                votes.add(Vote.fromCsvLine(linia, candidates));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Vote summarize() {
        return Vote.summarize(votes, new ArrayList<>());
    }

    public Vote summarize(List<String> location) {
        List<Vote> filtered = Vote.filterByLocation(votes, location);
        return Vote.summarize(filtered, location);
    }

    public Candidate winner() {
        Vote summary = summarize();
        for (Candidate candidate : candidates) {
            double percent = summary.percentage(candidate);
            if (percent > 50) {
                return candidate;
            }
        }
        throw new NoWinnerException();
    }

    public List<Candidate> runoffCandidates() {
        Vote summary = summarize();

        Candidate first = null;
        Candidate second = null;

        int biggest = -1;
        for (Candidate candidate : candidates) {
            int currentVotes = summary.votes(candidate);
            if (currentVotes > biggest) {
                biggest = currentVotes;
                first = candidate;
            }
        }

        int secondBiggest = -1;
        for (Candidate candidate : candidates) {
            int currentVotes = summary.votes(candidate);
            if (candidate != first && currentVotes > secondBiggest) {
                secondBiggest = currentVotes;
                second = candidate;
            }
        }

        List<Candidate> result = new ArrayList<>();
        result.add(first);
        result.add(second);
        return result;
    }
}
