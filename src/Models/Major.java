/*
 * Copyright ©️ 2024 Daniel Silva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Models;
public class Major {
    private int majorID;
    private String majorName;
    private int departmentID;

    public Major(int majorID, String majorName, int departmentID) {
        this.majorID = majorID;
        this.majorName = majorName;
        this.departmentID = departmentID;
    }

    public Major() {

    }

    public Major(Major otherMajor) {
        this.majorID = otherMajor.majorID;
        this.majorName = otherMajor.majorName;
        this.departmentID = otherMajor.departmentID;
    }

    public int getMajorID() {
        return majorID;
    }

    public String getMajorName() {
        return majorName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setMajorID(int majorID) {
        this.majorID = majorID;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "Major [majorID=" + majorID + ", majorName=" + majorName + ", departmentID=" + departmentID + "]";
    }

    
}
