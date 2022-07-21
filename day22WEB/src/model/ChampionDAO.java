package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChampionDAO {
	Connection conn;
	PreparedStatement pstmt;
	final String sql_insert="INSERT INTO MEMBER VALUES((SELECT NVL(MAX(MID),0)+1 FROM MEMBER),?,?,?,?)";
	public boolean insert(ChampionVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getWin());
			pstmt.setInt(3, vo.getPick());
			pstmt.setInt(4, vo.getBan());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
