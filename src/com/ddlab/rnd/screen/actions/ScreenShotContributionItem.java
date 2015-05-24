package com.ddlab.rnd.screen.actions;


import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.ddlab.rnd.eclipse.plugin.util.PluginUtil;

public class ScreenShotContributionItem extends ContributionItem { 
	
	private Button screenBtn = null;


  public ScreenShotContributionItem(String id) {
    super(id);
  }

  public void fill(final Composite parent) {

    screenBtn = new Button(parent, SWT.NONE);
    screenBtn.setToolTipText("Take and save screenshot (CTRL+`)");
    ImageDescriptor ids = ImageDescriptor
			.createFromImage(PluginUtil.getScreenShotImage());
    screenBtn.setImage(ids.createImage());
    screenBtn.addSelectionListener( new SelectionAdapter() {
    	
    	@Override
    	public void widgetSelected(SelectionEvent e) {
    		screenBtn.setVisible(false);
//    		parent.redraw();
    		PluginUtil.saveButtonScreenShot();
    		screenBtn.setVisible(true);
    	}
    	
	});
    
  }
  
}