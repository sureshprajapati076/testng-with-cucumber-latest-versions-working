package utils;

import java.util.ArrayList;
import java.util.List;

public class ScenarioDTO {
    List<String> currentScenario;
    boolean cukeTagFound=false;
    boolean hashTagFound=false;

    public ScenarioDTO() {
        currentScenario = new ArrayList<>();
    }

    public List<String> getCurrentScenario() {
        return currentScenario;
    }

    public void setCurrentScenario(List<String> currentScenario) {
        this.currentScenario = currentScenario;
    }

    public boolean isCukeTagFound() {
        return cukeTagFound;
    }

    public void setCukeTagFound(boolean cukeTagFound) {
        this.cukeTagFound = cukeTagFound;
    }

    public boolean isHashTagFound() {
        return hashTagFound;
    }

    public void setHashTagFound(boolean hashTagFound) {
        this.hashTagFound = hashTagFound;
    }

    public void addLine(String currentLine) {
        this.currentScenario.add(currentLine);
    }
}
