package by.bsuir.journal.service;

import by.bsuir.journal.model.Task;

import java.util.List;

/**
 * Created by Вероника on 26.04.2016.
 */
public interface TaskService {
    Task findById(int id);

    Task findByTitle(String title);

    public Task findByPlaceId(int placeId);

    void saveTask(Task task);

    void updateTask(Task task);

    void deleteTaskByTitle(String title);

    List<Task> findAllTasks();

    List<Task> findAllTasksOfUser(int userId);

    boolean isTaskTitleUnique(Integer id, String title);
}
