package dev.shypan.ProjectOrganizer;

import org.bson.types.ObjectId;

public interface TaskAggregator {
	void addTask(ObjectId aggId, ObjectId taskId);
}
	