package dev.shypan.ProjectOrganizer;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	@Id
	private ObjectId _id;
	private Integer taskId;
	private String taskName;
	private LocalDateTime dateCreated;
	private LocalDateTime dateCompleted;
	private LocalDateTime dateUpdated;
	private List<Integer> subTasks;
	private List<String> task_images;
	private List<Integer> tags;
	private Integer points;
	private boolean alertOn;
	private String description;
	private LocalDateTime age;
	
	public Task(String taskName, String description) {
		this.taskName = taskName;
		this.description = description;		
	}
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getDateCompleted() {
		return dateCompleted;
	}
	public void setDateCompleted(LocalDateTime dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	public List<Integer> getSubTasks() {
		return subTasks;
	}
	public void setSubTasks(List<Integer> subTasks) {
		this.subTasks = subTasks;
	}
	public List<String> getTask_images() {
		return task_images;
	}
	public void setTask_images(List<String> task_images) {
		this.task_images = task_images;
	}
	public List<Integer> getTags() {
		return tags;
	}
	public void setTags(List<Integer> tags) {
		this.tags = tags;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public boolean isAlertOn() {
		return alertOn;
	}
	public void setAlertOn(boolean alertOn) {
		this.alertOn = alertOn;
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

	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	

}
