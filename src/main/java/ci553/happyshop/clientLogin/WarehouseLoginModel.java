package ci553.happyshop.clientLogin;

import ci553.happyshop.client.warehouse.*;
import ci553.happyshop.storageAccess.DatabaseRW;
import ci553.happyshop.storageAccess.DatabaseRWCreator;
import javafx.stage.Stage;

public class WarehouseLoginModel extends LoginModel {

    @Override
    protected void onLoginSuccess(){
        logView.close();

        DatabaseRW databaseRW = DatabaseRWCreator.createDatabaseRW();
        WarehouseView view = new WarehouseView();
        WarehouseController controller = new WarehouseController();
        WarehouseModel model = new WarehouseModel(databaseRW);

        // Link controller, model, and view and start view
        view.controller = controller;
        controller.model = model;
        model.view = view;
        view.start(new Stage());

        //create dependent views that need window info
        HistoryWindow historyWindow = new HistoryWindow();
        AlertSimulator alertSimulator = new AlertSimulator();

        // Link after start
        model.successHistoryWindow = historyWindow;
        model.alertSimulator = alertSimulator;
        historyWindow.warehouseView = view;
        alertSimulator.warehouseView = view;
    }
}
