
public class Course {
    private int ID;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String daysOfWeek; // TODO enum?
    // TODO list of tasks
    // TODO list of students <=12
    // TODO trainer = 1

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ID " + ID + ": " + name + ".\n" + description +
                ".\nBegin: " + startDate + ",\nEnd:   " + endDate + ",\nDays:  " + daysOfWeek + ".\n";
    }
}
