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
@RequestMapping("/api/v1/projects")
public class ProjectController {
	
	public ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping
	public ResponseEntity<List<Project>> getAllProjects() {
		return new ResponseEntity<List<Project>>(projectService.allProjects(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Project>> getProject(@PathVariable ObjectId id) {
		return new ResponseEntity<Optional<Project>>(projectService.findProject(id), HttpStatus.OK);
	}
	
	@PostMapping("/newProject")
	public ResponseEntity<Project> createProject(@RequestBody Map<String, String> payload) {
		return new ResponseEntity<Project>(projectService.createProject(payload.get("projectName"),  payload.get("description")), HttpStatus.CREATED);
	}
	
	@PutMapping("{projectId}/addTask")
	public ResponseEntity<Void> addTaskToProject(@PathVariable ObjectId projectId, @RequestBody ObjectId taskId) {
		projectService.addTask(projectId, taskId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}


