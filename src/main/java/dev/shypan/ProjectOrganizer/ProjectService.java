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
public class ProjectService implements TaskAggregator{
	
	public ProjectRepository projectRepository;
	public MongoTemplate mongoTemplate;

	@Autowired
	public ProjectService(ProjectRepository projectRepository, MongoTemplate mongoTemplate) {
		this.projectRepository = projectRepository;
		this.mongoTemplate = mongoTemplate;
	}
	
	public List<Project> allProjects() {
		return projectRepository.findAll();
	}
	
	public Optional<Project> findProject(ObjectId id) {
		return projectRepository.findById(id);
	}
	
	public Project createProject(
			String projectName,
			String description
			) {
		Project project = new Project(projectName, description);
		
		projectRepository.insert(project);
		return project;
	}

	@Override
	public void addTask(ObjectId projectId, ObjectId taskId) {
		mongoTemplate.update(Project.class)
		.matching(Criteria.where("_id").is(projectId))
		.apply(new Update().push("tasks").value(taskId))
		.first();
		
	}
	
	

}
