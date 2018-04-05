// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018年3月25日, Lewis.Liu created
// ============================================================================
package com.ea.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.ea.web.constant.PathConsts;

/**
 * @author Lewis.Liu
 *
 */
@WebServlet(value = "/", name = "EaControlloer")
public class EaController extends HttpServlet {

    private static final long serialVersionUID = -4000136003111771574L;

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        final String servletPath = req.getServletPath();
        // TODO:  update path {login/main/index?}
        if (StringUtils.equals(servletPath, PathConsts.SEPARATOR_PATH)) {
            if (req.getSession().getAttribute("loginUser") == null) {
                req.getRequestDispatcher(PathConsts.LOGIN_PAGE);
            }
            req.getRequestDispatcher(PathConsts.MAIN_PAGE);
        }
        req.getRequestDispatcher(servletPath);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        doGet(req, resp);
    }
}
