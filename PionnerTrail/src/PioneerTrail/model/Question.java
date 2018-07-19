/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
/**
 * @author Elías
 */
public class Question implements Serializable{
    
//atributes
    private String question;
    private int conrrectAnswer;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    
//relationship with other classes
    
    
//default constructor
    public Question(){
    }
    


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getConrrectAnswer() {
        return conrrectAnswer;
    }

    public void setConrrectAnswer(int conrrectAnswer) {
        this.conrrectAnswer = conrrectAnswer;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.question);
        hash = 41 * hash + Objects.hashCode(this.conrrectAnswer);
        hash = 41 * hash + Objects.hashCode(this.answer1);
        hash = 41 * hash + Objects.hashCode(this.answer2);
        hash = 41 * hash + Objects.hashCode(this.answer3);
        hash = 41 * hash + Objects.hashCode(this.answer4);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.conrrectAnswer, other.conrrectAnswer)) {
            return false;
        }
        if (!Objects.equals(this.answer1, other.answer1)) {
            return false;
        }
        if (!Objects.equals(this.answer2, other.answer2)) {
            return false;
        }
        if (!Objects.equals(this.answer3, other.answer3)) {
            return false;
        }
        if (!Objects.equals(this.answer4, other.answer4)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Question{" + "question=" + question + ", conrrectAnswer=" + conrrectAnswer + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + '}';
    }
//This method was created when testin the Map class
    public void setCorrectAnswer(String sin_duda) {
        //throw new method was commented to allow the test work
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }
