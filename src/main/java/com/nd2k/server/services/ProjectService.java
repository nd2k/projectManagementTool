package com.nd2k.server.services;

import com.nd2k.server.exceptions.ProjectIdException;
import com.nd2k.server.models.Project;
import com.nd2k.server.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project Id '" + project.getProjectIdentifier() + "' already exists");
        }
    }

    public Project findByProjectIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if(project == null) {
            throw new ProjectIdException("Project Id '" + projectId + "' does not exist");
        }
        return project;
    }

    public Iterable<Project> findAllProject() {
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if(project == null) {
            throw new ProjectIdException("Cannot delete project with id '" + projectId + "'");
        }
        projectRepository.delete(project);
    }
}
