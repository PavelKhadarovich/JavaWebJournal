package by.bsuir.journal.dao;


import by.bsuir.journal.model.Task;

import java.util.List;

/**
 * Created by Вероника on 25.04.2016.
 */
public interface TaskDao {
    Task findById(int id);

    Task findByPlaceId(int placeId);

    Task findByTitle(String title);

    void save(Task task);

    void deleteByTitle(String title);

    List<Task> findAllTasks();

    List<Task> findAllTasksOfUser(int userId);


}
