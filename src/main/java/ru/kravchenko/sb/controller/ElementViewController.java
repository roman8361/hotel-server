package ru.kravchenko.sb.controller;//package com.pirateway.scrapper.frontend.primefaces.face;
//
//import com.pirateway.scrapper.frontend.primefaces.exception.DataValidateException;
//import com.pirateway.scrapper.frontend.primefaces.util.BootStrap;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import com.pirateway.scrapper.frontend.primefaces.api.service.ISessionService;
//
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class ElementViewController {
//
//    @NotNull
//    private boolean visibleForUser = false;
//
//    @NotNull
//    private boolean visibleForAdmin = false;
//
//    @NotNull
//    @Autowired
//    ISessionService sessionService;
//
//    public boolean getVisibleForUser() {
//        @NotNull final HttpSession session = (HttpSession) FacesContext
//                .getCurrentInstance()
//                .getExternalContext()
//                .getSession(false);
//        visibleForUser = sessionService.isUser(session);
//        return visibleForUser;
//    }
//
//    public void setVisibleForUser(boolean visibleForUser) {
//        this.visibleForUser = visibleForUser;
//    }
//
//    public boolean getVisibleForAdmin() {
//        @NotNull final HttpSession session = (HttpSession) FacesContext
//                .getCurrentInstance()
//                .getExternalContext()
//                .getSession(false);
//        visibleForAdmin = sessionService.isAdmin(session);
//        return visibleForAdmin;
//    }
//
//    public void setVisibleForAdmin(boolean visibleForAdmin) {
//        this.visibleForAdmin = visibleForAdmin;
//    }
//
//}
