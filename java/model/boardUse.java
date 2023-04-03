package model;

import java.sql.*;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import common.DBConnPool;

public class boardUse extends DBConnPool{
	public boardUse() {
		super();	
	}
	//create 
	public int createPost(board dto) {
		int result =0;
		try {
			String query="INSERT INTO board ("
					+")"
					+"VALUES ("
					+"seq_board_num.NEXTVAL)";
		}catch(Exception e) {
			System.out.println("[error] createPost error help me");
			e.printStackTrace();
		}
		return result;
	}
	//select
	public board detailPost(String idx) {
		board dto = new board();
		String query= "SELECT * FROM board WHERE idx=?";
		try {
			psmt =con.prepareStatement(query);
			psmt.setString(1,idx);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dto.setIdx(rs.getString(1));
			}
			
		} catch (Exception e) {
			System.out.println("[error] detailPost error help");
			e.printStackTrace();
		}
		return dto;
	}
	//delete
	public int deletPost(String idx) {
		int result=0;
		try {
			String query="DELETE FROM board WHERE idx=?";
			psmt=con.prepareStatement(query);
			psmt.setString(1,idx);
			result= psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[error] deletePost error help");
			e.printStackTrace();
		}
		return result;	
	}
	//update
	public int updatePost(board dto) {
		int result=0;
		try {
			String query = "UPDATE board" 
					+" SET title=?,name=?,content=?"
					+"WHERE idx=? and pass=?";
			psmt=con.prepareStatement(query);
			
			psmt.setString(1,dto.getTitle());
			
			result=psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[error] updatePost error help");
			e.printStackTrace();
		}
		return result;
	}
	
}
