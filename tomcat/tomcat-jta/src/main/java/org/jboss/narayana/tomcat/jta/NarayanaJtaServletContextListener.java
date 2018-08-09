/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2016, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.narayana.tomcat.jta;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Class responsible for configuring and initializing Narayana JTA services for the servlet container.
 *
 * @author <a href="mailto:gytis@redhat.com">Gytis Trikleris</a>
 */
@WebListener
public class NarayanaJtaServletContextListener extends AbstractNarayanaListener implements ServletContextListener {

    /**
     * Initialize and start Narayana JTA services.
     *
     * @see AbstractNarayanaListener#initialize()
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.initialize();
    }

    /**
     * Stop Narayana JTA services.
     *
     * @see AbstractNarayanaListener#disable()
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.disable();
    }

}
