package core;

import org.apache.http.client.fluent.Executor;

// TODO: Auto-generated Javadoc
/**
 * The Interface SecurityConfiguration.
 */
public interface SecurityConfiguration {
	
	/**
	 * Gets the executor.
	 *
	 * @return the executor
	 */
	Executor getExecutor();	
	
	/**
	 * User preemptive auth.
	 *
	 * @return true, if successful
	 */
	boolean userPreemptiveAuth();
}
