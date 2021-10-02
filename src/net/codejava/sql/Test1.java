/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.sql;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Nafi
 */
public class Test1 {
    //table data
    
//            DefaultTableModel model = (DefaultTableModel) studentsinfotab.getModel();
//            model.setRowCount(0);
//        try{
//      
//            String sql = "SELECT * from INTERNSHIP_APPLICATION_FORM";
//            ResultSet rs = dbconnect.getStatement().executeQuery(sql);
//            while(rs.next()){
//                String id = String.valueOf(rs.getInt("StudentRegisterId"));
//                String name = rs.getString("StudentName");
//                String email = rs.getString("StudentEmail");
//                String password =  rs.getString("StudentPassword");
//                String phone = rs.getString("StudentPhoneNo");
//                String address = rs.getString("StudentAddress");
//                String deptname = rs.getString("DepartmentName");
//                String year = rs.getString("CurrentYear");
//                String semester = rs.getString("CurrentSemester");
//                String cgpa = rs.getString("CGPA");
//                String foi = rs.getString("FieldOfInterest");
//                String companypref = rs.getString("CompanyPreference");
//                String status = rs.getString("InternStatus");
//                
//                String tbData[] = {id,name,email,password,phone,address,deptname,year,semester,cgpa,foi,companypref,status};
//                DefaultTableModel tblModel = (DefaultTableModel)studentsinfotab.getModel();
//                tblModel.addRow(tbData);
//                
//            }
//           }catch(SQLException e){
//           e.printStackTrace();
//        }
//       
//         
    
//     final JPanel panel = new JPanel();
//       
//        String pass = null;
//        String sql="INSERT INTO student_accounts(StudentID,StudentName,StudentAddress,StudentEmail,Class,Section,Fee)"
//                + " VALUES("+id+"'"+name+"','','"+studentClass+"',section,pass,?)";
//    
////                                         
//        pass = EncryptPass(userPass);
//        try {
//            rs=jConnection.getStatement().executeQuery(sql);
//
////            rs.setString(1, name);
////            rs.setString(2, studentClass);
////            rs.setString(3, section);
////            rs.setString(4, pass);
////            rs.execute();
//            JOptionPane.showMessageDialog(null, "Inserted Successfully");
//            return 1;
//        }catch(SQLIntegrityConstraintViolationException ex){
//         
//            JOptionPane.showMessageDialog(panel,"Your ID should be unique.", "Warning", JOptionPane.WARNING_MESSAGE);
//            return 2;
//        } catch (HeadlessException | SQLException e) {
//            JOptionPane.showMessageDialog(panel, "Database error", "Warning", JOptionPane.WARNING_MESSAGE);
//            return 0;
//        }
    
    
//        final JPanel panel = new JPanel();
//        String table = null;
//        String sql =null;
//        if(id.equals("")||password.equals("")){
//            JOptionPane.showMessageDialog(panel, "Invalid Credentials","Warning",JOptionPane.WARNING_MESSAGE);
//            return false;
//        }else{
//            if (id.contains("100.")) {
//                table = "student_accounts";
//            } else if(id.contains("400.")){
//                table = "teacher_accounts";
//            }else{
//                JOptionPane.showMessageDialog(panel, "User not valid", "Warning", JOptionPane.WARNING_MESSAGE);
//                return false;
//            }
//            if(rememberUser == true){
//                try{
//                    if(userValid(id,password,table)){
//                        InetAddress myIP=InetAddress.getLocalHost();
//                        //Check user once logged in or not
//                        String sql2="select id from login_info where id=\'" + id + "\' and ip_address=\'" + myIP.getHostAddress() + "\'";
//                       
//                        rs=jConnection.getStatement().executeQuery(sql2);
//                        if(rs.next()){
////                            PreparedStatement  preparedStatement = jConnection.getStatement().executeQuery("update login_info set state =?  where id = \'"+id+"\' and ip_address=\'"+myIP.getHostAddress()+"\'");
////                            preparedStatement.setInt(1, 1);
//                            jConnection.getStatement().executeUpdate("update login_info set state =?  where id = \'"+id+"\' and ip_address=\'"+myIP.getHostAddress()+"\'");
////                            int update_done = preparedStatement.executeUpdate();
//                        }else{
//                            sql = "INSERT INTO login_info(id,ip_address,state) VALUES('"+id+"','"+myIP.getHostAddress()+"',"+1+")";
//                            jConnection.getStatement().executeUpdate(sql);
////                            pst.setString(1, id);
////                            pst.setString(2, myIP.getHostAddress());
////                            pst.setInt(3, 1);
////                            pst.execute();
//                        }
//                        if(id.contains("100.")){
//                            new StudentProfile(id).setVisible(true);
//                            return true;
//                        }else if(id.contains("400.")){
//                            new TeacherProfile(id).setVisible(true);
//                            return true;
//                        }
//                    }
//                }
//                catch(UnknownHostException e){
//                    JOptionPane.showMessageDialog(panel, "Sorry, Can't get your IP Address.","Warning",JOptionPane.WARNING_MESSAGE);
//                    return false;
//                }catch(SQLException e){
//                    JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
//                    return false;
//                }
//            }else{
//                if(userValid(id,password,table)){
//                    if(id.contains("100.")){
//                        new StudentProfile(id).setVisible(true);
//                        return true;
//                    }else if(id.contains("400.")){
//                        new TeacherProfile(id).setVisible(true);
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
    
}
