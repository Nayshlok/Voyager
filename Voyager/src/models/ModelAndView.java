package models;
public class ModelAndView
{
	private final String viewName;
	private final Object model;
	private final boolean redirect;
	
	public ModelAndView(Object model, String viewName, boolean redirect)
	{
		this.viewName = viewName;
		this.model = model;
		this.redirect = redirect;
	}
	
	public ModelAndView(Object model, String viewName){
		this(model, viewName, false);
	}

	public String getViewName()
	{
		return viewName;
	}

	public Object getModel()
	{
		return model;
	}
	
	public boolean isRedirect(){
		return redirect;
	}
}