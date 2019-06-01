package tasks.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import tasks.dao.TaskDao;
import tasks.modelo.Task;

@Controller
public class TasksController {

	private final TaskDao dao;

	public TasksController() {
		dao = new TaskDao();
	}

	@RequestMapping("novatask")
	public String form() {
		return "tasks/form-tasks";
	}

	@RequestMapping("cadastratask")
	public String cadastra(@Valid Task task, BindingResult result) {
//		TaskDao dao = new TaskDao();
//		if (!result.hasErrors()) {
		if (result.hasFieldErrors("descricao")) {
			return "tasks/form-tasks";
		}
		dao.inserir(task);
		return "tasks/task-cadastrada";
	}
}
