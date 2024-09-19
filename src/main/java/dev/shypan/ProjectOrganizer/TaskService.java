package dev.shypan.ProjectOrganizer;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements TaskAggregator{
	
	private TaskRepository taskRepository;
	private MongoTemplate mongoTemplate;
		
	@Autowired
	public TaskService(TaskRepository taskRepository, MongoTemplate mongoTemplate) {
		super();
		this.taskRepository = taskRepository;
		this.mongoTemplate = mongoTemplate;
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
	
//	public Optional<Task> singleTaskByTaskId(Integer id) {
//		return taskRepository.findTaskByTaskId(id);
//	}
	
	public Task createTask(
			String taskName,
			String description
			) {
		
		Task task = taskRepository.insert(new Task(taskName, description));
		
		return task;
	}


	@Override
	public void addTask(ObjectId parentTaskId, ObjectId childTaskId) {
		mongoTemplate.update(Task.class)
		.matching(Criteria.where("_id").is(parentTaskId))
		.apply(new Update().push("subTasks").value(childTaskId))
		.first();
	
	}




}
