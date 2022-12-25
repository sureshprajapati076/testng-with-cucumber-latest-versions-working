package baserunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import utils.ExcelReaderUtils;
import utils.ScenarioDTO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BaseRunnerBrowser extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void beforeSuite(ITestContext itc) {
        CucumberOptions options = itc.getSuite().getAllMethods().listIterator().next().getTestClass().getRealClass().getAnnotation(CucumberOptions.class);
        String cukeTags = options.tags();
        String []featureFileFolder = options.features();

        List<String> cTags = Arrays.asList(cukeTags.split(" ")).stream().filter(tag -> tag.trim().startsWith("@")).collect(Collectors.toList());
        List<File> listOfFiles = getAllFeatureFiles(featureFileFolder);
        listOfFiles.forEach(file -> {
            overrideFeatureFiles(file, cTags);
        });
    }

    private List<File> getAllFeatureFiles(String []featureFileFolder) {
        Collection<File> filesList;
        List<File> fileList=new ArrayList<>();
        for(String featureFolder: featureFileFolder) {
             filesList = FileUtils.listFiles(new File(featureFolder), new String[]{"feature"}, true);
             fileList.addAll(filesList);
        }
        return fileList;
    }

    private void overrideFeatureFiles(File file, List<String> cukeTags) {

        List<String> linesOfFeature;
        List<ScenarioDTO> scenarioDTOList = new ArrayList<>();
        Predicate<ScenarioDTO> cukeTagFilterPredicate = ScenarioDTO::isCukeTagFound;
        Predicate<ScenarioDTO> hashTagFilterPredicate = ScenarioDTO::isHashTagFound;
        String endLine = System.lineSeparator();
        try {
            linesOfFeature = Files.readAllLines(Path.of(file.getPath()));
            ScenarioDTO currentScenarioDto = new ScenarioDTO();
            for (String currentLine : linesOfFeature) {
                if (currentLine.trim().startsWith("@")) {
                    scenarioDTOList.add(currentScenarioDto);
                    currentScenarioDto = new ScenarioDTO();
                    currentScenarioDto.addLine(currentLine);
                } else {
                    currentScenarioDto.addLine(currentLine);
                }
            }
            scenarioDTOList.add(currentScenarioDto);

            for (ScenarioDTO currentScenarioDTO : scenarioDTOList) {
                for (String currentScenarioLine : currentScenarioDTO.getCurrentScenario()) {
                    for (String cukeTag : cukeTags) {
                        if (Arrays.asList(currentScenarioLine.split(" ")).contains(cukeTag))
                            currentScenarioDTO.setCukeTagFound(true);
                        if (currentScenarioLine.trim().startsWith("#@#@")) currentScenarioDTO.setHashTagFound(true);
                    }
                }
            }

            long hashTagCukeTagFound = scenarioDTOList.stream().skip(1).filter(cukeTagFilterPredicate.and(hashTagFilterPredicate)).count();

            if (hashTagCukeTagFound == 0) return;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String scenarioName = "";
            List<String> exampleFields = new ArrayList<>();
            boolean hashTagFound = false;

            for (ScenarioDTO scenarioDTO : scenarioDTOList) {

                if (!scenarioDTO.isHashTagFound() || !scenarioDTO.isCukeTagFound()) {
                    for (String line : scenarioDTO.getCurrentScenario()) sb.append(line).append(endLine);
                    continue;

                }

                for (String line : scenarioDTO.getCurrentScenario()) {
                    if (line.trim().startsWith("Scenario")) {
                        scenarioName = line.substring(line.indexOf(":") + 1).trim();
                        hashTagFound = false;
                    }

                    if (line.trim().startsWith("|") && line.trim().endsWith("|")) {
                        exampleFields = Arrays.asList(line.trim().split("\\|"));
                    }

                    if (line.trim().startsWith("#@#@")) {
                        hashTagFound = true;
                        sb.append(line).append(endLine);
                        List<Map<String, String>> excelDataFromSheet = ExcelReaderUtils.readSheet(line.trim().substring(4));

                        for (Map<String, String> myMap : excelDataFromSheet) {
                            if (myMap.get("Scenario").equals(scenarioName)) {
                                StringBuilder fromExcelData = new StringBuilder("|");
                                for (String field : exampleFields) {
                                    if (!field.trim().isBlank())
                                        fromExcelData.append(myMap.get(field.trim()).trim()).append("|");
                                }
                                sb.append("      ").append(fromExcelData).append(endLine);
                            }
                        }
                    }
                    if (!(hashTagFound && line.trim().startsWith("|") && line.trim().endsWith("|")) && !line.trim().startsWith("#@#@"))
                        sb.append(line).append(endLine);
                }

            }
            int last = sb.lastIndexOf(endLine);
            if (last >= 0) sb.delete(last, sb.length());
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
