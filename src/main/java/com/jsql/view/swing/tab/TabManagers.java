/*******************************************************************************
 * Copyhacked (H) 2012-2016.
 * This program and the accompanying materials
 * are made available under no term at all, use it like
 * you want, but share and discuss about it
 * every time possible with every body.
 *
 * Contributors:
 *      ron190 at ymail dot com - initial implementation
 *******************************************************************************/
package com.jsql.view.swing.tab;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.jsql.i18n.I18n;
import com.jsql.view.swing.HelperUi;
import com.jsql.view.swing.MediatorGui;
import com.jsql.view.swing.manager.ManagerAdminPage;
import com.jsql.view.swing.manager.ManagerBruteForce;
import com.jsql.view.swing.manager.ManagerCoder;
import com.jsql.view.swing.manager.ManagerDatabase;
import com.jsql.view.swing.manager.ManagerFile;
import com.jsql.view.swing.manager.ManagerScan;
import com.jsql.view.swing.manager.ManagerSqlShell;
import com.jsql.view.swing.manager.ManagerUpload;
import com.jsql.view.swing.manager.ManagerWebShell;

/**
 * Panel on the left with functionalities like webshell, file reading and admin page finder.
 */
@SuppressWarnings("serial")
public class TabManagers extends MouseTabbedPane {
    /**
     * Create manager panel.
     */
    public TabManagers() {

        ManagerWebShell managerWebShell = new ManagerWebShell();
        ManagerScan managerScanList = new ManagerScan();
        ManagerDatabase managerDatabase = new ManagerDatabase();
        ManagerAdminPage managerAdminPage = new ManagerAdminPage();
        ManagerFile managerFile = new ManagerFile();
        ManagerUpload managerUpload = new ManagerUpload();
        ManagerSqlShell managerSqlShell = new ManagerSqlShell();
        
        MediatorGui.register(managerWebShell);
        MediatorGui.register(managerAdminPage);
        MediatorGui.register(managerScanList);
        MediatorGui.register(managerDatabase);
        MediatorGui.register(managerAdminPage);
        MediatorGui.register(managerFile);
        MediatorGui.register(managerUpload);
        MediatorGui.register(managerSqlShell);
        
        this.setMinimumSize(new Dimension(100, 0));
        this.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 0));
        this.addMouseClickMenu();

        JLabel labelDatabase = new JLabel(HelperUi.ICON_DATABASE_SERVER, SwingConstants.CENTER);
        this.addTab("DATABASE_TAB", HelperUi.ICON_DATABASE_SERVER, managerDatabase, I18n.valueByKey("DATABASE_TOOLTIP"));
        this.setTabComponentAt(
            this.indexOfTab("DATABASE_TAB"),
            labelDatabase
        );
        
        JLabel labelAdminPage = new JLabel(HelperUi.ICON_ADMIN_SERVER, SwingConstants.CENTER);
        this.addTab("ADMINPAGE_TAB", HelperUi.ICON_ADMIN_SERVER, managerAdminPage, I18n.valueByKey("ADMINPAGE_TOOLTIP"));
        this.setTabComponentAt(
            this.indexOfTab("ADMINPAGE_TAB"),
            labelAdminPage
        );
        
        JLabel labelFile = new JLabel(HelperUi.ICON_FILE_SERVER, SwingConstants.CENTER);
        this.addTab("FILE_TAB", HelperUi.ICON_FILE_SERVER, managerFile, I18n.valueByKey("FILE_TOOLTIP"));
        this.setTabComponentAt(
            this.indexOfTab("FILE_TAB"),
            labelFile
        );
        
        JLabel labelWebShell = new JLabel(HelperUi.ICON_SHELL_SERVER, SwingConstants.CENTER);
        this.addTab("WEBSHELL_TAB", HelperUi.ICON_SHELL_SERVER, managerWebShell, I18n.valueByKey("WEBSHELL_TOOLTIP"));
        this.setTabComponentAt(
            this.indexOfTab("WEBSHELL_TAB"),
            labelWebShell
        );
        
        JLabel labelSqlShell = new JLabel(HelperUi.ICON_SHELL_SERVER, SwingConstants.CENTER);
        this.addTab("SQLSHELL_TAB", HelperUi.ICON_SHELL_SERVER, managerSqlShell, I18n.valueByKey("SQLSHELL_TOOLTIP"));
        this.setTabComponentAt(
            this.indexOfTab("SQLSHELL_TAB"),
            labelSqlShell
        );
        
        JLabel labelUpload = new JLabel(HelperUi.ICON_UPLOAD, SwingConstants.CENTER);
        this.addTab("UPLOAD_TAB", HelperUi.ICON_UPLOAD, managerUpload, I18n.valueByKey("UPLOAD_TOOLTIP"));
        this.setTabComponentAt(
            this.indexOfTab("UPLOAD_TAB"),
            labelUpload
        );
        
        JLabel labelBruteforce = new JLabel(HelperUi.ICON_BRUTER, SwingConstants.CENTER);
        this.addTab("BRUTEFORCE_TAB", HelperUi.ICON_BRUTER, new ManagerBruteForce(), I18n.valueByKey("BRUTEFORCE_TOOLTIP"));
        this.setTabComponentAt(
            this.indexOfTab("BRUTEFORCE_TAB"),
            labelBruteforce
        );
        
        JLabel labelCoder = new JLabel(HelperUi.ICON_CODER, SwingConstants.CENTER);
        this.addTab("CODER_TAB", HelperUi.ICON_CODER, new ManagerCoder(), I18n.valueByKey("CODER_TOOLTIP"));
        this.setTabComponentAt(
            this.indexOfTab("CODER_TAB"),
            labelCoder
        );
        
        JLabel labelScan = new JLabel(HelperUi.ICON_SCANLIST, SwingConstants.CENTER);
        this.addTab("SCANLIST_TAB", HelperUi.ICON_SCANLIST, managerScanList, I18n.valueByKey("SCANLIST_TOOLTIP"));
        this.setTabComponentAt(
            this.indexOfTab("SCANLIST_TAB"),
            labelScan
        );

        managerFile.setButtonEnable(false);
        managerWebShell.setButtonEnable(false);
        managerSqlShell.setButtonEnable(false);
    }
}