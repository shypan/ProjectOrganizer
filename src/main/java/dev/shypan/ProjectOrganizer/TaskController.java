package dev.shypan.ProjectOrganizer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
	
	private TaskService taskService;
	
	
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}


	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks() {
		return new ResponseEntity<List<Task>>(taskService.allTasks(), HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public long getTaskCount() {
		return taskService.countTasks();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Task>> getSingleTask(@PathVariable ObjectId id) {
		return new ResponseEntity<Optional<Task>>(taskService.singleTask(id), HttpStatus.OK);

	}

//	@GetMapping("/{id}")
//	public ResponseEntity<Optional<Task>> getSingleTask(@PathVariable Integer id) {
//		return new ResponseEntity<Optional<Task>>(taskService.singleTaskByTaskId(id), HttpStatus.OK);
//	}
	
	@PostMapping("/newTask")
	public ResponseEntity<Void> createTask(@RequestBody Map<String, String> payload) {
		taskService.createTask(payload.get("taskName"), payload.get("description"));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("{parentTaskId}/addTask")
	public ResponseEntity<Void> addTaskToProject(@PathVariable ObjectId parentTaskId, @RequestBody ObjectId childTaskId) {
		taskService.addTask(parentTaskId, childTaskId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
