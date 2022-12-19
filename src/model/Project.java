package model;
/**
 * This class represents the logic for a project
 * nextTaskId hold the id for the new task to add, starts at 0 and increases for every new task added
 * This class is an aggregate of the class Task
 * Arraylist<Task> tasks holds all the tasks a given project contains
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Project implements Cloneable, Comparable<Project>, Serializable {
    private final String title;
    private final int id;
    private final String description;
    private final LocalDate created;
    private int nextTaskId;
    private ArrayList<Task> tasks;

    /**
     * @param title the title given when creating a project, (final)
     * @param description the description given when creating a project (final)
     * @param id the id given when creating a project (final)
     */
    Project(String title, String description, int id) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.created = LocalDate.now();
        this.tasks = new ArrayList<>();
        this.nextTaskId = 0;
    }

    /**
     * @param id pass in the id of the project to return
     * @return return the task object once it is found
     */
    public Task getTaskById(int id){
        for(int i = 0; i < tasks.size(); i++){
            if(id == i){
                return tasks.get(i);
            }
        }
        return null;
    }

    /**
     * increase nextTaskId by 1 everytime a new task is added to the project, this is then passed as a parameter when creating a task object
     * @param description description of the task to add
     * @param prio the priority for the task that is being added
     */
    public void addTask(String description, Prio prio){
        tasks.add(new Task(description,prio,nextTaskId));
        nextTaskId++;
    }

    /**
     * @param matcher is an interface which is implemented by matcher classes, parameter given is the type of matcher we want to use
     * @return returns an arraylist containing all the tasks that match what we are searching for
     */
    public List<Task> findTasks(ITaskMatcher matcher){
        ArrayList tmp = new ArrayList();
        for (Task task : tasks){
            if (matcher.match(task)){
                tmp.add(task);
            }
        }
        Collections.sort(tmp);
        return tmp;
    }

    /**
     * @return returns the current state a project is in depending on the numberOfFinished tasks in a given project
     */
    public ProjectState getProjectState(){
        int nrOfFinished = 0;
        if(tasks.isEmpty()) {
            return ProjectState.EMPTY;
        }
        for(int i = 0 ; i < tasks.size(); i++){
            if(tasks.get(i).getState() == TaskState.DONE){
                nrOfFinished++;
            }
            if(nrOfFinished == tasks.size()){
                return ProjectState.COMPLETED;
            }
        }
        return ProjectState.ONGOING;
    }

    /**
      * @return returns the last time a task was updated
     */
    public LocalDate getLastUpdated() {
        Comparator<Task> testAgeComparator = Comparator.comparing(Task::getLastUpdate);
        Task temp =  tasks.stream().max(testAgeComparator).get();
        return temp.getLastUpdate();
    }

    /**
     * @param o the object to be compared.
     * @return returns 0,1 or -1 depending on which title is longest
     */
    @Override
    public int compareTo(Project o) {
        if (this.title.compareTo(o.title) == 0){
            return 0;
        }else if(this.title.compareTo(o.title) > 0){
            return 1;
        }else {
            return -1;
        }
    }

    /**
     * @param task
     * @return return the task that was removed
     */
    public Task removeTask(Task task){
        Task tmpTask = task;
        tasks.remove(task);
        return tmpTask;
    }

    /**
     * @param obj, the object we want to compare with
     * @return returns true if both are objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        //TODO: make sure this is done properly
        return super.equals(obj);
    }

    /**
     * @return return the title of given project
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return return the id of given project
     */
    public int getId() {
        return id;
    }

    /**
     * @return return the description of given project
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return return the date the given project was created
     */
    public LocalDate getCreated() {
        return created;
    }

    /**
     * @return returns the nextTaskID
     */
    public int getNextTaskId() {
        return nextTaskId;
    }

    /**
     * @return returns the clone of the object project
     * @throws CloneNotSupportedException if the clone did not go as expected
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Project clone = null;
        try {
            clone = (Project) super.clone();
            clone.tasks = new ArrayList<>();
            for(Task t : tasks){
                clone.tasks.add((Task) t.clone());
            }

        }catch (CloneNotSupportedException cloneNotSupportedException){
            throw new RuntimeException(cloneNotSupportedException);
        }

        return clone;
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", nextTaskId=" + nextTaskId +
                ", tasks=" + tasks +
                '}';
    }
}