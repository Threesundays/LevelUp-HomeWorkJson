import java.util.Objects;

public class User {
    private String login;
    private String name;
    private int age;
    private int bonus;

    public User(String login, String name, int age, int bonus) {
        this.login = login;
        this.name = name;
        this.age = age;
        this.bonus = bonus;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && bonus == user.bonus && Objects.equals(login, user.login) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, age, bonus);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bonus=" + bonus +
                '}';
    }
}
