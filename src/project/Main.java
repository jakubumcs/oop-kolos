package project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Election election = new Election();
        election.populate();

        VoivodeshipMap baseMap = new VoivodeshipMap();
        baseMap.saveToSvg("poland.svg");

        Map<String, Vote> secondTurnResultsByVoivodeship = new HashMap<>();
        ElectionTurn secondTurn = election.getSecondTurn();
        if (secondTurn != null) {
            for (String voivodeship : VoivodeshipMap.voivodeships()) {
                Vote summary = secondTurn.summarize(List.of(voivodeship));
                secondTurnResultsByVoivodeship.put(voivodeship, summary);
            }
        }

        SelectableMap selectableMap = new SelectableMap();
        selectableMap.select("dolnośląskie");
        selectableMap.saveToSvg("selected_voivodeship.svg");

        VoteMap voteMap = new VoteMap();
        if (secondTurn != null) {
            for (Candidate candidate : election.getSecondTurn().runoffCandidates()) {
                if (candidate.name().contains("DUDA")) {
                    voteMap.setCandidateColor(candidate, "#d62828");
                } else {
                    voteMap.setCandidateColor(candidate, "#1d4ed8");
                }
            }

            for (Map.Entry<String, Vote> entry : secondTurnResultsByVoivodeship.entrySet()) {
                voteMap.setResult(entry.getKey(), entry.getValue());
            }
        }
        voteMap.saveToSvg("vote_map.svg");

        System.out.println("Wygenerowano pliki: poland.svg, selected_voivodeship.svg, vote_map.svg");
    }
}
