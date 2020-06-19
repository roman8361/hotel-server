package ru.kravchenko.sb.util;//package com.pirateway.scrapper.frontend.primefaces.util;
//
//import com.pirateway.scrapper.frontend.primefaces.model.dto.ProjectDTO;
//import com.pirateway.scrapper.frontend.primefaces.model.dto.TaskDTO;
//import com.pirateway.scrapper.frontend.primefaces.model.dto.UserDTO;
//import com.pirateway.scrapper.frontend.primefaces.model.entity.Bet;
//import com.pirateway.scrapper.frontend.primefaces.model.entity.Fork;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//import com.pirateway.scrapper.frontend.primefaces.enumerate.Role;
//import com.pirateway.scrapper.frontend.primefaces.enumerate.Status;
//import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class DataValidator {
//    public static boolean stringIsNull(
//            @Nullable final String string) {
//        if (string == null || string.isEmpty() || "null".equals(string))
//            return true;
//        return false;
//    }
//
//    public static void validateString(
//            @Nullable final String... strings)
//            throws DataValidateException {
//        for (String string : strings) {
//            if (string == null || string.isEmpty())
//                throw new DataValidateException("Input parameter not must be null or empty!");
//        }
//    }
//
//    public static void validateRole(
//            @Nullable final Role role)
//            throws DataValidateException {
//        if (role == null) throw new DataValidateException("Incorrect input role!");
//    }
//
//    public static void validateStatus(
//            @Nullable final Status status)
//            throws DataValidateException {
//        if (status == null) throw new DataValidateException("Incorrect input status!");
//    }
//
//    public static void validateParameter(
//            @Nullable final String parameter)
//            throws DataValidateException {
//        Map<String, String> parameters = new HashMap<>(4);
//        parameters.put("order", "order");
//        parameters.put("dateBegin", "dateBegin");
//        parameters.put("dateEnd", "dateEnd");
//        parameters.put("status", "status");
//        if (parameters.get(parameter) == null) throw new DataValidateException("Incorrect input parameter!");
//    }
//
//    public static void validateProjectDTO(
//            @Nullable final ProjectDTO projectDTO)
//            throws DataValidateException {
//        if (projectDTO == null)
//            throw new DataValidateException("Incorrect project dto!");
//        if (projectDTO.getId() == null || projectDTO.getId().isEmpty())
//            throw new DataValidateException("Id project not must be empty!");
//        if (projectDTO.getUserId() == null || projectDTO.getUserId().isEmpty())
//            throw new DataValidateException("User id not must be empty!");
//        if (projectDTO.getName() == null || projectDTO.getName().isEmpty())
//            throw new DataValidateException("Project name not must be empty!");
//        if (projectDTO.getDescription() == null || projectDTO.getDescription().isEmpty())
//            throw new DataValidateException("Project description not must be empty!");
//        if (projectDTO.getDateBegin() == null)
//            throw new DataValidateException("Project date begin not must be empty!");
//        validateStatus(projectDTO.getStatus());
//    }
//
//    public static void validateTaskDTO(
//            @Nullable final TaskDTO taskDTO)
//            throws DataValidateException {
//        if (taskDTO == null)
//            throw new DataValidateException("Incorrect task dto!");
//        if (taskDTO.getId() == null || taskDTO.getId().isEmpty())
//            throw new DataValidateException("Id task not must be empty!");
//        if (taskDTO.getUserId() == null || taskDTO.getUserId().isEmpty())
//            throw new DataValidateException("User id not must be empty!");
//        if (taskDTO.getName() == null || taskDTO.getName().isEmpty())
//            throw new DataValidateException("Task name not must be empty!");
//        if (taskDTO.getDescription() == null || taskDTO.getDescription().isEmpty())
//            throw new DataValidateException("Task description not must be empty!");
//        if (taskDTO.getDateBegin() == null)
//            throw new DataValidateException("Task date begin not must be empty!");
//        validateStatus(taskDTO.getStatus());
//    }
//
//    public static void validateUserDTO(
//            @Nullable final UserDTO userDTO,
//            @NotNull final boolean validatePassword)
//            throws DataValidateException {
//        if (userDTO == null)
//            throw new DataValidateException("Incorrect user dto!");
//        if (userDTO.getId() == null || userDTO.getId().isEmpty())
//            throw new DataValidateException("Id user not must be empty!");
//        if (userDTO.getLogin() == null || userDTO.getLogin().isEmpty())
//            throw new DataValidateException("User userLogin not must be empty!");
//        if (validatePassword)
//            if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty())
//                throw new DataValidateException("User password not must be empty!");
//        validateRole(userDTO.getRole());
//    }
//
//    public static void validateFork(
//            @Nullable final Fork fork
//    ) throws DataValidateException {
//        if (fork == null)
//            throw new DataValidateException("Incorrect fork!");
//        if (fork.getId() == null || fork.getId().isEmpty())
//            throw new DataValidateException("Ford id not must be empty!");
//    }
//
//    public static void validateBet(
//            @Nullable final Bet bet
//    ) throws DataValidateException {
//        if (bet == null)
//            throw new DataValidateException("Incorrect bet!");
//        if (bet.getId() == null || bet.getId().isEmpty())
//            throw new DataValidateException("Bet id not must be empty!");
//    }
//}
