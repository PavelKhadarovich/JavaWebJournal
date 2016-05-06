package by.bsuir.journal.dao.impl;

import by.bsuir.journal.dao.AbstractDao;
import by.bsuir.journal.dao.TaskDao;
import by.bsuir.journal.model.Task;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Task> implements TaskDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Task findById(int id) {
        Task task = getByKey(id);
        return task;
    }

    public Task findByPlaceId(int placeId) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("place_id", placeId));
        Task task = (Task)crit.uniqueResult();
        return task;
    }

    public Task findByTitle(String title) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("title", title));
        Task task = (Task)crit.uniqueResult();
        return task;
    }

    public void save(Task task) {
        persist(task);
    }

    public void deleteByTitle(String title) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("title", title));
        Task task = (Task)crit.uniqueResult();
        delete(task);
    }

    @SuppressWarnings("unchecked")
    public List<Task> findAllTasks() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Task> tasks = (List<Task>)criteria.list();
        return tasks;
    }
}
