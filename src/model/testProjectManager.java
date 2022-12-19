package model;

import java.util.ArrayList;

public class testProjectManager {
    public static void main(String[] args) {
        ProjectsManager projectsManager = new ProjectsManager();
        projectsManager.addProject("project 1","testar project 1");
        projectsManager.addProject("project 2", "testar project 2");
        projectsManager.getProjectById(0).addTask("the first task in project 2", Prio.High);
        projectsManager.getProjectById(1).addTask("the second task in project 2", Prio.Low);
        projectsManager.getProjectById(0).getTaskById(0).setState(TaskState.DONE);
        projectsManager.getProjectById(0).getTaskById(0).setTakenBy("ammo sargon");

        //System.out.println(projectsManager.findProjects("2"));
       // System.out.println(projectsManager);
        //projectsManager.removeProject(projectsManager.getProjectById(0));
        System.out.println(projectsManager);

        ArrayList<Project> projects = new ArrayList<>();
        projects.add(new Project("adding first project", "1th project brah", 19));
        projects.add(new Project("adding 2nd project", "2th project brah", 20));
        projects.add(new Project("adding 3rd project", "3th project brah", 21));
        projects.add(new Project("adding 4th project", "4th project brah", 255));
        System.out.println("Project 0 state is: "+ projects.get(0).getProjectState());
        projects.get(0).addTask("adding the first task", Prio.High);
        projects.get(0).addTask(" the second task", Prio.Medium);

        projects.get(0).getTaskById(0).setTakenBy("Sargon");
        projects.get(0).getTaskById(0).setState(TaskState.DONE);
        projects.get(0).getTaskById(1).setTakenBy("George");
        projects.get(0).getTaskById(1).setState(TaskState.TO_DO);

        System.out.println("Project 0 state is: "+ projects.get(0).getProjectState());

        projectsManager.setProjects(projects);
        System.out.println(projectsManager);

        System.out.println(projectsManager.addProject("adding a 5th project", "chill"));
        System.out.println(projectsManager);


    }
}
