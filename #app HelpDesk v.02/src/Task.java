import java.util.Objects;

public class Task implements Comparable<Task>{
    private String name;
    private String description;
    private Priority priority;

    public Task(String task, String description, Priority priority) {
        this.name = task;
        this.description = description;
        this.priority = priority;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task1 = (Task) o;
        return Objects.equals(name, task1.name) &&
                Objects.equals(description, task1.description) &&
                priority == task1.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, priority);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Task o) {
        return priority.compareTo(o.priority);
    }

    @Override
    public String toString() {
        return " Zadanie: "+ name + ". Opis: " + description + ". Priorytet: " + priority +". ";
    }
}


enum Priority{
    HIGH,MODERATE,LOW
}