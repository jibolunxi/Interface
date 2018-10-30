package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.csu.model.Share;


public class ShareDAO {
	private static final String GETSHARE="SELECT * FROM SHARE";
	private static final String INSERTSHARETXT="INSERT INTO SHARE(number,SHARE_TXT,FREQUENCY) VALUES (?,?,?)";
	private static final String UPDATESHARETXT="UPDATE SHARE SET FREQUENCY = FREQUENCY + 1 WHERE NUMBER = ?";
	private static final String DELETESHARETXT="DELETE FROM SHARE WHERE NUMBER = ?";
	
	public List<Share> getShare() {
		List<Share> shareList = new ArrayList<Share>();
		try {
            Connection connection = DBUtil.ConDB();
            PreparedStatement pStatement = connection
                    .prepareStatement(GETSHARE);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
            	Share share = new Share();
                share.setShare_number(resultSet.getInt(1));
                share.setShare_txt(resultSet.getString(2));
                share.setFrequency(resultSet.getInt(3));
                if(share.getFrequency() < 6) {
                	shareList.add(share);
                	share.setFrequency(share.getFrequency()+1);
        			updateShareTxt(share);
                }else {
                	deleteShareTxt(share.getShare_number());
				}
                if(shareList.size() == 6) {
                	 break;
                }
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		return shareList;
	}
	
	public void insertShareTxt(String shareTxt) {
		try{
            Connection connection= DBUtil.ConDB();
            PreparedStatement pStatement=connection.prepareStatement(INSERTSHARETXT);
            pStatement.setInt(1,(int)(Math.random()*1000000+1));
            pStatement.setString(2,shareTxt);
            pStatement.setInt(3, 0);
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
	}
	
	public void updateShareTxt(Share share) {
		try {
            Connection connection = DBUtil.ConDB();
            PreparedStatement pStatement = connection.prepareStatement(UPDATESHARETXT);
            pStatement.setInt(1, share.getShare_number());
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void deleteShareTxt(int share_number) {
		try {
			Connection connection = DBUtil.ConDB();
			PreparedStatement pStatement = connection.prepareStatement(DELETESHARETXT);
			pStatement.setInt(1, share_number);
			pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
