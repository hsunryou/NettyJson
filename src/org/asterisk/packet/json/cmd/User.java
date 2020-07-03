package org.asterisk.packet.json.cmd;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



// <editor-fold defaultstate="collapsed" desc="User">
/*

*/
// </editor-fold>

public class User {
    
    @SerializedName("grade")
    @Expose
    private String grade;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("password")
    @Expose
    private String password;

    
    private static final Logger     _Logger = LoggerFactory.getLogger(User.class);
    public User( ) {
    }
    public User( String userid, String password, String grade ) {
        this.userid = userid;
        this.password = password;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    

}
