package baserunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import utils.ExcelReaderUtils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseRunner extends AbstractTestNGCucumberTests {
    String featureFolder;

    public BaseRunner(String featureFolderPath){
        this.featureFolder=featureFolderPath;
    }

    @BeforeSuite
    public void beforeSuite(ITestContext itc) {
        String cukeTags = itc.getSuite().getAllMethods().listIterator().next().getTestClass().getRealClass().getAnnotation(CucumberOptions.class).tags();
        List<String> cTags = Arrays.asList(cukeTags.split(" ")).stream().filter(tag->tag.trim().startsWith("@")).collect(Collectors.toList());
        List<File> listOfFiles= getAllFeatureFiles(featureFolder);
            listOfFiles.forEach(file -> {
            overrideFeatureFiles(file,cTags);
        });
    }

    private List<File> getAllFeatureFiles(String featureFolder) {
        Collection<File> filesList= FileUtils.listFiles(new File(featureFolder), new String[]{"feature"},true);
        return  new ArrayList<>(filesList);
    }

    private void overrideFeatureFiles(File file, List<String> cukeTags)   {

        List<String> linesOfFeature;
        try {
            linesOfFeature = Files.readAllLines(Path.of(file.getPath()));
            boolean cukeTagFound=false;
            for(String featureFileLine: linesOfFeature) {
                for (String cukeTag : cukeTags) {
                    if (featureFileLine.contains(cukeTag)) {
                        cukeTagFound = true;
                        break;
                    }
                }
            }
            if(!cukeTagFound) return;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            String scenarioName="";
            List<String> exampleFields=new ArrayList<>();
            boolean hashTagFound=false;

            for(String line : linesOfFeature){

                if(line.trim().startsWith("Scenario")){ scenarioName= line.substring(line.indexOf(":")+1).trim(); hashTagFound=false;}

                if(line.trim().startsWith("|") && line.trim().endsWith("|")) {
                    exampleFields=Arrays.asList(line.trim().split("\\|"));
                }

                if(line.trim().startsWith("#@#@")){
                    hashTagFound=true;
                    writer.write(line+"\n");
                    List<Map<String,String>> excelDataFromSheet = ExcelReaderUtils.readSheet(line.trim().substring(4));

                    for(Map<String,String> myMap : excelDataFromSheet){
                        if(myMap.get("Scenario").equals(scenarioName)){
                            String fromExcelData="|";
                            for(String field: exampleFields){
                                if(!field.trim().isBlank())
                                     fromExcelData+=myMap.get(field.trim()).trim()+"|";
                            }
                            writer.write("      "+fromExcelData+"\n");
                        }
                    }
                }
                if(!(hashTagFound && line.trim().startsWith("|") && line.trim().endsWith("|")) && !line.trim().startsWith("#@#@"))
                    writer.write(line + "\n");
            }
            writer.close();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
