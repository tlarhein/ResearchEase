package org.launchcode.models.forms;

import org.launchcode.models.Project;
import org.launchcode.models.User;

import javax.validation.constraints.NotNull;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

public class AddUserForm {

    private User user;

    private Iterable<Project> projects;

    @NotNull
    private int userId;

    @NotNull
    private int projectId;

    public AddUserForm(User user, Iterable<Project> projects) {
        this.user = user;
        this.projects = projects;
    }

    public AddUserForm() {
    }

    public Project getProject(Project project) {
        return project;
    }

    public User getUser() {
        return user;
    }

    public Iterable<User> getUsers(Iterable<User> users) {
        return users;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public Iterable<Project> getProjects() {
        return projects;
    }

    public void setProjects(Iterable<Project> projects) {
        this.projects = projects;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
