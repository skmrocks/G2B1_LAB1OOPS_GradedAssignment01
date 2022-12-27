package com.lab01.individualgradedassignments01;

public class Department {

    private int departmentId;
    private String departmentName;
    private String departmentNameForDisplay;

    /**
     * @return the departmentId
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @return the departmentNameForDisplay
     */
    public String getDepartmentNameForDisplay() {
        return departmentNameForDisplay;
    }

    public Department(int departmentId, String departmentName, String departmentNameForDisplay){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentNameForDisplay = departmentNameForDisplay;
    }
}
