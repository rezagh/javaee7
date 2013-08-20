/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author rezaghafari
 */
@SessionScoped
public class BizIkmpl implements Biz,Serializable{

    @Override
    public String test() {
        System.out.println("aa");
        return "aa";
    }
    
}
