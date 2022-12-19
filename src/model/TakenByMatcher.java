package model;

public class TakenByMatcher  implements ITaskMatcher{
    private String takenBy;

    public TakenByMatcher(String takenBy) {
        this.takenBy = takenBy;
    }
    @Override
    public boolean match(Task task) {
        if (task.getTakenBy().equals(takenBy)){
            return true;
        }else {
            return false;
        }
    }
}
