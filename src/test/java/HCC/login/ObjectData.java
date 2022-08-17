package HCC.login;

import java.util.List;

public class ObjectData {

    private String accessToken;
    private int expiresIn;
    private int employeeId;
    private List<Integer> userRoleList;
    private List<String> userRole;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<Integer> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<Integer> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public List<String> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<String> userRole) {
        this.userRole = userRole;
    }

}
