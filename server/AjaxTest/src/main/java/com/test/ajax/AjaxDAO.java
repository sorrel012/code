  package com.test.ajax;
  
  import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.my.DBUtil;
  
  public class AjaxDAO {
      
      private Connection con;
      private Statement st;
      private PreparedStatement pstat;
      private ResultSet rs;
  
      public AjaxDAO() {
          this.con = DBUtil.open();
      }
  
      public int count() {
          
          try {
              
              String sql = "select count(*) as cnt from tblMemo";
              
              st = con.createStatement();
              rs = st.executeQuery(sql);
              
              if(rs.next()) {
                  return rs.getInt("cnt");
              }
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return 0;
      }
  
      public ResearchDTO getResearch(int seq) {
          
          try {
              
              String sql = "select * from tblResearch where seq = " + seq;
              
              st = con.createStatement();
              rs = st.executeQuery(sql);
              
              if(rs.next()) {
                  
                  ResearchDTO dto = new ResearchDTO();
                  
                  dto.setSeq(rs.getString("seq"));
                  dto.setQuestion(rs.getString("question"));
                  
                  String[] item = {
                          rs.getString("item1"),
                          rs.getString("item2"),
                          rs.getString("item3"),
                          rs.getString("item4")
                  };
                  
                  String[] cnt = {
                          rs.getString("cnt1"),
                          rs.getString("cnt2"),
                          rs.getString("cnt3"),
                          rs.getString("cnt4")
                  };
                  
                  dto.setItem(item);
                  dto.setCnt(cnt);
                  
                  return dto;
              }
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return null;
      }
  
      public List<AddressDTO> listAddress() {
          
          List<AddressDTO> list= new ArrayList<AddressDTO>();
          
          try {
              
              String sql = "select * from tblAddress";
              
              st = con.createStatement();
              rs = st.executeQuery(sql);
              
              while(rs.next()) {
                  
                  AddressDTO dto = new AddressDTO();
                  
                  dto.setSeq(rs.getString("seq"));
                  dto.setName(rs.getString("name"));
                  dto.setAge(rs.getString("age"));
                  dto.setTel(rs.getString("tel"));
                  dto.setAddress(rs.getString("address"));
                  
                  list.add(dto);
              }
              
              return list;
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return list;
      }
  
      public int checkID(String id) {
          
          try {
              
              String sql = "select count(*) as cnt from tblUser where id = ?";
              
              pstat = con.prepareStatement(sql);
              pstat.setString(1, id);
              
              rs = pstat.executeQuery();
              
              if (rs.next()) {
                  return rs.getInt("cnt");
              }
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return 0;
      }
  
      public List<ZipCode> search(String dong) {
          
          List<ZipCode> list = new ArrayList<ZipCode>();
                  
          try {
              
              String sql = "select * from zipcode "
                      + "where dong like '%' || ? || '%'";
              
              pstat = con.prepareStatement(sql);
              pstat.setString(1, dong);
              
              rs = pstat.executeQuery();
              
              while(rs.next()) {
                  ZipCode dto = new ZipCode();
                  dto.setZip(rs.getString("zip"));
                  dto.setSido(rs.getString("sido"));
                  dto.setGugun(rs.getString("gugun"));
                  dto.setDong(rs.getString("dong"));
                  
                  list.add(dto);
              }
              
              return list;
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          return list;
      }
  
      public boolean checkCell(Ex11DTO dto) {
          
          try {
              
              String sql = "select count(*) as cnt from ajaxTable"
                          + " where x = ? and y = ?";
              
              pstat = con.prepareStatement(sql);
              pstat.setString(1, dto.getX());
              pstat.setString(2, dto.getY());
              
              rs = pstat.executeQuery();
              
              if(rs.next()) {
                  return rs.getInt("cnt") == 1 ? true : false;
              }
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return false;
      }
  
      public void editCell(Ex11DTO dto) {
          
          try {
              
              String sql = "update ajaxTable set ck = ? where x = ? and y = ?";
              
              pstat = con.prepareStatement(sql);
              pstat.setString(1, dto.getCk());
              pstat.setString(2, dto.getX());
              pstat.setString(3, dto.getY());
              
              pstat.executeUpdate();
              
          } catch (Exception e) {
              e.printStackTrace();
          }
  
      }
  
      public void addCell(Ex11DTO dto) {
          
          try {
              
              String sql = "insert into ajaxTable (seq, x, y, ck) values (tableseq.nextVal,?,?,'y')";
              
              pstat = con.prepareStatement(sql);
              pstat.setString(1, dto.getX());
              pstat.setString(2, dto.getY());
              
              pstat.executeUpdate();
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
      }
  
      public List<Ex11DTO> listCell() {
          
          List<Ex11DTO> list = new ArrayList<Ex11DTO>();
          
          try {
              
              String sql = "select * from ajaxTable";
              
              st = con.createStatement();
              rs = st.executeQuery(sql);
              
              
              while(rs.next()) {
                  
                  Ex11DTO dto = new Ex11DTO();
                  
                  dto.setX(rs.getString("x"));
                  dto.setY(rs.getString("y"));
                  dto.setCk(rs.getString("ck"));
                  
                  list.add(dto);
                  
              }
              
              return list;
              
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return list;
      }
  
      public void editLine(Ex12DTO dto) {
          
          try {
              
              String sql = "update tblJournal set line = ? where seq = ?";
              
              pstat = con.prepareStatement(sql);
              pstat.setString(1, dto.getLine());
              pstat.setString(2, dto.getSeq());
              
              pstat.executeUpdate();
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          
      }
  
      public List<Ex12DTO> listLine() {
          
          List<Ex12DTO> list = new ArrayList<Ex12DTO>();
          
          try {
              
              String sql = "select * from tblJournal order by seq asc";
              
              st = con.createStatement();
              rs = st.executeQuery(sql);
              
              while(rs.next()) {
                  Ex12DTO dto = new Ex12DTO();
                  dto.setSeq(rs.getString("seq"));
                  dto.setLine(rs.getString("line"));
                  list.add(dto);
              }
              
              return list;
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return list;
      }
  
      public int addProduct(Ex13DTO dto) {
          
          try {
              
              String sql = "insert into tblProduct(seq, name, price, color, pic) "
                      + "values(seqProduct.nextVal, ?, ?, ?, ?)";
              
              pstat = con.prepareStatement(sql);
              pstat.setString(1, dto.getName());
              pstat.setString(2, dto.getPrice());
              pstat.setString(3, dto.getColor());
              pstat.setString(4, dto.getPic());
              
              return pstat.executeUpdate();
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return 0;
      }
  
      public List<Ex13DTO> listProduct() {
          
          try {
              
              String sql = "select * from tblProduct order by seq desc";
              
              st = con.createStatement();
              rs = st.executeQuery(sql);
              
              List<Ex13DTO> list = new ArrayList<Ex13DTO>();
              
              while(rs.next()) {
                  
                  Ex13DTO dto = new Ex13DTO();
                  
                  dto.setSeq(rs.getString("seq"));
                  dto.setName(rs.getString("name"));
                  dto.setPrice(rs.getString("price"));
                  dto.setColor(rs.getString("color"));
                  dto.setPic(rs.getString("pic"));
                  
                  list.add(dto);
              }
              
              return list;
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return null;
      }

    public Ex13DTO getProduct() {
        
        Ex13DTO dto = new Ex13DTO();
        
        try {
            
            String sql = "select seq, pic from tblProduct"
                                + " where seq = (select max(seq) from tblProduct)";
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            if (rs.next()) {
                
                dto.setSeq(rs.getString("seq"));
                dto.setPic(rs.getString("pic"));
                
                return dto;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dto;
    }

    public int delProduct(String seq) {
        
        try {
            
            String sql = "delete from tblProduct where seq=?";
            
            pstat = con.prepareStatement(sql);
            pstat.setString(1, seq);
            
            
            return pstat.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }
  
  }
