package by.bsuir.journal.controller;

import by.bsuir.journal.model.Task;
import by.bsuir.journal.model.User;
import by.bsuir.journal.service.PlaceService;
import by.bsuir.journal.service.TaskService;
import by.bsuir.journal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

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
    UserService userService;

    @Autowired
    MessageSource messageSource;

    //--------------------------------------------------------------------------------------------------//
    //--------------------------------------------JSON--------------------------------------------------//
    //--------------------------------------------------------------------------------------------------//


    @RequestMapping(value = {"/user/{id}/task/"}, method = RequestMethod.GET)
    public ResponseEntity<List<Task>> taskListOfUser(@PathVariable("id") int id) {
        System.out.println("Try to print list of users");
        List<Task> users = taskService.findAllTasksOfUser(id);
        if (users.isEmpty()) {
            return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Task>>(users, HttpStatus.OK);

    }

    @RequestMapping(value = {"/task/"}, method = RequestMethod.GET)
    public ResponseEntity<List<Task>> taskList() {
        System.out.println("Try to print list of users");
        List<Task> users = taskService.findAllTasks();
        if (users.isEmpty()) {
            return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Task>>(users, HttpStatus.OK);

    }

    @RequestMapping(value = {"/task/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Task> getTaskWithId(@PathVariable("id") int id) {
        Task task = taskService.findById(id);
        if (task == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    //метод assign для Димитара
    @RequestMapping(value = "user/{userId}/place/{placeId}/task/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTaskForPlaceAndCreator(@RequestBody Task task, UriComponentsBuilder ucBuilder,
                                                             @PathVariable("userId") int userId,
                                                             @PathVariable("placeId") int placeId) {

        if (!taskService.isTaskTitleUnique(task.getId(), task.getTitle())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());

        task.setCreator(userService.findById(userId));
        task.setPlace(placeService.findById(placeId));
        task.setStatus(Task.TaskStatus.NEW);
        task.setDateCreated(time);
        task.setDateChanged(time);
        taskService.saveTask(task);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/task/{id}").buildAndExpand(task.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody Task task) {
        System.out.println("Updating Task " + id);

        Task currentTask = taskService.findById(id);

        if (currentTask == null) {
            System.out.println("Task with id " + id + " not found");
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }

        taskService.updateTask(currentTask);
        return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Task> deleteTask(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Task with id " + id);

        Task task = taskService.findById(id);
        if (task == null) {
            System.out.println("Unable to delete. Task with id " + id + " not found");
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }

        taskService.deleteTaskByTitle(task.getTitle());
        return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
    }

    //--------------------------------------------------------------------------------------------------//
    //------------------------------------------JSP-----------------------------------------------------//
    //--------------------------------------------------------------------------------------------------//

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
    public String updateTasks(@Valid Task task, ModelMap model, BindingResult result, @PathVariable String title) {

        taskService.updateTask(task);
        return "redirect:/taskslist";
    }

    @RequestMapping(value = {"/tasks-delete-{title}"}, method = RequestMethod.GET)
    public String deleteTasks(@PathVariable String title) {
        taskService.deleteTaskByTitle(title);
        return "redirect:/taskslist";
    }
}
