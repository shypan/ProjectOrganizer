package dev.shypan.ProjectOrganizer;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document("projects")
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	@Id
	private ObjectId _id;
	private Integer projectId;
	private String projectName;
	private LocalDateTime dateCreated;
	private LocalDateTime dateUpdated;
	private LocalDateTime dateCompleted;
	private List<ObjectId> tasks;
	private List<Integer> tags;
	private String description;
	private LocalDateTime age;
	
	public Project(String projectName, String description) {
		super();
		this.projectName = projectName;
		this.description = description;
	}



	public ObjectId get_id() {
		return _id;
	}



	public void set_id(ObjectId _id) {
		this._id = _id;
	}



	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public LocalDateTime getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(LocalDateTime dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public List<ObjectId> getTasks() {
		return tasks;
	}

	public void setTasks(List<ObjectId> tasks) {
		this.tasks = tasks;
	}

	public List<Integer> getTags() {
		return tags;
	}

	public void setTags(List<Integer> tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getAge() {
		return age;
	}

	public void setAge(LocalDateTime age) {
		this.age = age;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	

}
