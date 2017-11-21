package ex.file.source.quiz.donotcall.story;

import ex.file.source.quiz.donotcall.config.FileConfig;
import ex.file.source.quiz.donotcall.domain.DoNotCall;
import ex.file.source.quiz.donotcall.logic.DoNotCallReader;
import org.apache.log4j.PropertyConfigurator;

import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;


public class DupStory {

    private DoNotCallReader donotcallReader;

    public DupStory() {
        //
        this.donotcallReader = new DoNotCallReader(new FileConfig());
    }

    public static void main(String[] args) {
        //
        PropertyConfigurator.configure("log4j.properties");
        DupStory story = new DupStory();
        List<DoNotCall> donotcalls = story.readFileContents();

        story.showContents("original", donotcalls);
        List<DoNotCall> dupRemovedDncs = story.removeDups(donotcalls);
        story.showContents("dupRemoved", dupRemovedDncs);
    }

    private List<DoNotCall> readFileContents() {
        //
        BufferedReader reader = donotcallReader.readFile();
        return donotcallReader.readContents(reader);
    }

    private void showContents(String title, List<DoNotCall> donotcalls) {
        //
        System.out.println("\n\n=========================");
        System.out.println(title);

        for (DoNotCall donotcall : donotcalls) {
            System.out.println(donotcall.toString());
        }
    }

    private List<DoNotCall> removeDups(List<DoNotCall> donotcalls) {
        //
        // 여기에 중복 제거 로직을 구현합니다.
        // 필요하다면 관련 클래스 어디에든 메소드를 추가할 수 있습니다.
        //
        Map<String, DoNotCall> result = new HashMap<>();
        for (DoNotCall doNotCall : donotcalls) {
            String name = doNotCall.getName();
            if(isNameNotAvaliable(name)){
                String phone = doNotCall.getContactNo();
                String birth = doNotCall.getBirthday();
                result.put(phone+birth, doNotCall);
            }
        }

        return new ArrayList<>(result.values());
    }

    private boolean isNameNotAvaliable(String name){
        return name != null && !name.isEmpty() && (!name.equals(" "));
    }
}
