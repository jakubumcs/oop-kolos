package project;

public class NoWinnerException extends RuntimeException {
    public NoWinnerException() {
        super("Brak zwyciezcy w tej turze");
    }
}
