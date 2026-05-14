package project;

import java.util.HashMap;
import java.util.Map;

public class VoteMap extends VoivodeshipMap {
    private final Map<String, Vote> resultsByVoivodeship = new HashMap<>();
    private final Map<Candidate, String> colorsByCandidate = new HashMap<>();

    public void setResult(String voivodeship, Vote vote) {
        resultsByVoivodeship.put(voivodeship, vote);
    }

    public void setCandidateColor(Candidate candidate, String color) {
        colorsByCandidate.put(candidate, color);
    }

    @Override
    protected String colorFor(String voivodeship) {
        Vote vote = resultsByVoivodeship.get(voivodeship);
        if (vote == null) {
            return "#d9d9d9";
        }

        Candidate winner = vote.winner();
        return colorsByCandidate.getOrDefault(winner, "#8ecae6");
    }
}
