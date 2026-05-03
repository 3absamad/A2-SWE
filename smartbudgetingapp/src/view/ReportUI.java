package view;

import controle.ReportController;

public class ReportUI {
    private ReportController controller = new ReportController();

    public void showReport() {
        System.out.println("========== Financial Report ==========");
        String report = controller.generateReport();
        System.out.println(report);
        System.out.println("======================================");
    }
}