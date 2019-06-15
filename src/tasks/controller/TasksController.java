package tasks.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tasks.dao.TaskDao;
import tasks.modelo.Task;

@Controller
public class TasksController {

	private final TaskDao dao; // inversão de controle, pois a injeção da dependência não está dentro de cada método e sim globalmente no seu controlador

	@Autowired // amarrando explicitamente seu controlador à classe instanciada abaixo e assim vc pode tirar a instanciação de dentro do construtor
	public TasksController(TaskDao dao) {
		this.dao = dao;
//	public TasksController() {
//		dao = new TaskDao();
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
		dao.inserir(task); // injeção de dependência, pois vc está inserindo o objeto que vc inverteu seu controle
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
//		return "tasks/get-tasks";
//		return "tasks/get-tasks-ajax";
//		return "tasks/get-tasks-ajax2";
//		return "tasks/get-tasks-ajax3";
		return "tasks/get-tasks-ajax4";
	}

	@RequestMapping("excluitask")
	public String exclui(Task task) {
		dao.exclui(task); // injeção de dependência, pois vc está inserindo o objeto que vc inverteu seu controle
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
		dao.edita(task); // injeção de dependência, pois vc está inserindo o objeto que vc inverteu seu controle
		return "redirect:gettasks";
	}

//	@ResponseBody // joga corpo da resposta na view. Quando usa o Objeto model, não pode usar esta anotação, que que ambos fazem a mesma coisa, mas passando dados diferentes
	@RequestMapping("finalizatask")
	public String finaliza(Long id, Model model) {
		dao.finaliza(id); // injeção de dependência, pois vc está inserindo o objeto que vc inverteu seu controle
		model.addAttribute("task", dao.getById(id)); //objeto Model trafega dado entre controller e View. Além de passar o objeto, como a anotação @ResponseBosy estava fazendo, ele pode enviar um jsp, por exemplo, como estamos fazendo na linha abaixo
//		return "tasks/data-finalizada";
		return "tasks/data-finalizada2";
	}

}
