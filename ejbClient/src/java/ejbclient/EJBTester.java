/*
 * this is a standalone ejb client for glassfish server
 * 1- create a remote ejb (with remote interface) and deploy to glass fish.
 * 2- import the interface into this project and run.
 */
package ejbclient;

import java.math.BigDecimal;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javaeetutorial.converter.ejb.Converter;
/**
 *
 * @author rezaghafari
 */
public class EJBTester {


    public static void main(String args[]) throws NamingException{
        doit();
       
    }

    private static void doit() throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
 
        // glassfish default port value will be 3700,
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
 
        InitialContext ctx = new InitialContext(props);
        //we have given the ejb the following name.
        //using the remote interface here.
        //the example in the tutorial was not a remote ejb. I created one like this:

        /*  
            @Remote (Converter.class)
            @Stateless(name="ConverterBean", mappedName="ejb/ConverterBean")
            public class ConverterBean implements Converter{
        
        also see
         
        http://anirbanchowdhury.wordpress.com/2012/06/07/ejb-3-application-in-glassfish-3x/
        http://wiki.netbeans.org/CreatingEJB3UsingNetbeansAndGlassfish
 ` 
         
        */
        
        
        
        Converter exampleBean = (Converter) ctx.lookup("ejb/ConverterBean");
        
        BigDecimal yenAmount = exampleBean.dollarToYen(new BigDecimal(4));
        System.out.println("output:" + yenAmount);

    }
  }
