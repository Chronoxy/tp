package tutorease.address.model;

import java.util.List;

import javafx.collections.ObservableList;
import tutorease.address.model.lesson.Lesson;
import tutorease.address.model.lesson.UniqueLessonList;

/**
 * Wraps all data at the lesson-schedule level
 * Duplicates are not allowed (by .isOverlapping comparison)
 */
public class LessonSchedule {
    private final UniqueLessonList lessons;

    {
        lessons = new UniqueLessonList();
    }
    public LessonSchedule() {
    }

    /**
     * Creates an LessonSchedule using the Lessons in the {@code toBeCopied}
     */
    public LessonSchedule(LessonSchedule toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Replaces the contents of the lesson list with {@code lessons}.
     * {@code lessons} must not contain duplicate lessons.
     */
    public void setLessons(List<Lesson> lessons) {
        this.lessons.setLessons(lessons);
    }

    public ObservableList<Lesson> getLessonList() {
        return lessons.asUnmodifiableObservableList();
    }

    /**
     * Returns true if a lesson with the same identity as {@code lesson} overlaps in the lesson schedule.
     */
    public boolean hasLesson(Lesson lesson) {
        return lessons.contains(lesson);
    }

    /**
     * Adds the specified lesson to the lesson list.
     *
     * @param lesson The lesson to be added. Must not be null.
     * @throws NullPointerException If the specified lesson is null.
     */
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    /**
     * Deletes the lesson at the specified index from the lesson list.
     *
     * @param index The index of the lesson to be removed. Must be a valid index.
     */
    public void deleteLesson(int index) {
        lessons.remove(index);
    }

    /**
     * Returns the lesson at the specified index.
     *
     * @param index The index of the lesson to retrieve. Must be a valid index.
     * @return The lesson at the specified index.
     */
    public Lesson getLesson(int index) {
        return lessons.get(index);
    }

    /**
     * Returns the number of lessons in the list.
     *
     * @return The size of the lesson list.
     */
    public int getSize() {
        return lessons.size();
    }

    /**
     * Replaces the contents of this lesson schedule with {@code newData}.
     */
    public void resetData(LessonSchedule newData) {
        lessons.setLessons(newData.getLessonList());
    }
}
