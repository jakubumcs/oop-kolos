package project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vote {
    private Map<Candidate, Integer> votesForCandidate = new HashMap<>();
    private List<String> location = new ArrayList<>();

    public static Vote fromCsvLine(String line,List<Candidate> candidates){
        String[] values = line.split(",");
        Vote vote = new Vote();
        vote.location.add(values[2]);
        vote.location.add(values[1]);
        vote.location.add(values[0]);
        for (int i = 0; i < candidates.size();i++){
            int votes = Integer.parseInt(values[i+3]);
            vote.votesForCandidate.put(candidates.get(i),votes);
        }
        return vote;
    }
    public static Vote summarize(List<Vote> results, List<String> location){
        Vote summary = new Vote();
        summary.location = new ArrayList<>(location);
        if (results.isEmpty()){
            return summary;
        }
        for (Candidate candidate : results.get(0).votesForCandidate.keySet()) {
            int sum = 0;
            for (Vote vote : results){
                sum += vote.votesForCandidate.get(candidate);
            }
            summary.votesForCandidate.put(candidate,sum);
        }
        return summary;
    }
    public int votes(Candidate candidate){
        return votesForCandidate.getOrDefault(candidate, 0);
    }
    public double percentage(Candidate candidate){
        double sum = 0;
        for (int value : votesForCandidate.values()){
            sum += value;
        }

        if (sum == 0) {
            return 0;
        }

        double percentage = (votes(candidate) / sum) * 100;
        return percentage;
    }

    public List<String> getLocation() {
        return new ArrayList<>(location);
    }

    public Candidate winner() {
        return votesForCandidate.keySet()
                .stream()
                .max(Comparator.comparingInt(this::votes))
                .orElseThrow();
    }

    @Override
    public String toString() {
        String result = "";
        double sum = 0;
        for (int value : votesForCandidate.values()){
            sum += value;
        }
        for (Candidate candidate : votesForCandidate.keySet()){
            double percentage = (votesForCandidate.get(candidate)/sum) * 100;
            result += "Imie i nazwisko: " + candidate.name() + " procent: " + percentage+ "\n" ;

        }
        return result;
    }
    public static List<Vote> filterByLocation(List<Vote> votes, List<String> location){
        List<Vote> result = new ArrayList<>();
        for(Vote vote : votes){
            boolean match = true;
            for (int i = 0; i < location.size(); i ++ ){
                if (!vote.location.get(i).equals(location.get(i))){
                    match = false;
                    break;
                }
            }
            if (match){
                result.add(vote);
            }
        }
        return result;
    }
}
