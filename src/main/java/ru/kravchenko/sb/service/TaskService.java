package ru.kravchenko.sb.service;//package com.pirateway.scrapper.frontend.primefaces.service;
//
//
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import com.pirateway.scrapper.frontend.primefaces.api.repository.IProjectRepository;
//import com.pirateway.scrapper.frontend.primefaces.api.repository.ITaskRepository;
//import com.pirateway.scrapper.frontend.primefaces.api.repository.IUserRepository;
//import com.pirateway.scrapper.frontend.primefaces.api.service.ITaskService;
//import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
//import com.pirateway.scrapper.frontend.primefaces.model.dto.TaskDTO;
//import com.pirateway.scrapper.frontend.primefaces.model.entity.Project;
//import com.pirateway.scrapper.frontend.primefaces.model.entity.Task;
//import com.pirateway.scrapper.frontend.primefaces.model.entity.User;
//import com.pirateway.scrapper.frontend.primefaces.util.DataValidator;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//@Service
//public class TaskService implements ITaskService {
//
//
//    @NotNull
//    private final IProjectRepository projectRepository;
//
//    @NotNull
//    private final ITaskRepository taskRepository;
//
//    @NotNull
//    private final IUserRepository userRepository;
//
//
//    @Autowired
//    public TaskService(
//            @NotNull final ITaskRepository taskRepository,
//            @NotNull final IProjectRepository projectRepository,
//            @NotNull final IUserRepository userRepository) {
//        this.taskRepository = taskRepository;
//        this.projectRepository = projectRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    @Transactional
//    public void create(
//            @Nullable final TaskDTO taskDTO
//    ) throws DataValidateException {
//        DataValidator.validateTaskDTO(taskDTO);
//        @NotNull final Task task = convertDTOtoTask(taskDTO);
//        taskRepository.save(task);
//    }
//
//    @Override
//    @Transactional
//    public void edit(
//            @Nullable final TaskDTO taskDTO
//    ) throws DataValidateException {
//        DataValidator.validateTaskDTO(taskDTO);
//        @Nullable final Task task = taskRepository.findById(taskDTO.getId()).get();
//        @Nullable final String projectId = taskDTO.getProjectId();
//        if (task == null) throw new DataValidateException("Task not found");
//        task.setName(taskDTO.getName());
//        task.setDescription(taskDTO.getDescription());
//        task.setStatus(taskDTO.getStatus());
//        task.setDateBegin(taskDTO.getDateBegin());
//        task.setDateEnd(taskDTO.getDateEnd());
//        task.setProject(getProject(projectId));
//        taskRepository
//                .save(task);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public TaskDTO findOne(
//            @Nullable final String id,
//            @Nullable final String userId
//    ) throws DataValidateException {
//        DataValidator.validateString(id, userId);
//        @Nullable final Task task = taskRepository
//                .findByIdAndUser(id, getUser(userId));
//        if (task == null) throw new DataValidateException("Task not found");
//        return task.getDTO();
//    }
//
//    @Override
//    @Transactional
//    public void remove(
//            @Nullable final String id,
//            @Nullable final String userId
//    ) throws DataValidateException {
//        DataValidator.validateString(id, userId);
//        @Nullable final Task task = taskRepository
//                .findByIdAndUser(id, getUser(userId));
//        if (task == null) throw new DataValidateException("Task not found");
//        taskRepository.delete(task);
//    }
//
//    @Override
//    @Transactional
//    public void clear(
//    ) throws DataValidateException {
//        @Nullable final Collection<Task> tasks = taskRepository
//                .findAll();
//        if (tasks == null) throw new DataValidateException("Tasks not found");
//        tasks.forEach(taskRepository::delete);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public TaskDTO findOne(
//            @Nullable final String id
//    ) throws DataValidateException {
//        DataValidator.validateString(id);
//        @Nullable final Task task = taskRepository
//                .findById(id).get();
//        if (task == null) throw new DataValidateException("Task not found");
//        return task.getDTO();
//    }
//
//    @Override
//    @Transactional
//    public void remove(
//            @Nullable final String id
//    ) throws DataValidateException {
//        DataValidator.validateString(id);
//        @Nullable final Task task = taskRepository
//                .findById(id).get();
//        if (task == null) throw new DataValidateException("Task not found");
//        taskRepository.delete(task);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Collection<TaskDTO> findAll(
//    ) throws DataValidateException {
//        @Nullable final Collection<Task> tasks = taskRepository
//                .findAll();
//        if (tasks == null) throw new DataValidateException("Tasks not found");
//        return tasks
//                .stream()
//                .map(Task::getDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    @Transactional
//    public void removeAllByProjectId(
//            @Nullable final String id,
//            @Nullable final String userId
//    ) throws DataValidateException {
//        DataValidator.validateString(id, userId);
//        @Nullable final Collection<Task> tasks = taskRepository
//                .findByProjectAndUser(getProject(id), getUser(userId));
//        if (tasks == null) throw new DataValidateException("Tasks not found");
//        tasks.forEach(taskRepository::delete);
//    }
//
//    @Override
//    @Transactional
//    public void removeAllByUserId(
//            @Nullable final String id
//    ) throws DataValidateException {
//        DataValidator.validateString(id);
//        @Nullable final Collection<Task> tasks = taskRepository
//                .findAllByUser(getUser(id));
//        if (tasks == null) throw new DataValidateException("Tasks not found");
//        tasks.forEach(taskRepository::delete);
//
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Collection<TaskDTO> sortAllByUserId(
//            @Nullable final String id,
//            @Nullable final String parameter
//    ) throws DataValidateException {
//        DataValidator.validateString(id, parameter);
//        DataValidator.validateParameter(parameter);
//        @Nullable Collection<Task> tasks = null;
//        switch (parameter) {
//            case "order":
//                tasks = taskRepository
//                        .findAllByUser(getUser(id));
//                break;
//            case "status":
//                tasks = taskRepository
//                        .sortByStatus(getUser(id));
//                break;
//            case "dateBegin":
//                tasks = taskRepository
//                        .sortByDateBegin(getUser(id));
//                break;
//            case "dateEnd":
//                tasks = taskRepository
//                        .sortByDateEnd(getUser(id));
//                break;
//        }
//        if (tasks == null) throw new DataValidateException("Tasks not found");
//        return tasks
//                .stream()
//                .map(Task::getDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Collection<TaskDTO> findAllByPartOfNameOrDescription(
//            @Nullable final String name,
//            @Nullable final String description,
//            @Nullable final String userId
//    ) throws DataValidateException {
//        DataValidator.validateString(name, description, userId);
//        @Nullable final Collection<Task> tasks = taskRepository
//                .findAllByPartOfNameOrDescription(name, description, getUser(userId));
//        if (tasks == null) throw new DataValidateException("Tasks not found");
//        return tasks
//                .stream()
//                .map(Task::getDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Collection<TaskDTO> findAllByProjectId(
//            @Nullable final String id,
//            @Nullable final String userId
//    ) throws DataValidateException {
//        DataValidator.validateString(id, userId);
//        @Nullable final Collection<Task> tasks = taskRepository
//                .findByProjectAndUser(getProject(id), getUser(userId));
//        if (tasks == null) throw new DataValidateException("Tasks not found");
//        return tasks
//                .stream()
//                .map(Task::getDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Collection<TaskDTO> findAllByUserId(
//            @Nullable final String id
//    ) throws DataValidateException {
//        DataValidator.validateString(id);
//        @Nullable final Collection<Task> tasks = taskRepository
//                .findAllByUser(getUser(id));
//        if (tasks == null) throw new DataValidateException("Tasks not found");
//        return tasks
//                .stream()
//                .map(Task::getDTO)
//                .collect(Collectors.toList());
//    }
//
//    private Task convertDTOtoTask(
//            @NotNull final TaskDTO taskDTO
//    ) throws DataValidateException {
//        @NotNull final Task task = new Task();
//        task.setId(taskDTO.getId());
//        task.setName(taskDTO.getName());
//        task.setDescription(taskDTO.getDescription());
//        task.setDateBegin(taskDTO.getDateBegin());
//        task.setDateEnd(taskDTO.getDateEnd());
//        task.setUser(getUser(taskDTO.getUserId()));
//        task.setProject(getProject(taskDTO.getProjectId()));
//        task.setStatus(taskDTO.getStatus());
//        return task;
//    }
//
//    @Transactional(readOnly = true)
//    public User getUser(
//            @NotNull final String id
//    ) throws DataValidateException {
//        @Nullable final User user = userRepository.findById(id).get();
//        if (user == null) throw new DataValidateException("User not found!");
//        return user;
//    }
//
//    @Transactional(readOnly = true)
//    public Project getProject(
//            @Nullable final String id
//    ) throws DataValidateException {
//        if (DataValidator.stringIsNull(id))
//            return null;
//        @Nullable final Project project = projectRepository.findById(id).get();
//        if (project == null) throw new DataValidateException("Project not found!");
//        return project;
//    }
//}
