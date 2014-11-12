package models;

import java.util.HashSet;

public class Comments 
{
	private HashSet<CommentModel> commentsList;
	public Comments()
	{
		commentsList = new HashSet<>();
	}	
	public HashSet getCommentsList() {
		return commentsList;
	}	
	public void AddComment(CommentModel comment)
	{
		commentsList.add(comment);
	}
	public CommentModel getComment(int ID)
	{
        CommentModel comment = null;
        for(CommentModel model: commentsList)
        {
            if(model.getID() == ID)
            {
                comment = model;
                break;
            }
        }
		return comment;
	}
	public void RemoveComment(CommentModel comment)
	{
		commentsList.remove(comment);
	}
	
	
}
