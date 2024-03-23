package diaries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Diaries {
 private final List<Diary> diaryList;
 private int diaryCount = 0;

    public Diaries(List<Diary> diaryList) {
        List<Diary> freshDiary = new ArrayList<>();
        this.diaryList = diaryList;
        diaryCount++;
    }

    public void add(String userName, String password){
            Diary sample = new Diary(userName, password);
            diaryList.add(sample);
    }

    public Diary findByUserName(String userName){
      for (Diary myDiary: diaryList) {
          if (Objects.equals(myDiary.getUserName(), userName))
              return myDiary;
      }
        return null;
    }
    public void delete(String userName, String password){
        Diary sample = new Diary(userName, password);
        diaryList.remove(sample);
    }


}



