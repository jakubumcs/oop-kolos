package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Election {
    private List<Candidate> candidates  = new ArrayList<>();
    private ElectionTurn firstTurn;
    private ElectionTurn secondTurn = null;
    private Candidate winner;

    public Candidate getWinner() {
        return winner;
    }

    public List<Candidate> copy(){
        return new ArrayList<>(candidates);
    }

    public void populateCandidates(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linia;
            while ((linia = br.readLine()) != null){
                candidates.add(new Candidate(linia));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void populate(){
        populateCandidates("kandydaci.txt");
        firstTurn = new ElectionTurn(copy());
        firstTurn.populate("1.csv");
        try {
            winner = firstTurn.winner();
        }
        catch (NoWinnerException e){
            List<Candidate> runoff = firstTurn.runoffCandidates();
            secondTurn = new ElectionTurn(runoff);
            secondTurn.populate("2.csv");
            winner = secondTurn.winner();
        }
    }



    public ElectionTurn getFirstTurn() {
        return firstTurn;
    }

    public ElectionTurn getSecondTurn() {
        return secondTurn;
    }
}

