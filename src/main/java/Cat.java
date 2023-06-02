public class Cat
{
    private String id;
    private String name;
    private double age;
    private String color;
    private Category category;
    private Habits habits;
    private String additionalInfo;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public Category getCategory() {
        return category;
    }

    public Habits getHabits() {
        return habits;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setHabits(Habits habits) {
        this.habits = habits;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
