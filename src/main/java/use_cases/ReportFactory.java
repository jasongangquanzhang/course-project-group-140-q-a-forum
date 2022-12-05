package use_cases;

import entities.Report;
import entities.ReportOnCourse;
import entities.ReportOnPost;
import entities.ReportOnUser;

import java.util.Map;

public class ReportFactory {
    public Report getReport(Map<String, Object> reportInfo) {
        switch ((int) reportInfo.get("ReportType")) {
            case 0 -> {
                return new ReportOnUser((String) reportInfo.get("Username"),
                        reportInfo.get("Content"));
            }

            case 1 -> {
                return new ReportOnPost((String) reportInfo.get("Username"),
                        reportInfo.get("Content"));
            }

            case 2 -> {
                return new ReportOnCourse((String) reportInfo.get("Username"),
                        reportInfo.get("Content"));
            }
        }
        return null;
    }
}
