/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.inventory;
import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.IKeyed;
import com.openbravo.data.loader.SerializableRead;
/**
 *
 * @author hgrimberg
 */
public class HostInfo implements SerializableRead{
    private static final long serialVersionUID = 9032683595230L;
    private String m_sHostID;
    private String m_sHostName;
    private String m_sHostLocation;
 
    
    public HostInfo(){
        
     m_sHostID=null;
     m_sHostName=null;
     m_sHostLocation=null;
        
    }  
    
    public void getHostInfo(DataRead dr) throws BasicException
    {
    }
    public void setHostID(String hid)
    {
         m_sHostID=hid;
    }
   public void setHostName(String hostname){
       m_sHostName=hostname;
   }
   public void setHostLocation(String locationID){
        m_sHostLocation=locationID;
   }
   public String getHostID(){
       return m_sHostID;
   }
   public String getHostName(){
       return m_sHostName;
   }
   public String getHostLocation(){
       return m_sHostLocation;
 
   }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
