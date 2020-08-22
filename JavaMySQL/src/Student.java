public class Student {
    private int id;
    private String name;
    private  int age;
    private String subject;
    private int fees;

    public Student(){}

    public Student(int id,String name, int age, String subject, int fees) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.fees = fees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                ", fees=" + fees +
                '}';
    }
}
