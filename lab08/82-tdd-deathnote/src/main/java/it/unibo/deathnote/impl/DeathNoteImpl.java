package it.unibo.deathnote.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImpl implements DeathNote {

    private final Map<String, Death> deaths;
    private String lastWrittenName;
    private long lastTimeWritten;

    public DeathNoteImpl(){
        deaths = new LinkedHashMap<>();
    }

    @Override
    public String getRule(int ruleNumber) {
        if(ruleNumber < 1 || ruleNumber> RULES.size()){
            throw new IllegalArgumentException("rule out of bounds");
        }else{
            return RULES.get(ruleNumber-1);
        }
    }

    @Override
    public void writeName(String name) {
        if(name==null){ 
            throw new NullPointerException("name cant be NULL");
        }else{
            lastWrittenName=name;
            lastTimeWritten=System.currentTimeMillis();
            deaths.put(name,new Death());
        }
    }

    @Override
    public boolean writeDeathCause(String cause) {
        if(lastWrittenName==null){
            throw new IllegalStateException();
        }

        long currentTime=System.currentTimeMillis();
        long timeDifference = currentTime-lastTimeWritten;
        if(timeDifference<=40){
            Death currenDeath= deaths.get(lastWrittenName);
            currenDeath.setCause(cause);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean writeDetails(String details) {
        if(lastWrittenName==null || details==null){
                throw new IllegalStateException();
            }
            
        long currentTime=System.currentTimeMillis();
        long timeDifference = currentTime-lastTimeWritten;

        if(timeDifference<=6040){
            Death currenDeath= deaths.get(lastWrittenName);
            currenDeath.setDetails(details);
            return true;
        }else{
            return false;
            }
    }

    @Override
    public String getDeathCause(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeathCause'");
    }

    @Override
    public String getDeathDetails(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeathDetails'");
    }

    @Override
    public boolean isNameWritten(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isNameWritten'");
    }
    
}
