public class Main {

    // =======================
    // Student Class
    // =======================
    static class Student {
        int age;
        int semester;
        int socioEconomicStratum;
        int coursesCompleted;
        int coursesPending;
        String program;
        int programId;

        // Constructor
        public Student(int age, int semester, int socioEconomicStratum,
                       int coursesCompleted, int coursesPending,
                       String program, int programId) {
            this.age = age;
            this.semester = semester;
            this.socioEconomicStratum = socioEconomicStratum;
            this.coursesCompleted = coursesCompleted;
            this.coursesPending = coursesPending;
            this.program = program;
            this.programId = programId;
        }

        // Print student information
        public void printInfo() {
            System.out.println("Program: " + program + " | ProgramId: " + programId +
                               " | Age: " + age + " | Semester: " + semester +
                               " | Stratum: " + socioEconomicStratum +
                               " | Completed: " + coursesCompleted +
                               " | Pending: " + coursesPending);
        }
    }

    // =======================
    // Sorting Algorithms
    // =======================

    // Bubble Sort by age (ascending)
    public static void bubbleSortByAge(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].age > students[j + 1].age) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort by semester (descending)
    public static void insertionSortBySemester(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].semester < key.semester) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
    }

    // =======================
    // Search Algorithms
    // =======================

    // Linear Search by programId
    public static Student linearSearchByProgramId(Student[] students, int programId) {
        for (Student s : students) {
            if (s.programId == programId) {
                return s;
            }
        }
        return null;
    }

    // Binary Search by age (array must be sorted by age first)
    public static Student binarySearchByAge(Student[] students, int age) {
        int left = 0, right = students.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (students[mid].age == age) {
                return students[mid];
            } else if (students[mid].age < age) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // =======================
    // Utility: Print Students
    // =======================
    public static void printStudents(Student[] students) {
        for (Student s : students) {
            s.printInfo();
        }
        System.out.println("------------------------------------------------");
    }

    // =======================
    // Main Method
    // =======================
    public static void main(String[] args) {
        // Create dataset of 10 students
        Student[] students = {
            new Student(20, 3, 2, 12, 2, "Engineering", 101),
            new Student(22, 5, 3, 20, 3, "Medicine", 102),
            new Student(19, 1, 1, 5, 4, "Law", 103),
            new Student(25, 8, 4, 30, 1, "Architecture", 104),
            new Student(21, 4, 2, 15, 2, "Economics", 105),
            new Student(23, 6, 3, 25, 1, "Engineering", 106),
            new Student(18, 1, 1, 3, 5, "Design", 107),
            new Student(24, 7, 5, 28, 2, "Medicine", 108),
            new Student(20, 2, 2, 8, 4, "Law", 109),
            new Student(26, 9, 6, 35, 0, "Philosophy", 110)
        };

        // Print original list
        System.out.println("Original list of students:");
        printStudents(students);

        // Bubble Sort by age
        bubbleSortByAge(students);
        System.out.println("After Bubble Sort by Age (ascending):");
        printStudents(students);

        // Insertion Sort by semester
        insertionSortBySemester(students);
        System.out.println("After Insertion Sort by Semester (descending):");
        printStudents(students);

        // Linear Search
        System.out.println("Linear Search by ProgramId (105):");
        Student found1 = linearSearchByProgramId(students, 105);
        if (found1 != null) found1.printInfo(); else System.out.println("Student not found.");

        // Binary Search (must sort by age first)
        bubbleSortByAge(students);
        System.out.println("\nBinary Search by Age (22):");
        Student found2 = binarySearchByAge(students, 22);
        if (found2 != null) found2.printInfo(); else System.out.println("Student not found.");
    }
}
