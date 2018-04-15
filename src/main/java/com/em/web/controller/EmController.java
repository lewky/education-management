// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION em.1.0.0
// ============================================================================
// CHANGE LOG
// em.1.0.0 : 2018年3月25日, Lewis.Liu created
// ============================================================================
package com.em.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.em.web.constant.AttrConsts;
import com.em.web.constant.PathConsts;

/**
 * @author Lewis.Liu
 *
 */
@WebServlet(value = "/em", name = "EmControlloer")
public class EmController extends HttpServlet {

    private static final long serialVersionUID = -4000136003111771574L;

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        // 进行登录验证，如果用户未登录则转发到登陆页面
        if (req.getSession().getAttribute(AttrConsts.LOGIN_USER) == null) {
            req.getRequestDispatcher(PathConsts.PATH_PREFIX + PathConsts.LOGIN_PAGE).forward(req, resp);
            return;
        }
        req.getRequestDispatcher(PathConsts.PATH_PREFIX + PathConsts.MAIN_PAGE).forward(req, resp);
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
