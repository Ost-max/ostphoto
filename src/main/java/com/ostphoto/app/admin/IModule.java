package com.ostphoto.app.admin;



import java.util.Map;

import org.springframework.ui.Model;



/**
 * Allows to get preview of module to start admin page
 * @author Ostrovksy Max
 *
 */
public interface IModule {
	

	
	public final static String  VIEW_LIST = "viewList";
	
	
//	/** Fill model with name of view that will be include in start page. 
//	 * This view should be a "little version" of module.
//	 * @param model
//	 */
//	public void addModuleViewName(Model model, String viewName) {
//		List<String> viewNamesList;
//		if(model.containsAttribute(VIEW_LIST)) {
//			viewNamesList = (List<String>)model.asMap().get(VIEW_LIST);	
//		} else {
//			viewNamesList = new ArrayList<String>();
//		}		
//		viewNamesList.add(viewName);
//	}
//
// 
//
//	public BaseModule addModuleModelAtrr (Model model, String attrName, Object attr) {
//		model.addAttribute(this.getClass().getSimpleName() + "_" + attrName, attr);
//		return this;
//	}
//	
//	
	
	
	/** Fill model with name of view that will be include in start page. 
	 * This view should be a "little version" of module.
	 * @param model
	 */
	public String getSmallViewName();
	
	
	
	/** Fill model with attributes needs to view. See {@link #addModuleModelAtrr(Model)}
	 * All atributes in view should start with "ModuleClass.getSimpleName()_AttrName"
	 * @param attrName
	 * @param attr
	 * @return this
	 */
	public Map<String, ?> getSmallAttributes();
	
	

	

	
}
