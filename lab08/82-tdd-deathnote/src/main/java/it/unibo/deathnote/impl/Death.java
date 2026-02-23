package it.unibo.deathnote.impl;

public class Death {
    
    private String details;
    private String cause;
    private final long timeOfNameWriting;
    
    /*    public Death() {
    }

    public Death(final String cause, final String  details) {
        this.details=details;
        this.cause=cause;
    }

 */

    public Death() {
        this.cause = "heart attack"; // Valore di default
        this.details = "";           // Valore di default
        this.timeOfNameWriting = System.currentTimeMillis();
    }

    // QUESTA È L'IMPLEMENTAZIONE CHE MANCAVA:
    public void setCause(String cause) {
        this.cause = cause;
    }

    public long getTimeOfNameWriting() {
        return this.timeOfNameWriting;
    }
    
    // Ti servirà anche questo per il prossimo metodo (writeDetails)
    public void setDetails(String details) {
        this.details = details;
    }

    public String getCause(){
        return this.cause;
    }

    public String getDetails(){
        return this.details;
    }
}
