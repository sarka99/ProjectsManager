package model;

public class NotDoneMatcher implements ITaskMatcher{
    @Override
    public boolean match(Task task) {
        if (task.getState() != TaskState.DONE){
            return true;
        }else {
            return false;
        }
    }
}
