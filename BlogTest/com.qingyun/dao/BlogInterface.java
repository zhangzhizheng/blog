package dao;

import java.util.List;

import entity.Blog;

public interface BlogInterface {
	/*
	 * 添加博客
	 * */	
	public boolean addBlog(Blog blog);
	
	/*
	 * 更改博客
	 * */
	public boolean modifiyBlog(Blog blog);
	
	/*
	 * 删除博客
	 * */
	public boolean deleteBlog(int i);
	
	/*
	 * 查询博客
	 * */	
	public List<Blog> queryBlog(int tag);
}
