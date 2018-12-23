package org.openpnp.spi;

import org.openpnp.model.Job;

public interface JobProcessor extends PropertySheetHolder, WizardConfigurable {
    public interface TextStatusListener {
        public void textStatus(String text);
    }

    void initialize(Job job) throws Exception;
    
    /**
     * Perform the next available operation. If an error occurs a JobProcessorException will be
     * thrown. 
     * 
     * This exception contains a getOptions() method which indicates options that
     * can be used to continue past the error. By calling next() again with one of the selected
     * options the process can continue. 
     * 
     * Passing null for option will perform the default option, if any.
     *  
     * @param option
     * @return True if there are further operations to perform. False if the job is complete.
     * @throws JobProcessorException
     */
    public boolean next(Option option) throws JobProcessorException;

    public void abort() throws Exception;

    public void addTextStatusListener(TextStatusListener listener);

    public void removeTextStatusListener(TextStatusListener listener);
    
    public class JobProcessorException extends Exception {
        private final Option[] options;
        
        public JobProcessorException(Exception e, Option[] options) {
            super(e);
            this.options = options;
        }
        
        public Option[] getOptions() {
            return options;
        }
    }
    
    public interface Option {
        public String getShortDescription();
        public String getLongDescription();
    }
}
