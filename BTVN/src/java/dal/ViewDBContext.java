/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Entity.IDate;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tu
 */
public class ViewDBContext extends DBContext {

    public void updateView() {
        IDate now = new IDate();
        Integer viewNumber = getViewByDate(now.toString());

        if (viewNumber == null) {
            String sql = """
                         insert into ViewNumber ([date], [view]) values (?, ?)
                         """;
            try {
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setString(1, now.toString());
                stm.setInt(2, 1);
                stm.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ViewDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String sql = """
                         update ViewNumber set [view] = ? where [date] = ?
                         """;
            try {
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setInt(1, viewNumber + 1);
                stm.setString(2, now.toString());
                stm.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ViewDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Integer getViewByDate(String date) {
        try {
            String sql = """
                         select [view] from ViewNumber where [date] = ?
                         """;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, date);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("view");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getTotalView(){
        String sql = """
                     select sum([view]) as total from ViewNumber
                     """;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static void main(String[] args) {
        ViewDBContext v = new ViewDBContext();
        v.updateView();
    }
}
