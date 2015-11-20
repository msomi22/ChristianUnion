/**
 * 
 */
package com.gmail.mwendapeter72.server.pagination.student.detail;

import java.util.ArrayList;
import java.util.List;
import com.gmail.mwendapeter72.server.bean.student.StudentOtherDetail;



/**
 * @author peter
 *
 */
public class StudentPage2 {
	
	private int pageNum;
	private int totalPage;
	private int pagesize;
    private List<StudentOtherDetail> contents;

	/**
	 * 
	 */
	public StudentPage2() {
		pageNum = 1;
		totalPage = 1;
		pagesize = 1;
		contents = new ArrayList<>();
	}
   
	
	public StudentPage2(final int pageNum, final int totalPage, final int pagesize,
			final List<StudentOtherDetail> contents) {
		this.pageNum = pageNum;
		this.totalPage = totalPage;
		this.pagesize = pagesize;
		this.contents = contents;
	}
	
	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the pagesize
	 */
	public int getPagesize() {
		return pagesize;
	}

	/**
	 * @param pagesize the pagesize to set
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * @return the contents
	 */
	public List<StudentOtherDetail> getContents() {
		return new ArrayList<>(contents);
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<StudentOtherDetail> contents) {
		this.contents = contents;
	}
	 
	

    /**
     *
     * @return		<code>true</code> if this is the first page; <code>false</code>
     * for otherwise
     */
	
	public boolean isFirstPage() {
	        return pageNum == 1;
	    }

	    /**
	     *
	     * @return		<code>true</code> if this is the last page; <code>false</code>
	     * for otherwise
	     */
	    public boolean isLastPage() {
	        return pageNum == totalPage;
	    }

}
