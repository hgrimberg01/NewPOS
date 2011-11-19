/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.inventory;
import com.openbravo.basic.BasicException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListCellRenderer;
import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.panels.JPanelTable;

/**
 *
 * @author hgrimberg
 */
public class HostPanel extends JPanelTable {
    private TableDefinition hosts;
    private HostView jeditor;
    
     public HostPanel() {
     }
     protected void init() {   
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");          
       hosts = dlSales.getTableHosts();
        try {
            jeditor = new HostView(dirty,dlSales);
        } catch (BasicException ex) {
            Logger.getLogger(LocationsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public ListProvider getListProvider() {
        return new ListProviderCreator(hosts);
    }
    
    
    public SaveProvider getSaveProvider() {
        return new SaveProvider(hosts);        
    }
    
    @Override
    public Vectorer getVectorer() {
        return hosts.getVectorerBasic(new int[]{1, 2});
    }
    
    @Override
    public ComparatorCreator getComparatorCreator() {
        return hosts.getComparatorCreator(new int[] {1, 2});
    }
    
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(hosts.getRenderStringBasic(new int[]{1}));
    }
    
    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Locations");
    }
     
    }
    
    

