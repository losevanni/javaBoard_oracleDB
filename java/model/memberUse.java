package model;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import common.DBConnPool;

public class memberUse extends DBConnPool {
	public memberUse() {
		super();
	}
	//create
	public int createMember(member dto){
		int result =0;
		try {
			String query="UPDATE INTO members" 
					+"( id,pw,name)"
					+"VALUE"
					+"()";
			psmt = con.prepareStatement(query);
			psmt.setString(1,dto.getId());
			// registdate ????? 
			result=psmt.executeUpdate();
					
		} catch (Exception e) {
			System.out.println("[error] fail create member look createMemver() ");
			e.printStackTrace();
		}    
		return result;
	}
	//select
	//update
	//delete
    public int deleteMember(String id) {
        int result = 0;
        try {
            String query = "DELETE FROM members WHERE id=?";
            psmt = con.prepareStatement(query);
            psmt.setString(1, id);
            result = psmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("게시물 삭제 중 예외 발생");
            e.printStackTrace();
        }
        return result;
    }
}
