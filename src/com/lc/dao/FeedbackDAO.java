package com.lc.dao;

import java.util.List;

import com.lc.entity.Feedback;
import com.lc.entity.User;

public interface FeedbackDAO {
	public int addFeedback(User user,String feedback);
	public List<Feedback> getFeedback();

}
