package dev.shypan.ProjectOrganizer;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	private TaskRepository taskRepository;
	
	@Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
	
	public List<Task> allTasks() {
		return taskRepository.findAll(); 
//		return taskRepository.findAllTasks();
	}
	
//	public List<Task> allTasks() {
//	    List<Task> tasks = taskRepository.findAllTasks();
//	    System.out.println("Tasks found: " + tasks);
//	    return tasks;
//	}

	
	public long countTasks() {
	    return taskRepository.count();
	}
	
	public Optional<Task> singleTask(ObjectId id) {
		return taskRepository.findById(id);
	}
	
	public Optional<Task> singleTaskByTaskId(Integer id) {
		return taskRepository.findTaskByTaskId(id);
	}
	
	public Task createTask(
			String taskName,
			String description
			) {
		Task task = new Task(taskName, description);
		
		taskRepository.insert(task);
		return task;
	}
	

}
