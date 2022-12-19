package model;
/**
 * This class manages all the projects in the program, contains all the logic for managing the projects
 * this class is an aggregate of the class Project, the projects data member is a list of all projects
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProjectsManager {
    private int nextProjectId;
    private ArrayList<Project> projects;

    /**
     * Constructor initializises a projectManager object
     * nextProjectID gets the value returned by getHighestId this is important for keeping this value after reopening the program
     * initializes arraylist of Projects
     */
    public ProjectsManager() {
        this.projects = new ArrayList<>();
        this.nextProjectId = getHighestId();

    }

    /**
     * first clear the projects array
     * set the nextProjectID to 0 so that the list is reset
     * add all the projects
     * @param incomingProjects a list containing projects to add
     */
    public void setProjects(List<Project> incomingProjects){
        projects.clear();
        projects.addAll(incomingProjects);
        nextProjectId = getHighestId() + 1;

    }

    /**
     *
     * @param title the title to check
     * @return returns true or false depending on if the title of a given project exists or not
     */
    public boolean isTitleUnique(String title){
        for(int i = 0; i <projects.size(); i++){
            if(title.equals(projects.get(i).getTitle())){
                return false;
            }
        }
        return true;
    }

    /**
     * Use the method isTitleUnique to check whether it's allowed to add the project or not
     * If title is unique add the new project to the list "projects"
     * @param title title of the project to add
     * @param description description of the project to add
     * @return returns the project object that was created, if created successfully
     * @throws TitleNotUniqueException if the title is not unique, meaning already exists
     */
    public Project addProject(String title, String description) throws TitleNotUniqueException{
        //use getHighestId to not restard the list, save the projects good for file management
        if(isTitleUnique(title)){
            Project newProject = new Project(title,description,getHighestId());
            projects.add(newProject);
            nextProjectId++;
            return newProject;
        }else {
            throw new TitleNotUniqueException("Title is not unique");
        }
    }

    /**
     * removes a project from the list of projects
     * @param project the project to remove
     */
    public void removeProject(Project project){
        projects.remove(project);
    }




    /**
     * @param id of that project to return
     * Check if the list is empty or not first
     * @return returns the project object depending on which id it has
     */
    public Project getProjectById(int id) {
        if (!projects.isEmpty()){
            return projects.get(id);

        }else {
             throw new IllegalArgumentException();
        }

    }

    /**
     * @param titleStr the entered title, doesn't have to be full title
     * @return returns an arraylist of the projects that match the title searched after
     */
    public List<Project> findProjects(String titleStr){
        ArrayList<Project> matchedProjects = new ArrayList<>();
        for (int i = 0; i < projects.size(); i++){
            if(projects.get(i).getTitle().contains(titleStr)){
                matchedProjects.add(projects.get(i));
            }
        }
        return matchedProjects;
    }

    /**
     * perform a deepcopy, using the overriden clone method in project class
     * @return returns a fully deep copied list of all the projects
     */
    public List<Project> getProjects() throws CloneNotSupportedException {
        ArrayList<Project> clonedProjects = new ArrayList<>();
        for (Project p : projects){
            clonedProjects.add((Project) p.clone());
        }
        return clonedProjects;
    }

    /**
     * @return returns the highest id which is the last one in the projects list
     */
    private int getHighestId(){
        //fix method
        int biggest = 0;
        for(int i = 0; i< projects.size();i++){

        }
        return projects.size();
    }
    /**
     *
     * @return returns the string
     */
    @Override
    public String toString() {
        return "ProjectsManager{" +
                "nextProjectId=" + nextProjectId +
                ", projects=" + projects +
                '}';
    }
}
