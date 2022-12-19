package model;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class testClass implements ITaskMatcher {
    public static void main(String[] args) {
       /* Project project1 = new Project("The first project", "This is the first test project", 145);
        Project project2 = new Project("The second project", "testing the 2nd project man", 99);
        project2.addTask("doing nothing", Prio.Low);
        project1.addTask("Do the programming task", Prio.High);
        project1.addTask("do the math", Prio.High);
        project1.addTask("do infokharateknik", Prio.Low);
        project1.addTask("te mede abri", Prio.High);

        project1.getTaskById(1).setTakenBy("kalb");
        project1.getTaskById(2).setTakenBy("hmar");
        project1.getTaskById(3).setTakenBy("åsna");
        project1.getTaskById(1).setState(TaskState.DONE);
        project1.getTaskById(2).setState(TaskState.DONE);
        project1.getTaskById(3).setState(TaskState.DONE);
        project1.getTaskById(4).setState(TaskState.DONE);

        project1.getTaskById(1).setPrio(Prio.Low);
        project1.getTaskById(1).setLastUpdate(LocalDate.of(2002,12,23));
        project1.getTaskById(2).setLastUpdate(LocalDate.of(2022,9,29));
        System.out.println(project1.getTaskById(1).getLastUpdate());
        project1.getTaskById(1).setPrio(Prio.High);
        System.out.println(project1.getTaskById(1).getLastUpdate());
        project1.getTaskById(1).setLastUpdate(LocalDate.of(2002,12,23));


        System.out.println(project1.toString());
        System.out.println(project2.toString());
        System.out.println(project1.getProjectState());

        System.out.println(project1.compareTo(project2));
       // System.out.println(project1.getTaskById(2) + "Removed");

        List<Task> tmp1 = project1.findTasks(new PrioMatcher(Prio.High));
        List<Task> tmp2 = project1.findTasks(new TakenByMatcher("kalb"));
        List<Task> tmp3 = project1.findTasks(new NotDoneMatcher());

        System.out.println("findTasks after prio" + tmp3);*/

        Project x = new Project("test 1", "test 2", 1);
        x.addTask("first task in project x", Prio.High);
        Project y = new Project("test 1", "test 2", 1);


        System.out.println(x.equals(y));







    }

    @Override
    public boolean match(Task task) {
        return false;
    }
}
