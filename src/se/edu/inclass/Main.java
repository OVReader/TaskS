package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

//        System.out.println("All data:");
        System.out.println("Printing deadlines");
        printDeadlines(tasksData);

        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));

        printDataStreams(tasksData);
        printDeadlineUsingStreams(tasksData);
        int count = countDeadlineUsingStream(tasksData);

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    private static int countDeadlineUsingStream(ArrayList<Task>tasks) {
        int count = 0;
        tasks.stream()
                .filter(t -> t instanceof Deadline)
                .count();
        return (int) count;
    }


    public static void printDataStreams(ArrayList<Task> tasks) {
        System.out.println("Printing data using streams");
        tasks.stream()
                .forEach(System.out::println);
    }


    public static void printDeadlineUsingStreams(ArrayList<Task> tasks) {
        System.out.println("Printing deadline using streams");
        tasks.parallelStream()
                .filter(t-> t instanceof Deadline)
                .forEach(System.out::println);

    }
}


