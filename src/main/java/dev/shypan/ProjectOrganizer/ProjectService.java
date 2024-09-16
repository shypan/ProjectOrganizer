package dev.shypan.ProjectOrganizer;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	
	public ProjectRepository projectRepository;

	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public List<Project> allProjects() {
		return projectRepository.findAll();
	}
	
	public Project createProject(
			String projectName,
			String description
			) {
		Project project = new Project(projectName, description);
		
		projectRepository.insert(project);
		return project;
	}
	
	

}
