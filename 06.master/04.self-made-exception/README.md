## ミニ課題: 自作例外の作成（時間: 20 分）

次の StudentList クラスの addStudent メソッドについて、
姓名が設定されていなかった場合に自作例外 AppException を投げるように変更しなさい

また、投げられた AppException は最上流で受け取るようにしなさい

```java title=src/StudentRegistration.java
import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {
    public static void main(String[] args) {

        StudentList studentList = new StudentList();
        Student yamamoto = new Student("山本", "一郎");
        Student jiro = new Student("", "次郎");
        Student tamada = new Student("山田", "太郎");
        Student yamashita = new Student("山下");

        studentList.addStudent(yamamoto);
        studentList.addStudent(jiro);
        studentList.addStudent(tamada);
        studentList.addStudent(yamashita);
        studentList.showAllStudents();
    }
}

class Student {
    public static int maxId;
    public int id;
    public String firstName;
    public String lastName;

    static {
        maxId = 0;
    }

    public Student(String firstName, String lastName) {
        this.id = ++maxId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName) {
        this.id = ++maxId;
        this.firstName = firstName;
        this.lastName = null;
    }

    public boolean isValidFirstName() {
        return this.firstName != null
            && !this.firstName.isEmpty();
    }

    public boolean isValidLastName() {
        return this.lastName != null
            && !this.lastName.isEmpty();
    }
}

class StudentList {
    public List<Student> students;

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!student.isValidFirstName()) {
            System.out.printf(
                    "ID %d: %s%s は登録できません. %n",
                    student.id, student.firstName, student.lastName
            );
            System.out.println(" => 姓が空です. \n");
            return;
        }

        if (!student.isValidLastName()) {
            System.out.printf(
                "ID %d: %s%s は登録できません. %n",
                student.id, student.firstName, student.lastName
            );
            System.out.println(" => 名が空です. \n");
            return;
        }

        if (student.isValidLastName()) {
            System.out.printf(
                "ID %d: %s%s を登録しました. %n%n",
                student.id, student.firstName, student.lastName
            );

            this.students.add(student);
        }
    }

    public void showAllStudents() {
        System.out.println("登録者一覧を表示します");
        System.out.println("-----");
        for (Student student : this.students) {
            System.out.printf(
                "ID %d: %s%s %n",
                student.id, student.firstName, student.lastName
            );
        }
    }
}
```

```txt title=自作例外追加後の実行結果
ID 1: 山本一郎 を登録しました.

ID 2: 次郎 は登録できません.
 => 姓が空です.

ID 3: 山田太郎 を登録しました.

ID 4: 山下null は登録できません.
 => 名が空です.

登録者一覧を表示します
-----
ID 1: 山本一郎
ID 3: 山田太郎
```

## 解答例

https://github.com/fs5013-furi-sutao/java-bootcamp-answers/blob/main/06.master/04.self-made-exception/src/StudentRegistration.java
