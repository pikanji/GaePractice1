package net.pikanji.gae.practice1;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PersistenceManagerFactorySingleton {

    private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PersistenceManagerFactorySingleton() {
    	throw new AssertionError();
    }

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
}