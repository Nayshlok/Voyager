package models;
public class ModelAndView
{
	private final String viewName;
	private final Object model;
	
	public ModelAndView(Object model, String viewName)
	{
		this.viewName = viewName;
		this.model = model;
	}

	public String getViewName()
	{
		return viewName;
	}

	public Object getModel()
	{
		return model;
	}
}