  package model;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import common.DBConnPool;
import common.JDBConnect;
//import model.member;

public class memberUse extends DBConnPool {
	public memberUse() {
		super();
	}
// JDBConnect use ex.
//public class memberUse extends JDBConnect{
//		public memberUse(ServletContext application) {
//			super(application);
//		}
//	}
	//create
	public int createMember(member dto){
		int result =0;
		try {
			String query="INSERT INTO members (id,pw,name)"
					+"VALUES (?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1,dto.getId());
			psmt.setString(2,dto.getPw());
			psmt.setString(3,dto.getName());
			result=psmt.executeUpdate();
					
		} catch (Exception e) {
			System.out.println("[error] fail create member look createMemver() ");
			e.printStackTrace();
		}    
		return result;
	}
	// compare
	public boolean compareMember(String id, String pw) {
		boolean result=false; //init
		member dto = new member();
		String query="SELECT * FROM members WHERE id=?";
		try {
			psmt=con.prepareStatement(query);
			psmt.setString(1,id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
			}
			if(dto.getPw().equals(pw)) {
				result=true;
			}
		} catch (Exception e) {
			System.out.println("[error] compareMember fail read me");
			e.printStackTrace();
		}
		return result;
	}
	
	//select
	public member selectMember(String id) {
		member user=new member();
		String userid="";
		String username="";
		String query="SELECT * FROM members WHERE id=?";
		try {
			psmt=con.prepareStatement(query);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				userid=rs.getString("id");
				username=rs.getString("name");
				user.setId(userid);
				user.setName(username);
			}
			
			System.out.println("[OK] users info select");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error] users read fail");
		}

		return user;
	}
	//update
	//delete
    public int deleteMember(String id) {
        int result = 0;
        try {
            String query = "DELETE FROM members WHERE id=?";
            psmt = con.prepareStatement(query);
            psmt.setString(0, id);
            result = psmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("게시물 삭제 중 예외 발생");
            e.printStackTrace();
        }
        return result;
    }
}
