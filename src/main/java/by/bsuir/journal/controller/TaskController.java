package by.bsuir.journal.controller;

import by.bsuir.journal.model.Task;
import by.bsuir.journal.model.User;
import by.bsuir.journal.service.TaskService;
import by.bsuir.journal.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class TaskController {
    @Autowired
    PlaceService placeService;

    @Autowired
    TaskService taskService;

    @Autowired
    MessageSource messageSource;

    //==============JSON===========================



    //==============JSP===========================

    @RequestMapping(value = {"/taskslist"}, method = RequestMethod.GET)
    public String tasksList(ModelMap model) {
        List<Task> tasks = taskService.findAllTasks();
        model.addAttribute("tasks", tasks);
        return "taskslist";
    }

    @RequestMapping(value = {"/tasks-create-{placeName}"}, method = RequestMethod.GET)
    public String newTask(ModelMap model, @PathVariable String placeName) {
        Task task = new Task();
        model.addAttribute("placeName", placeName);
        model.addAttribute("task", task);
        model.addAttribute("edit", false);
        return "createTask";
    }

    @RequestMapping(value = {"/tasks-create-{placeName}"}, method = RequestMethod.POST)
    public String saveTask(@Valid Task task, ModelMap model, BindingResult result,
                            HttpSession session, @PathVariable String placeName) {
        if (result.hasErrors()) {
            return "createTask";
        }
        //todo check unique title
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());

        task.setCreator((User) session.getAttribute("user"));
        task.setPlace(placeService.findByName(placeName));
        task.setStatus(Task.TaskStatus.NEW);
        task.setDateCreated(time);
        task.setDateChanged(time);
        taskService.saveTask(task);

        return "redirect:/taskslist";
    }

    @RequestMapping(value = {"/tasks-edit-{title}"}, method = RequestMethod.GET)
    public String editTask(@PathVariable String title, ModelMap model) {
        Task task = taskService.findByTitle(title);
        model.addAttribute("task", task);
        model.addAttribute("edit", true);
        return "createTask";
    }

    @RequestMapping(value = {"/tasks-edit-{title}"}, method = RequestMethod.POST)
    public String updateTask(@Valid Task task, ModelMap model, BindingResult result, @PathVariable String title) {

        taskService.updateTask(task);
        return "redirect:/taskslist";
    }

    @RequestMapping(value = {"/tasks-delete-{title}"}, method = RequestMethod.GET)
    public String deleteTask(@PathVariable String title) {
        taskService.deleteTaskByTitle(title);
        return "redirect:/taskslist";
    }
}
