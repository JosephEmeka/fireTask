package Diaries;

public class DiaryIsLockedException extends RuntimeException{
    public DiaryIsLockedException(String message) {super("Dairy is Locked! Unlock to proceed");}
}
