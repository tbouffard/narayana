package org.jboss.narayana.tomcat.jta;

import java.util.logging.Logger;

import com.arjuna.ats.jta.common.jtaPropertyManager;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

public class NarayanaLifecycleListener implements LifecycleListener {

    private static Logger LOG = Logger.getLogger(NarayanaLifecycleListener.class.getName());

    public void lifecycleEvent(LifecycleEvent event) {
        if (Lifecycle.BEFORE_INIT_EVENT.equals(event.getType())) {
            LOG.info("Responding to a 'before init' event");
            LOG.info("Overriding default JNDI name to match regular Tomcat names");
            //jtaPropertyManager.getJTAEnvironmentBean().setUserTransactionJNDIContext("java:comp/UserTransaction");
            jtaPropertyManager.getJTAEnvironmentBean().setTransactionManagerJNDIContext("java:comp/TransactionManager");
            jtaPropertyManager.getJTAEnvironmentBean().setTransactionSynchronizationRegistryJNDIContext("java:comp/TransactionSynchronizationRegistry");
        } else if (Lifecycle.BEFORE_START_EVENT.equals(event.getType())) {
            LOG.info("Responding to a 'before start' event");
            LOG.info("Initializing Transaction Manager and Synchronization Registry");
            jtaPropertyManager.getJTAEnvironmentBean().getTransactionManager();
            jtaPropertyManager.getJTAEnvironmentBean().getTransactionSynchronizationRegistry();
        }

    }

}