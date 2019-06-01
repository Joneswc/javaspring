package tasks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("gettasks")
//	public ModelAndView getTasks() {
////		primeira opção usando model and view
//		List<Task> tasks = dao.getTasks();
//		ModelAndView mv = new ModelAndView("tasks/get-tasks");
//		mv.addObject("tasks", tasks);
//		return mv;
//	}
	public String getTasks(Model model) {
		model.addAttribute("tasks", dao.getTasks());
		return "tasks/get-tasks";
	}

	@RequestMapping("excluitask")
	public String exclui(Task task) {
		dao.exclui(task);
		return "redirect:gettasks"; // client side
//		return "forward:gettasks"; // server side
	}

	@RequestMapping("buscatask")
	public String busca(Long id, Model model) { // Model é o objeto que retorna para a tela
//		Task task = dao.getById(id);
		model.addAttribute("task", dao.getById(id));
		return "tasks/busca-task";
	}

	@RequestMapping("editatask")
	public String edita(Task task) {
		dao.edita(task);
		return "redirect:gettasks";
	}

}
