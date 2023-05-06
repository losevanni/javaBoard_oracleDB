package model;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import common.DBConnPool;
import common.JDBConnect;

public class boardUse extends DBConnPool{
	public boardUse() {
		super();	
	}
	//create 
	public int createPost(board dto) {
		int result =0;
		try {
			String query="INSERT INTO boards"
					+" (idx, id, title, content, ofile, sfile, pass, postdate)"
					+"VALUES"
					+" (seq_board_num.NEXTVAL,?,?,?,?,?,?,SYSDATE)";
			psmt=con.prepareStatement(query);
			psmt.setString(1,dto.getId());
			psmt.setString(2,dto.getTitle() );
			psmt.setString(3,dto.getContent() );
			psmt.setString(4,dto.getOfile() );
			psmt.setString(5,dto.getSfile() );
			psmt.setString(6,dto.getPass() );
			result=psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("[error] createPost error help me");
			e.printStackTrace();
		}
		return result;
	}
	//select All
	public List<board> allPost() {
		List<board> boardList =new ArrayList<board>();
		
		String query ="SELECT * FROM boards ORDER BY idx DESC";

		try {
			psmt=con.prepareStatement(query);
			rs=psmt.executeQuery();
			while(rs.next()) {
				board arr=new board();
				arr.setIdx(rs.getInt("idx"));
				arr.setTitle(rs.getString("title"));
				arr.setId(rs.getString("id"));
				arr.setPostdate(rs.getDate("postdate"));
//				System.out.println(arr.getTitle());
				boardList.add(arr);
			}
		} catch (Exception e) {
			System.out.println("[error] allPost error");
			e.printStackTrace();
		}
		return boardList ;
	}
	
	//select 1
	public board detailPost(int idx) {
		board dto = new board();
		String query= "SELECT * FROM boards WHERE idx=?";
		try {
			psmt =con.prepareStatement(query);
			psmt.setInt(1, idx);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dto.setIdx(rs.getInt("idx"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setPass(rs.getString("pass"));
				dto.setPostdate(rs.getDate("postdate"));
			}
			
		} catch (Exception e) {
			System.out.println("[error] detailPost error help");
			e.printStackTrace();
		}
		return dto;
	}
	//delete
	public int deletePost(int idx) {
		int result=0;
		try {
			String query="DELETE FROM boards WHERE idx=?";
			psmt=con.prepareStatement(query);
			psmt.setInt(1,idx);
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
			String query = "UPDATE boards" 
					+" SET id=?, title=?, content=?, ofile=?, sfile=?, pass=? "
					+" WHERE idx=?";

			psmt=con.prepareStatement(query);
			psmt.setString(1,dto.getId());
			psmt.setString(2,dto.getTitle());
			psmt.setString(3,dto.getContent());
			psmt.setString(4,dto.getOfile());
			psmt.setString(5,dto.getSfile());
			psmt.setString(6, dto.getPass());
			psmt.setInt(7, dto.getIdx());
			
			result=psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("[error] updatePost error help");
			e.printStackTrace();
		}
		return result;
	}
	
}
