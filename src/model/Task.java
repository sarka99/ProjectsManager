package model;

import java.io.Serializable;
import java.time.LocalDate;
/**this class represents logic for a task that is used in projects and implements
 * Comparable class which is used to compare objects of type "Task"*/
public class Task implements Cloneable, Comparable<Task>, Serializable{
    private final String description;
    private String takenBy;
    private final int id;
    private TaskState state;
    private LocalDate lastUpdate;
    private Prio prio;

    /**
     * Constructor to create a task object
     * @param description takes in the task description as param
     * @param prio priority for task as param
     * @param id id for a task as param
     */
    Task(String description, Prio prio, int id){

        this.description = description;
        this.prio = prio;
        this.id = id;
        this.lastUpdate = LocalDate.now();
        this.takenBy = "";
        this.state = TaskState.IN_PROGRESS;

    }

    /**
     * this is used to set an updater
     */
    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    /** this is used to initialize a user for a task as long the task has not user
     * updates the time if the user has */
    public void setTakenBy(String takenBy) {
        if (!this.takenBy.isEmpty()){
            throw new IllegalStateException();
        }else {
            this.lastUpdate = LocalDate.now();
            this.takenBy = takenBy;
        }
    }

    /** changes the state of the task if it is done or not
     * uptades the time
     * @param state is the new assigned states
     */
    public void setState(TaskState state) {
        this.lastUpdate = LocalDate.now();
        this.state = state;
    }

    /** updates the priority of the test
     * updates time
     * @param prio is an enum which has all the priorities.
     */
    public void setPrio(Prio prio) {
        this.lastUpdate = LocalDate.now();
        this.prio = prio;
    }

    /**
     * returns the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns the name of the user that has a task.
     */
    public String getTakenBy() {
        return takenBy;
    }

    /**
     * returns the id of the task
     */
    public int getId() {
        return id;
    }

    /**
     * returns the state of the task
     */
    public TaskState getState() {
        return state;
    }

    /**
     * returns the date last time the tasks got changed
     */
    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    /**
     * returns the prio of the task.
     */
    public Prio getPrio() {
        return prio;
    }

    /** compares 2 tasks
     * @param o the object to be compared.
     * @return returns 0,1 or -1 depending on which priority and description is the highest/longest
     */
    @Override
    public int compareTo(Task o) {
        if(this.prio == o.prio && (this.description.compareTo(o.description) == 0) ){
            return 0;
        }else if( (this.prio.ordinal() > o.prio.ordinal()) && (this.description.compareTo(o.description) > 0) ){
            return 1;

        }else {
            return -1;
        }
    }
    /**
     * @param obj
     * @return returns whether two objects equal to each other
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     *
     * @return returns clone of the object Task
     * @throws CloneNotSupportedException if the cloning did not work
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Task clone = null;
        try {
            clone = (Task) super.clone();
            clone.setPrio(clone.getPrio());
            clone.setState(clone.getState());
            clone.setLastUpdate(clone.getLastUpdate()) ;
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
        return clone;
    }


    /**
     * returns a string with the values of our data
     */


    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", takenBy='" + takenBy + '\'' +
                ", id=" + id +
                ", state=" + state +
                ", lastUpdate=" + lastUpdate +
                ", prio=" + prio +
                '}' ;
    }
}