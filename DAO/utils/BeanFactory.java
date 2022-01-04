package Concessionario.DAO.utils;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

public class BeanFactory {
    Hashtable<String, Object> ctx = new Hashtable<>();
     public BeanFactory() throws Exception{
         InputStream is =this.getClass().getClassLoader().getResourceAsStream("FactoryConfig.properties");
         Properties properties = new Properties();
         if(is==null) {
             System.out.println("Sorry, unable to find config.properties");
             return;
         }
        properties.load(is);
        Enumeration<Object> keys=properties.keys();
        while(keys.hasMoreElements()) {
            String key=keys.nextElement().toString();
            String className=properties.getProperty(key);
            Object o=this.getClass().getClassLoader().loadClass(className).getDeclaredConstructor().newInstance();
            this.ctx.put(key,o);
        }
     }

    public Object getBean(String key) {
        return this.ctx.get(key);
    }
}
