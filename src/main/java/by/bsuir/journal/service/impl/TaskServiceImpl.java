package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.TaskDao;
import by.bsuir.journal.dao.impl.TaskDaoImpl;
import by.bsuir.journal.model.Task;
import by.bsuir.journal.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    public TaskServiceImpl(){}
    public TaskServiceImpl(TaskDaoImpl dao){
        this.taskDao = dao;
    }

    public Task findById(int id) {
        return taskDao.findById(id);
    }

    public Task findByTitle(String title) {
        Task task = taskDao.findByTitle(title);
        return task;
    }

    public Task findByPlaceId(int placeId){
        Task task = taskDao.findByPlaceId(placeId);
        return task;
    }

    public void saveTask(Task task) {
        taskDao.save(task);
    }

    public void updateTask(Task task) {
        Task entity = taskDao.findById(task.getId());
        if(entity!=null){
            entity.setTitle(task.getTitle());
            entity.setDescription(task.getDescription());
        }
    }

    public void deleteTaskByTitle(String title) {
        taskDao.deleteByTitle(title);
    }

    public List<Task> findAllTasks() {
        return taskDao.findAllTasks();
    }

    public boolean isTaskTitleUnique(Integer id, String title) {
        Task task = findByTitle(title);
        return (task==null||
                ((id!=null)&&(task.getId()==id)));
    }
}
