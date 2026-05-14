package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VoivodeshipMap {
    protected static final Map<String, String> VOIVODESHIP_PATHS = new LinkedHashMap<>();

    static {
        VOIVODESHIP_PATHS.put("zachodniopomorskie", "M20 20 H110 V90 H20 Z");
        VOIVODESHIP_PATHS.put("pomorskie", "M120 20 H210 V90 H120 Z");
        VOIVODESHIP_PATHS.put("warmińsko-mazurskie", "M220 20 H330 V90 H220 Z");
        VOIVODESHIP_PATHS.put("podlaskie", "M340 20 H430 V90 H340 Z");

        VOIVODESHIP_PATHS.put("lubuskie", "M20 100 H110 V170 H20 Z");
        VOIVODESHIP_PATHS.put("wielkopolskie", "M120 100 H210 V170 H120 Z");
        VOIVODESHIP_PATHS.put("kujawsko-pomorskie", "M220 100 H330 V170 H220 Z");
        VOIVODESHIP_PATHS.put("mazowieckie", "M340 100 H430 V170 H340 Z");

        VOIVODESHIP_PATHS.put("dolnośląskie", "M20 180 H110 V250 H20 Z");
        VOIVODESHIP_PATHS.put("opolskie", "M120 180 H210 V250 H120 Z");
        VOIVODESHIP_PATHS.put("łódzkie", "M220 180 H330 V250 H220 Z");
        VOIVODESHIP_PATHS.put("lubelskie", "M340 180 H430 V250 H340 Z");

        VOIVODESHIP_PATHS.put("śląskie", "M20 260 H110 V330 H20 Z");
        VOIVODESHIP_PATHS.put("małopolskie", "M120 260 H210 V330 H120 Z");
        VOIVODESHIP_PATHS.put("świętokrzyskie", "M220 260 H330 V330 H220 Z");
        VOIVODESHIP_PATHS.put("podkarpackie", "M340 260 H430 V330 H340 Z");
    }

    public static List<String> voivodeships() {
        return new ArrayList<>(VOIVODESHIP_PATHS.keySet());
    }

    protected String colorFor(String voivodeship) {
        return "#d9d9d9";
    }

    public void saveToSvg(String filePath) {
        StringBuilder svg = new StringBuilder();
        svg.append("<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 450 350\">");
        svg.append("<rect width=\"450\" height=\"350\" fill=\"#ffffff\"/>");

        for (Map.Entry<String, String> entry : VOIVODESHIP_PATHS.entrySet()) {
            String voivodeship = entry.getKey();
            svg.append("<path d=\"")
                    .append(entry.getValue())
                    .append("\" fill=\"")
                    .append(colorFor(voivodeship))
                    .append("\" stroke=\"#222222\" stroke-width=\"2\"/>");
            svg.append("<title>").append(voivodeship).append("</title>");
        }

        svg.append("</svg>");

        try {
            Files.writeString(Path.of(filePath), svg.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
