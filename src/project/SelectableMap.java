package project;

public class SelectableMap extends VoivodeshipMap {
    private String selectedVoivodeship;

    public void select(String voivodeship) {
        selectedVoivodeship = voivodeship;
    }

    @Override
    protected String colorFor(String voivodeship) {
        if (voivodeship.equals(selectedVoivodeship)) {
            return "#ffb703";
        }
        return "#d9d9d9";
    }
}
