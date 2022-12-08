package use_cases;

import entities.Report;

import exceptions.*;
import use_cases.DataBaseAccess.ReportDataInterface;
import use_cases.DataBaseAccess.UserDataInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ReportUseCaseInteractor{
    final ReportDataInterface reportDataInterface;
    final UserDataInterface userDataInterface;

    public ReportUseCaseInteractor(ReportDataInterface reportDataInterface, UserDataInterface userDataInterface) {
        this.reportDataInterface = reportDataInterface;
        this.userDataInterface = userDataInterface;
    }

    /**
     * Create a report and setting UserName, Report type, Report content.
     * Throw the UserNotExistException if the user does not exist in the database.
     *
     * @param reportInfo This is a Map that contains necessary information
     *                    needed to register a user. The keys must be
     *                    "Username", "ReportType", and "Content".
     */
    public void createReport(Map<String, Object> reportInfo) {

        if (!userDataInterface.userExists((String) reportInfo.get("Username"))) {
            throw new NotFoundException("Username");
        }

        reportDataInterface.addReport(new Report((String) reportInfo.get("Username"),
                (Integer) reportInfo.get("Type"),
                (String) reportInfo.get("Content")));

        try{
            reportDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }


    /**
     * Remove a Report from the current database.
     *
     * @param reportToDelete This is a report to be deleted.
     */

    public void removeReport(Report reportToDelete) {
        reportDataInterface.removeReport(reportToDelete);
        
        try{
            reportDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Report> getAllReport(){
        return reportDataInterface.getAllReport();
    }

}